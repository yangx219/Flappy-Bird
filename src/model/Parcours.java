package model;

import view.Affichage;
import view.Fenetre;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    public ArrayList<Point> points;
    private Random rand;
    private int changeSpeed = 10;
    private int position;
    private Etat etat;
    private int distance = 160;
    private int nbPas = Fenetre.LARGE / distance;

    public Parcours() {
        position = 0;
        points = new ArrayList<Point>();
        generate();
    }

    /**
     * creer les points que on a besoin
     */


    public void generate() {
        Random rand = new Random();
        int currentIndex = 0;
        //Point centreOvale = new Point(points.get(0).x, etat.getHauteur());
        for (int i = 0; i <= nbPas; i++) {
            Point p = new Point();
            p.x = (Fenetre.LARGE) / nbPas * (i);
            p.y = rand.nextInt(Fenetre.HAUT);
            if (points.size() == 0) {
                points.add(p);
                currentIndex++;
            } else {
                while (Math.abs(pente(p, points.get(currentIndex - 1))) > 0.3) {
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

    /**
     * getParcours ne renvoie que les points visibles
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
        Point newP = new Point();
        newP.x = points.get(points.size() - 1).x + distance;
        newP.y = rand.nextInt(Fenetre.HAUT);

        int size = points.size();
        Point lastPoint = points.get(size - 1);
        while (Math.abs(pente(newP, lastPoint)) > 0.3) {
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