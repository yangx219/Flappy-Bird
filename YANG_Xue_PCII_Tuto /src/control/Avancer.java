package control;
import model.Etat;
import model.Parcours;
import view.Affichage;
import view.Fenetre;

import java.util.Timer;
import java.util.TimerTask;
/**Classe pour faire avancer la position*/
public class Avancer extends TimerTask {

    private Etat etat;
    private Affichage affichage;
    private Parcours parcours;
    private Fenetre fenetre;


    /**
     *Constructeur qui initialise les variables de l'objet Avancer
     *@param e état de la simulation
     *@param parcours parcours de la simulation
     *@param affichage vue pour afficher la simulation
     *@param fenetre fenêtre d'affichage
     */
    public Avancer(Etat e, Parcours parcours, Affichage affichage,Fenetre fenetre){
        this.parcours = parcours;
        this.etat=e;
        this.affichage = affichage;
        this.fenetre=fenetre;
    }

    /**  Vérifiez si l'ovale est hors ligne, sinon, déplacez les lignes
     * */

    @Override
    public void run() {
            while(!etat.exit){
                try{
                    etat.parcours.getParcours();
                    etat.parcours.setPosition(etat.parcours.getPosition() + 1);
                    System.out.println(etat.parcours.getPosition());
                    etat.exit = etat.testPerdu();
                    Thread.sleep(800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                /**forcer le dessin*/
                this.affichage.revalidate();
                this.affichage.repaint();
                if (etat.exit){
                    fenetre.displayGUI(etat.parcours.getPosition());
                }

            }

        }
    /**Démarre la simulation avec un délai fixe*/
    public void start() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 30, 600);
    }
}
