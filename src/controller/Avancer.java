package controller;

import model.Etat;
import model.Parcours;
import view.Affichage;
import view.Fenetre;

/**faire avancer la position*/
public class Avancer extends Thread{

    private Etat etat;
    private Affichage affichage;
    private Parcours parcours;
    private Fenetre fenetre;

    public Avancer(Etat e,Parcours p1,Affichage affichage,Fenetre fenetre){
        this.parcours = p1;
        this.etat=e;
        this.affichage = affichage;
        this.fenetre=fenetre;

    }

    public void run(){
        System.out.println(etat.exit);
        while(!etat.exit){
            try{
                etat.parcours.getParcours();
                etat.parcours.setPosition(etat.parcours.getPosition() + 1);
                System.out.println(etat.parcours.getPosition());
                //System.out.println(etat.exit);
                etat.exit = etat.testPerdu();

                /**forcer le dessin*/
                this.affichage.revalidate();
                this.affichage.repaint();
                Thread.sleep(800);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if (etat.exit){
                fenetre.displayGUI(etat.parcours.getPosition());
            }

        }
    }



}
