package edu.hw2;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("Стандартный")
    void test1() throws Exception {
        Task3 t = new Task3();
        Task3.PopularCommandExecutor executor = t.new PopularCommandExecutor(new Task3.ConnectionManager.DefaultConnectionManage(), 5);
        executor.tryExecute("cmd");
    }

    @Test
    @DisplayName("Проблемный")
    void test2() throws Exception {
        Task3 t = new Task3();
        Task3.PopularCommandExecutor executor = t.new PopularCommandExecutor(new Task3.ConnectionManager.FaultyConnectionManager(), 5);
        executor.tryExecute("cmd");
    }

    @Test
    @DisplayName("Проблемный+ (no retry)")
    void test3() throws Exception {
        Task3 t = new Task3();
        Task3.PopularCommandExecutor executor = t.new PopularCommandExecutor(new Task3.ConnectionManager.FaultyConnectionManager(), 0);
        executor.tryExecute("cmd");
    }

    @Test
    @DisplayName("Проблемный 10x")
    void test4() throws Exception {
        Task3 t = new Task3();
        Task3.PopularCommandExecutor executor = t.new PopularCommandExecutor(new Task3.ConnectionManager.FaultyConnectionManager(), 5);
        for (int i = 0; i < 10; i++){executor.tryExecute("cmd");}
    }
}
