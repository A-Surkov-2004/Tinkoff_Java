package edu.hw8.Task1;

import java.util.List;

public class Data {

    private List<String> data = List.of(
        "Не переходи на личности там, где их нет",
        "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "Чем ниже интеллект, тем громче оскорбления"
    );

    public Data() {
        //data[] = List.of();
    }

    public List<String> getData() {
        return data;
    }
}
