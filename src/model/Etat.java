package model;

import view.Affichage;
import view.Vue;

import java.awt.*;

public class Etat{
	public int hauteur;
	public int jumphaut=20;
	public static final int downlength = 30;
	public Parcours parcours;


	/** Constructeur */
	public Etat() {
		Parcours p = new Parcours();
		this.parcours=p;



	}


	/*** augmenter la valeur de la hauteur* */

	public void jump() {
		if (this.hauteur == 0){
			this.hauteur = 0;
		}else{
			this.hauteur -= jumphaut;
		}
	}

	public void moveDown(){
		/*** modifier la valeur de la hauteur de quelques pixels vers le bas,
		 * sans sortir de la zone de dessin. */
		if (this.hauteur + Affichage.hautOval + downlength < Affichage.HAUT ) {
				this.hauteur += downlength;
			}

	}



	public void drawline(Parcours parcours, Graphics g){
		//parcours.points = parcours.generate();
		while (true) {
			parcours.points = parcours.generate();
			for (int i = 0; i < parcours.points.size()-2; i++) {

				g.drawLine(parcours.points.get(i).x, parcours.points.get(i).y, parcours.points.get(i + 1).x, parcours.points.get(i + 1).y);
				//g.drawLine(parcours.points.get(i+1).x, parcours.points.get(i).y, parcours.points.get(i + 2).x, parcours.points.get(i + 2).y);
			}
		}
	}

	public int getHauteur(){
		return hauteur;
	}



}
