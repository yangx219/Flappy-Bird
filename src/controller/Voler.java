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
    /**  Vérifiez si l'ellipse est hors ligne, sinon, déplacez l'ellipse vers le bas
     * */
    @Override
    public void run(){
        while(!etat.exit){
            try{
                etat.exit = etat.testPerdu();
                etat.moveDown();

                Thread.sleep(600);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            /**forcer le dessin*/
            this.affichage.revalidate();
            this.affichage.repaint();
        }
    }



}
