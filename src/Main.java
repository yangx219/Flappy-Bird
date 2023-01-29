import controller.Avancer;
import controller.Voler;
import view.Affichage;
import view.Fenetre;

import java.awt.*;

public class Main {
	public static void main(String [] args) {
        //créer une instance de view.Affichage et d’y ajouter le composant graphique
        Affichage affichage = new Affichage();
        Fenetre fenetre = new Fenetre("Flappy bird",affichage);


       //if (!affichage.etat.testPerdu()){
           (new Voler(affichage.etat,affichage)).start();
           (new Avancer(affichage.etat,affichage.parcours,affichage,fenetre)).start();
        //}else {
           // affichage.gameOver(affichage.getGraphics());
        //}


        //Parcours par = new Parcours();
        //par.generate();
          /**
        //assembler et rendre visible les composants
        fenetre.pack();
        fenetre.setVisible(true);


        //Vue vue = new Vue(aff.etat,aff.etat.parcours);
        //vue.vue(aff.getGraphics());



        //fermer la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           */
    }
}