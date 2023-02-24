package model;

import view.*;

import java.awt.*;

/**
 * La classe Etat définit l'état du jeu en fonction de la position de l'ovale et du parcours.
 */
public class Etat{
	/** Constantes */
	/**Hauteur actuelle de l'ovale.*/
	private int hauteur ;
	/**Hauteur de saut de l'ovale.*/
	private int jumphaut=50;
	/**Longueur de la descente de l'ovale.*/
	private static final int downlength = 30;
	/**Largeur et Hauteur de l'ovale.*/
	public static int largOval = 40;
	public static int hautOval =200;
	/**Parcours actuel du jeu.*/
	public Parcours parcours;
	/**Coordonnées x et y du centre de l'ovale */
	private int x0 ;
	private int y0 ;
	/**Indique si l'ovale est sorti de la ligne brisée.*/
	public boolean exit;


	/** Constructeur qui initialise le parcours et les variables hauteur, x0 et y0.*/
	public Etat() {
		Parcours parcours1 = new Parcours();
		this.parcours=parcours1;
		this.hauteur = parcours.points.get(1).y-hautOval/2;
		/**centreOvale (x0,y0)*/
		x0 =parcours.points.get(0).x+20;
		y0 = this.hauteur+hautOval/2;
		this.exit = testPerdu();


	}


	/**Permet de faire sauter l'ovale en augmentant sa hauteur.* */
	public void jump() {
		if (this.hauteur <= 0){
			this.hauteur= 0;
		}else{
			this.hauteur -= jumphaut;
		}
	}

	/**Permet de faire descendre l'ovale en modifiant sa hauteur.
	 * sans sortir de la zone de dessin*/
	public void moveDown(){
		if (this.hauteur + hautOval + downlength <= Fenetre.HAUT ) {
				this.hauteur += downlength;
			}
	}
	/**
	 * tester si l’ovale est sorti de la ligne brisée
	 *
	 * @return vrai si l’ovale est sorti de la ligne brisée
	 */
	public boolean testPerdu(){
		Point p1 = parcours.points.get(0);
		Point p2 = parcours.points.get(1);
		float pente = parcours.pente(p1,p2);
		x0 =parcours.points.get(0).x+20;
		y0 = this.hauteur+hautOval/2;
		float y =  pente*(x0)+((p1.y)-pente*p1.x);
		if (y0 > y + 100||y0 < y - 100){
			return true;
		}else {
			return false;
		}

	}

	public int getHauteur(){
		return hauteur;
	}



}
