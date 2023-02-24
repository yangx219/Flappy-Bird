package model;

import view.Fenetre;

import java.util.Random;

public class Bird {
    /**indique le temps (en millisecondes) entre chaque mise à jour de l’affichage pour l’oiseau*/
    public static int delai;

    /**permet de savoir dans quelle position est l’oiseau*/
    private int etat;
    /**définit la hauteur de l’oiseau dans la fenêtre graphique */
    private int hauteur;

    /**définit l’abscisse de l'oiseau*/
    private int position;

    public Bird() {
        Random rand = new Random();
        this.delai = rand.nextInt(50);
        this.hauteur = rand.nextInt(Fenetre.HAUT);
        this.position = rand.nextInt(Fenetre.LARGE);;
        this.etat=this.position;

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
