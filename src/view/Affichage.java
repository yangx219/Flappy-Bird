package view;

import control.Control;
import control.Voler;
import model.Etat;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

 /** @author YANG Xue L3 info_miage(PCII)*/

//devoir se déclarer comme listener pour ce type d’événement
public class Affichage extends JPanel {

        private static final long serialVersionUID = 1L;
		/* Constantes */
        public static final int LARG = 600;
        public static final int HAUT = 400;
        public  static int x = 0;
        public  static int y = 40;
        public static int largOval = 40;
        public static int hautOval =60;
        
        public Etat etat;
        public Voler voler;
        private Control control;
        
        /** Constructeur */
        public Affichage() {
            /**Définir ses dimensions (largeur et hauteur) */
        	setPreferredSize(new Dimension(LARG, HAUT));
        	etat = new Etat();
			control = new Control(etat, this);
			this.addMouseListener(control);
        }
		
        /** le système d’exploitation appelle cette méthode à chaque fois 
         *  qu’il a besoin de mettre à jour l’affichage
         *  @param g est une intance de la classe java.awt.Graphics
         */
		@Override
        public void paint(Graphics g) {
        	super.paint(g);
        	/**dessiner un ovale noir dans l'affichage.*/
            //System.out.println(etat.getHauteur());
        	g.drawOval(x, etat.getHauteur(), largOval, hautOval);
        }


     @Override
     public int getY() {
         return y;
     }

 }