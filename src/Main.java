
import control.Voler;
import model.Parcours;
import view.Affichage;
import view.Vue;

import javax.swing.JFrame;

public class Main {
	public static void main(String [] args) {
            Parcours par = new Parcours();
            par.generate();
		//JFrame: implémenter une fenêtre 
        JFrame fenetre = new JFrame("Test dessin");
                
        //créer une instance de view.Affichage et d’y ajouter le composant graphique
        Affichage aff = new Affichage();
        fenetre.add(aff);
        //assembler et rendre visible les composants
        fenetre.pack();
        fenetre.setVisible(true);

        (new Voler(aff.etat,aff)).start();
        Vue vue = new Vue(aff.etat,aff.etat.parcours);
        vue.vue(aff.getGraphics());



        //fermer la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}