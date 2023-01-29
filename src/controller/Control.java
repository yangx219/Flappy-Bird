package controller;

import model.Etat;
import view.Affichage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    private Etat etat;
    private Affichage affichage;
    private Voler voler;

    /** Constructeur */
    public Control(Etat etat, Affichage affichage) {
        this.etat = etat;
        this.affichage = affichage;


    }

    /** package java.awt.event: chaque événement (clavier, souris, etc)
     *  dont le système d’exploitation est informé peut être retransmis
     *  au programme pour qu’il puisse y réagir.
     *
     *  Il existe autant d’événements que de types d’interaction:
     *  ActionEvent, AdjustmentEvent, ComponentEvent, ContainerEvent, FocusEvent, etc.
     *
     *  mouseClicked est appelée chaque fois que l’utilisateur clique dans la zone d’affichage.
     * */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (!etat.exit){
            etat.exit = etat.testPerdu();
            System.out.println("control");
            etat.jump();
            affichage.repaint();
        }

    }

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

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Affichage getAffichage() {
        return affichage;
    }

    public void setAffichage(Affichage affichage) {
        this.affichage = affichage;
    }
}
