import control.Avancer;
import control.Voler;
import view.Affichage;
import view.Fenetre;
/** Classe principale du jeu "Flappy Bird" */
public class Main {
	public static void main(String [] args) {
        /** Créez une instance de la vue Affichage et ajoutez-y un composant graphique */
        Affichage affichage = new Affichage();

        Fenetre fenetre = new Fenetre("Flappy bird",affichage);

        /** Démarrez plusieurs threads pour faire bouger
         * les ellipses, les lignes et les oiseaux */

        (new Voler(affichage.etat,affichage)).start();
        (new Avancer(affichage.etat,affichage.parcours,affichage,fenetre)).start();

    }
}