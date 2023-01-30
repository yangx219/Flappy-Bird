package model;

import view.Affichage;
import view.Fenetre;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    public ArrayList<Point> points;
    private int position;
    private int distance = 160;
    private int nbPas = Fenetre.LARGE / distance;

    public Parcours() {
        position = 0;
        points = new ArrayList<>();
        generate();
    }

    /**
     * Générer les points nécessaires
     */
    public void generate() {
        Random rand = new Random();
        int currentIndex = 0;
        for (int i = 0; i <= nbPas; i++) {
            Point p = new Point();
            p.x = (Fenetre.LARGE) / nbPas * (i);
            p.y = rand.nextInt(Fenetre.HAUT-50)+50;
            if (points.size() == 0) {
                points.add(p);
                currentIndex++;
            } else {
                while (Math.abs(pente(p, points.get(currentIndex - 1))) > 0.5) {
                    p.y = rand.nextInt(Fenetre.HAUT);
                }
                points.add(p);
                currentIndex++;
            }
        }
    }

    /**
     * Calcule la pente entre deux points * @param a le premier point
     *
     * @param a le premier point
     * @param b le deuxieme point
     * @return la pente entre a et b
     */
    public float pente(Point a, Point b) {
        return (float) ((b.y)- (a.y)) / (b.x - a.x);
    }

    /** getParcours ne renvoie que les points visibles
     *
     *  @return ArrayList<Point>   les points visibles
     */
    public ArrayList<Point> getParcours() {
        /**on bouge les points*/
        for (Point tmp : points) {
            tmp.x -= distance;
        }
        Random rand = new Random();
        /**on retire la premier points qui est deja sortie la fenetre */
        points.remove(0);
        /**creer un nouveau point pour ajouter dans la fenetre*/
        int size = points.size();
        Point newP = new Point();
        newP.x = points.get(size - 1).x + distance;
        newP.y = rand.nextInt(Fenetre.HAUT);

        Point lastPoint = points.get(size - 1);
        while (Math.abs(pente(newP, lastPoint)) > 0.5) {
            newP.y = rand.nextInt(Fenetre.HAUT);
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