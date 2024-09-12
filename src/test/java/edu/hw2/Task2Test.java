package edu.hw2;
import static org.assertj.core.api.Assertions.assertThat;
import edu.hw2.Task2.Square;
import edu.hw2.Task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class Task2Test {



    static Arguments[] rectangles() {
        Task2 t = new Task2();
        return new Arguments[]{
            Arguments.of(new Task2.Rectangle(0, 0)),
            Arguments.of(new Square(0))
        };
    }


    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Task2.Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);


        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Квадрат")
    void test2() {
        // given
        Task2 t = new Task2();
        Square squa =  new Square(0);

        // when
        squa = squa.setSide(30);

        // then
        assertThat(squa.area()).isEqualTo(900.0);
    }
}
