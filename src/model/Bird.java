package model;

import view.Affichage;
import view.Fenetre;
import view.VueOiseau;

import java.util.Random;

public class Bird {
    /**indique le temps (en millisecondes) entre chaque mise à jour de l’affichage pour l’oiseau*/
    public int delai;

    /**permet de savoir dans quelle position est l’oiseau*/
    public String etat;
    /**définit la hauteur de l’oiseau dans la fenêtre graphique */
    public int hauteur;

    /**définit l’abscisse.*/
    public int position;
    public Affichage affichage;

    public VueOiseau vueOiseau;

    public Bird() {
        Random rand = new Random();
        this.delai = rand.nextInt(500);
        this.hauteur = rand.nextInt(Fenetre.HAUT);
        this.position = 600;

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
