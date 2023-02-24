package view;

import control.Control;
import model.Bird;
import model.Etat;
import model.Parcours;

import java.awt.*;
import java.io.IOException;
import javax.swing.JPanel;

import static view.VueOiseau.drawBird;

/**
 * Classe Affichage qui hérite de JPanel pour afficher l'interface graphique.
 * @author YANG Xue L3 info_miage(PCII)
 * */
public class Affichage extends JPanel {
    /** Attribut de l'objet*/
    public Parcours parcours;
    public static Etat etat;
    public Control control;
    private VueOiseau vueOiseau;
    private PerlinNoise perlinNoise;
    /**
     * Constructeur de la classe Affichage.
     * Initialise l'objet Etat, Control, Parcours, VueOiseau et PerlinNoise.
     * Enregistre un MouseListener pour control.
     */
    public Affichage() {
        etat = new Etat();
        control = new Control(etat, this);
        this.addMouseListener(control);
        parcours = new Parcours();
        this.vueOiseau = new VueOiseau();
        this.perlinNoise = new PerlinNoise(etat.largOval,etat.hautOval);

    }
    /** Méthode paint qui est appelée par le système d'exploitation à chaque mise à jour de l'affichage.
     * @param g instance de la classe java.awt.Graphics
     */
    public void paint(Graphics g) {
        super.paint(g);
        /**dessiner un ovale bleu*/
        g.setColor(Color.blue);
        g.drawOval(parcours.points.get(0).x, etat.getHauteur(), etat.largOval, etat.hautOval);
        /**dessiner les lignes noirs*/
        g.setColor(Color.black);
        paintParcours((Graphics2D) g);
        /**dessiner l'oiseau*/
        try {
            paintBird((Graphics2D) g);
            paintBird((Graphics2D) g);
       } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.perlinNoise.drawClouds(this.perlinNoise.generatePerlinNoise(), (Graphics2D) g);
    }




    /** connecter tous les points de la Liste
     *  @param g est une intance de la classe java.awt.Graphics
     */
    public void paintParcours(Graphics2D g){

        for (int i = 0; i < this.etat.parcours.points.size() - 1; i++) {
            Point p1 = this.etat.parcours.points.get(i);
            Point p2 = this.etat.parcours.points.get(i+1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);

        }
    }

    /** dessiner toutes les images de l'oiseau
     *  @param g est une intance de la classe java.awt.Graphics
     */
    public void paintBird(Graphics2D g) throws IOException, InterruptedException {
        Bird bird = new Bird();
        this.vueOiseau.birds.add(bird);
        for (int i=1; i <= 8; i++){
            drawBird(g,bird.getPosition(),bird.getHauteur(),i);
        }
    }




}