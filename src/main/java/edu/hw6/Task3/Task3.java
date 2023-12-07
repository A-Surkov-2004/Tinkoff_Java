package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {

    private final static Logger LOGGER = LogManager.getLogger();

    public static final AbstractFilter IS_REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter IS_READABLE = Files::isReadable;




    public List<Path> search(Path p, DirectoryStream.Filter<Path> filter) {

        Path dir = p;
        List<Path> result = new ArrayList<>();

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            //entries.forEach(System.out::println);
            entries.forEach(result::add);
            LOGGER.info(result);
        } catch (Exception e) {

        }
        return result;
    }

    public SizeFilter largerThan(int n) {
        return new SizeFilter(n);
    }

    public GlobFilter globMatches(String n) {
        return new GlobFilter(n);
    }

    public RegFilter regexContains(String reg) {
        return new RegFilter(reg);
    }

    public MagicFilter magicNumber(int code, char... chars) {
        return new MagicFilter(code, chars);
    }

    public interface AbstractFilter extends DirectoryStream.Filter<Path> {

        // TODO
        default AbstractFilter and(AbstractFilter filter) {
            return new AndFilter(this, filter);
        }
    }

}
