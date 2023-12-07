package edu.hw9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.management.monitor.Monitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {
    public class StatsCollector {

        private final static Logger LOGGER = LogManager.getLogger();
        Map<String, Stats> results = new HashMap<>();
        Map<String, List<Double>> allData = new HashMap<>();

        StatsCollector() {

        }

        public void push(String name, double[] data) {
            AtomicInteger i = new AtomicInteger(0);
            allData.putIfAbsent(name, new ArrayList<>());
            List<Double> currentData = Collections.synchronizedList(allData.get(name));
            Callable<?> task1 = () -> currentData.add(data[i.getAndIncrement()]);
            try (ExecutorService service = Executors.newFixedThreadPool(2)) { // ?
                while (i.get() < data.length) {
                    service.submit(task1);
                }
                allData.put(name, currentData);
            }
            recalculate(name);
        }

        public Stats stats(String name) {
            return results.get(name);
        }

        public Set<String> metrics() {
            return results.keySet();
        }

        private void recalculate(String name) {
            List<Double> data = allData.get(name);

            Callable<Double> task1 = () -> getSum(data);
            Callable<Double> task2 = () -> getArmean(data);
            Callable<Double> task3 = () -> getMax(data);
            Callable<Double> task4 = () -> getMin(data);

            double sum = 0;
            double armean = 0;
            double max = 0;
            double min = 0;
            try (ExecutorService service = Executors.newFixedThreadPool(4)) {
                Future<Double> result1 = service.submit(task1);
                Future<Double> result2 = service.submit(task2);
                Future<Double> result3 = service.submit(task3);
                Future<Double> result4 = service.submit(task4);

                sum = result1.get();
                armean = result2.get();
                max = result3.get();
                min = result4.get();
            } catch (ExecutionException | InterruptedException e) {
                LOGGER.error(e);
            }

            results.put(name, new Stats(sum, armean, max, min));
        }

        private double getSum(List<Double> data) {

            double ans = 0;
            for (double i : data) {
                ans += i;
            }
            return ans;
        }

        private double getArmean(List<Double> data) {
            return getSum(data) / data.size();
        }

        private double getMax(List<Double> data) {

            if (data.isEmpty()) {
                return 0;
            }

            double ans = data.get(0);
            for (double i : data) {
                if (ans < i) {
                    ans = i;
                }
            }
            return ans;
        }

        private double getMin(List<Double> data) {

            if (data.isEmpty()) {
                return 0;
            }

            double ans = data.get(0);
            for (double i : data) {
                if (ans > i) {
                    ans = i;
                }
            }
            return ans;
        }

        public record Stats(double sum, double armean, double max, double min) {
        }
    }
}
