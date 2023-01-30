package view;

import javax.swing.*;
import java.awt.*;

public class Fenetre {
    /* Constantes */
    public static int LARGE = 800;
    public static int HAUT = 600;
    private JFrame frame;
    public Fenetre(String title, Affichage affichage) {
        /**JFrame: implémenter une fenêtre*/
        JFrame frame = new JFrame();
        this.frame = frame;

        /**ajouter le composant graphique*/
        frame.add(affichage);
        frame.setTitle(title);

        /**Définir ses dimensions (largeur et hauteur) */
        frame.setMaximumSize(new Dimension(LARGE, HAUT));
        frame.setMinimumSize(new Dimension(LARGE, HAUT));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        /**assembler et rendrer visible les composants*/
        frame.pack();
        frame.setVisible(true);
        /**fermer la fenêtre*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    /**
     * Un message s’affiche avec le score de l’utilisateur.
     *
     * @param positon     le score du joueur à la fin de le jeu
     */
    public void displayGUI(int positon) {
        JOptionPane.showMessageDialog(this.frame,
                "" + positon,
                "Your position is",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
