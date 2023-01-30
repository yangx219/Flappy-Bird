package view;

import controller.Avancer;
import controller.Voler;

import javax.swing.*;
import java.awt.*;

public class Fenetre {
    /* Constantes */
    public static int LARGE = 800;
    public static int HAUT = 600;
    private JFrame frame;
    private Affichage affichage;
    private VueOiseau vueOiseau;
    //public VueOiseau vueOiseau;
    public Fenetre(String title, Affichage affichage) {
        //JFrame: implémenter une fenêtre
        JFrame frame = new JFrame();
        this.frame = frame;
        this.affichage = affichage;

        //ajouter le composant graphique
        frame.add(affichage);
        //frame.add(vueOiseau);
        frame.setTitle(title);
        //fermer la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /**Définir ses dimensions (largeur et hauteur) */
        frame.setMaximumSize(new Dimension(LARGE, HAUT));
        frame.setMinimumSize(new Dimension(LARGE, HAUT));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        /**assembler et rendre visible les composants*/
        frame.pack();
        frame.setVisible(true);

    }
    public void displayGUI(int positon) {
        JOptionPane.showMessageDialog(this.frame,
                "" + positon,
                "Your position is",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
