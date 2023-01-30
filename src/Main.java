import controller.Avancer;
import controller.Voler;
import view.Affichage;
import view.Fenetre;
import view.VueOiseau;

import java.awt.*;

public class Main {
	public static void main(String [] args) {
        /**créer une instance de view.Affichage et d’y ajouter le composant graphique*/
        Affichage affichage = new Affichage();

        Fenetre fenetre = new Fenetre("Flappy bird",affichage);

        /**Démarrez plusieurs threads pour faire bouger
         * les ellipses, les lignes et les oiseaux*/
        (new Voler(affichage.etat,affichage)).start();
        (new Avancer(affichage.etat,affichage.parcours,affichage,fenetre)).start();

    }
}