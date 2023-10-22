package edu.hw2;


import static edu.hw2.Task1.Expr;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Константа")
    void test1() {
        // given
        Expr.Constant two = new Expr.Constant(2);

        // when
        double ans = two.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Отрицательное")
    void test2() {
        // given
        var neg = new Expr.Negate(new Expr.Constant(2));

        // when
        double ans = neg.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(-2);
    }

    @Test
    @DisplayName("Возведение в степень")
    void test3() {
        // given
        Expr.Constant two = new Expr.Constant(2);

        // when
        var exp = new Expr.Exponent(two, 3);
        double ans = exp.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(8);
    }

    @Test
    @DisplayName("Сложение")
    void test4() {
        // given
        Expr.Constant two = new Expr.Constant(2);
        Expr.Constant four = new Expr.Constant(4);

        // when
        var ad = new Expr.Addition(two, four);
        double ans = ad.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Умножение")
    void test5() {
        // given
        Expr.Constant two = new Expr.Constant(2);
        Expr.Constant four = new Expr.Constant(4);

        // when
        var mult = new Expr.Multiplication(two, four);
        double ans = mult.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(8);
    }

    @Test
    @DisplayName("Сложная функция")
    void test6() {
        // given
        Expr.Constant two = new Expr.Constant(2);
        Expr.Constant four = new Expr.Constant(4);


        // when
        var ad = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(ad, four);
        double ans = mult.evaluate();

        // then
        assertThat(ans)
            .isEqualTo(24);
    }

}
