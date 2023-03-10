package control;

import model.Etat;
import view.Affichage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Classe de contrôle */
public class Control implements MouseListener {
    private Etat etat;
    private Affichage affichage;
    private Voler voler;

    /** Constructeur */
    public Control(Etat etat, Affichage affichage) {
        this.etat = etat;
        this.affichage = affichage;
    }

    /**
     *  mouseClicked est appelée chaque fois que l’utilisateur clique dans la zone d’affichage
     *  @param e est une intance de la classe java.awt.MouseEvent
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!etat.exit){
            etat.exit = etat.testPerdu();
            //System.out.println("control");
            etat.jump();
            affichage.repaint();
        }

    }


    /** Implémentation vide des méthodes MouseListener */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
