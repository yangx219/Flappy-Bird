package controller;

import model.Etat;
import view.Affichage;


public class Voler extends Thread {
    /**le modèle*/
    private Etat etat;
    private Affichage affichage;

    /** Constructeur */
    public Voler(Etat etat, Affichage affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }
    @Override
    public void run(){
        while(!etat.exit){
            try{
                etat.exit = etat.testPerdu();
                etat.moveDown();
                /**forcer le dessin*/
                this.affichage.revalidate();
                this.affichage.repaint();
                Thread.sleep(800);
            }catch (InterruptedException e){
                e.printStackTrace();
            }



        }
    }



}
