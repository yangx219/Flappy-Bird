package control;

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
        while(true){
            try{
                etat.moveDown();
                /**forcer le dessin*/
                this.affichage.revalidate();
                this.affichage.repaint();
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
