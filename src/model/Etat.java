package model;

import view.*;

import java.awt.*;

public class Etat{
	/** Constantes */
	public int hauteur ;
	public int jumphaut=50;
	public static final int downlength = 30;
	public static int largOval = 40;
	public static int hautOval =200;
	public Parcours parcours;
	private int x0 ;
	private int y0 ;
	public boolean exit;


	/** Constructeur */
	public Etat() {
		Parcours parcours1 = new Parcours();
		this.parcours=parcours1;
		this.hauteur = parcours.points.get(1).y-hautOval/2;
		/**centreOvale (x0,y0)*/
		x0 =parcours.points.get(0).x+20;
		y0 = this.hauteur+hautOval/2;
		this.exit = testPerdu();


	}


	/**augmenter la valeur de la hauteur* */
	public void jump() {
		if (this.hauteur <= 0){
			this.hauteur= 0;
		}else{
			this.hauteur -= jumphaut;
		}
	}

	/**permet de modifier la valeur de la hauteur de quelques pixels vers le bas,
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
