package view;
import model.Bird;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe de visualisation de l'oiseau
 */
public class VueOiseau extends JPanel{
    /**
     * La liste d'oiseaux
     */
    public ArrayList<Bird> birds = new ArrayList<>();
    /**
     * Les chemins d'accès aux images des oiseaux
     */
    public static String bird1="src/view/image/1.jpg";
    public static String bird2="src/view/image/2.jpg";
    public static String bird3= "src/view/image/3.jpg";
    public static String bird4="src/view/image/4.jpg";
    public static String bird5="src/view/image/5.jpg";
    public static String bird6="src/view/image/6.jpg";
    public static String bird7="src/view/image/7.jpg";
    public static String bird8="src/view/image/8.jpg";


    /**
     * Constructeur de la classe
     */
    public void VueOiseau(){

    }
    /**
     * Dessinez l'image de l'oiseau dans le programme en fonction du numéro de série
     *
     * @param g     le contexte graphique
     * @param x     l'abscisse de l'image
     * @param y     la coordonnée verticale de l'image
     * @param imageNB  le numéro de l'image
     */
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

    /**
     * Dessinez l'image de l'oiseau dans le programme en fonction de l'adresse de l'image
     *
     * @param g     le contexte graphique
     * @param x     l'abscisse de l'image
     * @param y     la coordonnée verticale de l'image
     * @param adr  l'adresse de l'image
     */
    private static void putImage(Graphics g, int x, int y, String adr) {
        ImageIcon icon = new ImageIcon(adr);
        Image image = icon.getImage();
        g.drawImage(image, x, y, 100,100,null );
    }


}
