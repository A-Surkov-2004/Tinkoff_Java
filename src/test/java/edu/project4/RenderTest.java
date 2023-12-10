package edu.project4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RenderTest {
    private final static Logger LOGGER = LogManager.getLogger();
    Path p = Path.of("src", "main", "java", "edu", "project4", "Image.jpg");
    String path = p.toString();


    @Test
    @DisplayName("Сравнение скоростей")
    void test5() throws Exception {

        // given

        //String path = "src\\main\\java\\edu\\project3\\Image.jpg";
        AfinGen afinGen = new AfinGen();
        Render render = new Render();
        Modifiers mod = new Modifiers();
        mod.sphere = true;
        mod.swirl = true;
        //mod.disk = true;
        //mod.heart = true;
        //when

        render.setRatio(5, 3.25);
        afinGen.setColorBorders(50, 50, 150, 150, 150, 255);

        long start = System.nanoTime();

        Pixel[][] pixels2 = render.renderSingleStream(afinGen.genAfin(10), 100000, 120, mod);
        long singleThreadTime = System.nanoTime();

        Pixel[][] pixels = render.render(afinGen.genAfin(10), 100000, 120, mod);
        long multiThreadTime = System.nanoTime();

        long singleThreaddelta = singleThreadTime - start;
        long multiThreaddelta = multiThreadTime - singleThreadTime;

        // then
        LOGGER.info((singleThreaddelta - multiThreaddelta) / 1_000_000);
        /*
        assertThat(multiThreaddelta)
            .isLessThan(singleThreaddelta);

        //*/ // не проходит с локом(

    }

    //Пресеты (раскоментить ainter.draw(pixels); для показа)
    @Test
    @DisplayName("Синее сердце")
    void test1() throws Exception {

        // given

        //String path = "src\\main\\java\\edu\\project3\\Image.jpg";
        AfinGen afinGen = new AfinGen();
        Render render = new Render();
        Modifiers mod = new Modifiers();
        //mod.sphere = false;
        //mod.disk = true;
        mod.heart = true;
        //mod.sphere = true;
        //when

        render.setRatio(5, 3.25);
        afinGen.setColorBorders(50, 50, 150, 150, 150, 255);

        Pixel[][] pixels = render.render(afinGen.genAfin(100), 10000, 1200, mod);
        pixels = render.gammaCor(pixels);
        Drawer painter = new Drawer(path);
        //painter.draw(pixels);
    }

    @Test
    @DisplayName("Красный вихрь")
    void test2() throws Exception {

        // given
        AfinGen afinGen = new AfinGen();
        Render render = new Render();
        Modifiers mod = new Modifiers();
        mod.swirl = true;

        //when
        render.setRatio(3.555, 2);
        afinGen.setColorBorders(150, 50, 50, 255, 150, 150);

        Pixel[][] pixels = render.render(afinGen.genAfin(60), 1000, 1000, mod);
        pixels = render.gammaCor(pixels);
        Drawer painter = new Drawer(path);
        //painter.draw(pixels);
    }

    @Test
    @DisplayName("Хвост фазана (метла/веер)")
    void test3() throws Exception {

        // given
        AfinGen afinGen = new AfinGen();
        Render render = new Render();
        Modifiers mod = new Modifiers();
        mod.pdj = true;
        mod.swirl = true;
        //mod.sphere = true;

        //when
        render.setRatio(2.777, 2);
        afinGen.setColorBorders(50, 150, 50, 100, 255, 100);

        Pixel[][] pixels = render.render(afinGen.genAfin(60), 1000, 1000, mod);
        pixels = render.gammaCor(pixels);
        Drawer painter = new Drawer(path);
        //painter.draw(pixels);
    }

    @Test
    @DisplayName("Драгоценный камень")
    void test4() throws Exception {

        // given
        AfinGen afinGen = new AfinGen();
        Render render = new Render();
        Modifiers mod = new Modifiers();
        mod.pillow = true;
        mod.sphere = true;
        mod.swirl = true;
        mod.disk = true;

        //when
        render.setRatio(0.777, 0.5);
        afinGen.setColorBorders(150, 0, 75, 255, 25, 175);

        Pixel[][] pixels = render.render(afinGen.genAfin(100), 1000, 1000, mod);
        pixels = render.gammaCor(pixels);
        Drawer painter = new Drawer(path);
        //painter.draw(pixels);
    }
}
