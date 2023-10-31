package edu.hw2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {

    private final static Logger LOGGER = LogManager.getLogger();

    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        public record Negate(Expr arg) implements Expr {
            @Override
            public double evaluate() {
                return arg.evaluate() * -1;
            }
        }

        public record Exponent(Expr number, int power) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(number.evaluate(), power);
            }
        }

        public record Addition(Expr first, Expr second) implements Expr {
            @Override
            public double evaluate() {
                return first.evaluate() + second.evaluate();
            }
        }

        public record Multiplication(Expr first, Expr second) implements Expr {
            @Override
            public double evaluate() {
                return first.evaluate() * second.evaluate();
            }
        }
    }
}
