package view;

import controller.Control;
import controller.Voler;
import model.Bird;
import model.Etat;
import model.Parcours;

import java.awt.*;
import javax.swing.JPanel;

import static view.VueOiseau.drawBird;

/** @author YANG Xue L3 info_miage(PCII)*/

//devoir se déclarer comme listener pour ce type d’événement
public class Affichage extends JPanel {

        //private static final long serialVersionUID = 1L;


      public Parcours parcours;
        
      public static Etat etat;
      public Voler voler;
       public Control control;

       private VueOiseau vueOiseau;
       private Bird bird;


        
        /** Constructeur */
        public Affichage() {
        	etat = new Etat();
            control = new Control(etat, this);
			this.addMouseListener(control);
            parcours = new Parcours();
            this.vueOiseau = new VueOiseau();
            this.bird=new Bird();
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
                g.setColor(Color.blue);
                g.drawOval(parcours.points.get(0).x, etat.getHauteur(), etat.largOval, etat.hautOval);
                g.setColor(Color.black);
                paintParcours(g);
                paintBird(g);

        }


        /**on connecte tous les points du Liste*/
        public void paintParcours(Graphics g){

            for (int i = 0; i < this.etat.parcours.points.size() - 1; i++) {
                Point p1 = this.etat.parcours.points.get(i);
                Point p2 = this.etat.parcours.points.get(i+1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        public void paintBird(Graphics g){
            Bird bird = new Bird();
            this.vueOiseau.birds.add(bird);
            for (int i=1; i <= 8; i++){
                drawBird(g,bird.getPosition(),bird.getHauteur(),i);
            }
        }





 }