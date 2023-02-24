package model;

import view.Fenetre;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Classe Parcours
 * génère et maintient un parcours pour un objet en mouvement
 */
public class Parcours {
    /**Liste de points du parcours*/
    public ArrayList<Point> points;
    private int position;
    /**Distance entre chaque point*/
    private int distance = 160;
    /**Nombre de pas nécessaires pour parcourir la fenêtre*/
    private int nbPas = Fenetre.LARGE / distance;

    /**Constructeur qui initialise la position à 0 et génère le parcours*/
    public Parcours() {
        position = 0;
        points = new ArrayList<>();
        generate();
    }

    /**
     * Génère les points nécessaires pour le parcours
     */
    public void generate() {
        Random rand = new Random();
        int currentIndex = 0;
        for (int i = 0; i <= nbPas; i++) {
            Point p = new Point();
            p.x = (Fenetre.LARGE) / nbPas * (i);
            p.y = rand.nextInt(Fenetre.HAUT);
            if (points.size() == 0) {
                points.add(p);
                currentIndex++;
            } else {
                while (Math.abs(pente(p, points.get(currentIndex - 1))) > 0.5) {
                    p.y = rand.nextInt(Fenetre.HAUT-50);
                }
                points.add(p);
                currentIndex++;
            }
        }
    }

    /**
     * Calcule la pente entre deux points
     *
     * @param a le premier point
     * @param b le deuxieme point
     * @return la pente entre a et b
     */
    public float pente(Point a, Point b) {
        return (float) ((b.y)- (a.y)) / (b.x - a.x);
    }

    /** Renvoie les points visibles du parcours
     *
     *  @return ArrayList<Point>   les points visibles
     */
    public ArrayList<Point> getParcours() {
        /** Déplace les points */
        for (Point tmp : points) {
            tmp.x -= distance;
        }
        Random rand = new Random();
        /** Retire le premier point qui est sorti de la fenêtre */
        points.remove(0);
        /** Retire le premier point qui est sorti de la fenêtre */
        int size = points.size();
        Point newP = new Point();
        newP.x = points.get(size - 1).x + distance;
        newP.y = rand.nextInt(Fenetre.HAUT-50);

        Point lastPoint = points.get(size - 1);
        while (Math.abs(pente(newP, lastPoint)) > 0.5) {
            newP.y = rand.nextInt(Fenetre.HAUT-50);
        }
            points.add(newP);

        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}