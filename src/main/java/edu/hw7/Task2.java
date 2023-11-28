package edu.hw7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {

    private final static Logger LOGGER = LogManager.getLogger();

    public Task2() {

    }

    public BigInteger factorial(long n) {

        List<BigInteger> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(BigInteger.valueOf(i));
        }
        BigInteger ans = (numbers.stream().reduce(BigInteger.valueOf(1), BigInteger::multiply));

        return ans;
    }
}
