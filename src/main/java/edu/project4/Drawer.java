package edu.project4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import java.util.concurrent.TimeUnit;

public class Drawer {

    String imagePath;
    BufferedImage myPicture;
    Graphics2D g;

    Drawer(String imPath) throws IOException {
        imagePath = imPath;
        myPicture = ImageIO.read(new File(imagePath));
        g = (Graphics2D) myPicture.getGraphics();
        g.setStroke(new BasicStroke(1F));
    }

    private final static Logger LOGGER = LogManager.getLogger();

    void draw(Pixel[][] pixels) throws InterruptedException {
        for (int i = 0; i < pixels.length; i++) { // № строки == y
            for (int j = 0; j < pixels[i].length; j++) { // № стобеца == x
                if (pixels[i][j] != null) {
                    Color curColor = new Color(pixels[i][j].r, pixels[i][j].g, pixels[i][j].b);
                    g.setColor(curColor);
                    g.drawRect(j, i, 1, 1);
                }
            }
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);
        JFrame f = new JFrame();
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);

        /*
        while (f.isActive()) {
            TimeUnit.SECONDS.sleep(1);
        }

         //*/ // раскоментить для просмотра (+ импорт)

        //TimeUnit.SECONDS.sleep(30);
    }
}
