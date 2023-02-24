package control;

import model.Etat;
import view.Affichage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Voler {
    /** le modèle */
    private Etat etat;
    private Affichage affichage;

    /** Constructeur */
    public Voler(Etat etat, Affichage affichage) {
        this.etat = etat;
        this.affichage = affichage;
        initTimer();
    }

    private void initTimer() {
        Timer timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!etat.exit) {
                    etat.exit = etat.testPerdu();
                    etat.moveDown();
                    /** forcer le dessin */
                    affichage.revalidate();
                    affichage.repaint();
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public void start() {
    }
}
