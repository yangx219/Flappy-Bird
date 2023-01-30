package controller;

import model.Bird;
import model.Etat;
import view.Affichage;
import view.Fenetre;
import view.VueOiseau;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Oiseau extends Thread{
    /**indique le temps (en millisecondes) entre chaque mise à jour de l’affichage pour l’oiseau*/
    private int delai;

    /**permet de savoir dans quelle position est l’oiseau*/
    public Etat etat;
    /**définit la hauteur de l’oiseau dans la fenêtre graphique */
    public int hauteur;

    /**définit l’abscisse.*/
    public int position;

    public Affichage affichage;

    public VueOiseau vueOiseau;


    public Oiseau() {
        Random rand = new Random();
        this.delai = rand.nextInt(1000);
        //this.affichage = affichage;
       // this.etat = affichage.etat;
        this.hauteur = rand.nextInt(Fenetre.HAUT);
        this.position = 0;
        this.vueOiseau= new VueOiseau();
    }

        @Override
        public void run() {
            while (true) {
                try {


                    this.vueOiseau.revalidate();
                    this.vueOiseau.repaint();
                    Thread.sleep(delai);

                }
                catch (InterruptedException e) { e.printStackTrace(); }
                }


        }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
