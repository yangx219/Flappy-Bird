package view;

import controller.Oiseau;
import model.Bird;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VueOiseau extends JPanel{
    ArrayList<Bird> birds = new ArrayList<>();
    private Affichage affichage;
    private Bird bird;
    public static String bird1="src/view/image/1.png";
    public static String bird2="src/view/image/2.png";
    public static String bird3="src/view/image/3.png";
    public static String bird4="src/view/image/4.png";
    public static String bird5="src/view/image/5.png";
    public static String bird6="src/view/image/6.png";
    public static String bird7="src/view/image/7.png";
    public static String bird8="src/view/image/8.png";


    public void VueOiseau(){
        this.bird = new Bird();


    }

    public  static void drawBird(Graphics g, int x, int y, int imageNB){

        switch (imageNB){
            case 1: putImage(g,x,y,bird1);
            case 2: putImage(g,x,y,bird2);
            case 3: putImage(g,x,y,bird3);
            case 4: putImage(g,x,y,bird4);
            case 5: putImage(g,x,y,bird5);
            case 6: putImage(g,x,y,bird6);
            case 7: putImage(g,x,y,bird7);
            case 8: putImage(g,x,y,bird8);
        }
    }

    private static void putImage(Graphics g, int x, int y, String bird) {
        ImageIcon icon = new ImageIcon(bird);
        Image image = icon.getImage();
        g.drawImage(image, x, y, 100,100,null );
    }


}
