package edu.hw9.Task2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();
    private final List<Path> answers = new ArrayList<>();

    public List<Path> filesMoreThenN(Path p, int n) {
        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfProcessors);

        final ForkJoinTask<Integer> result = forkJoinPool.submit(new MoreThenN(p, n));
        result.join();
        return answers;
    }

    public List<Path> findGlob(Path p, String glob) {
        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        final ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfProcessors);

        final ForkJoinTask<Integer> result = forkJoinPool.submit(new FindGlob(p, glob));
        result.join();
        return answers;
    }

    private class MoreThenN extends RecursiveTask<Integer> {

        private final Path p;
        private final int n;

        private MoreThenN(Path p, int n) {
            this.p = p;
            this.n = n;
        }

        @Override
        protected Integer compute() {

            List<Path> result = new ArrayList<>();
            int counter = 0;

            try (DirectoryStream<Path> entries = Files.newDirectoryStream(p)) {

                entries.forEach(result::add);

                for (Path i : result) {
                    if (Files.isDirectory(i)) {

                        MoreThenN f = new MoreThenN(i, n);
                        counter += f.compute();
                    } else {
                        counter++;
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e);
            }
            if (counter > n) {
                answers.add(p);
            }
            return counter;
        }
    }

    private class FindGlob extends RecursiveTask<Integer> {

        private final Path p;
        private final String glob;

        private FindGlob(Path p, String glob) {
            this.p = p;
            this.glob = glob;
        }

        @Override
        protected Integer compute() {

            List<Path> result = new ArrayList<>();

            try (DirectoryStream<Path> entries = Files.newDirectoryStream(p)) {

                entries.forEach(result::add);

                for (Path i : result) {
                    if (Files.isDirectory(i)) {

                        FindGlob f = new FindGlob(i, glob);
                        f.fork();
                        f.join();
                    } else {
                        if (Pattern.matches("." + glob + "$", i.toString())) {
                            answers.add(i);
                        }
                    }
                }
            } catch (Exception e) {
                LOGGER.error(e);
            }
            return 1;
        }
    }
}
