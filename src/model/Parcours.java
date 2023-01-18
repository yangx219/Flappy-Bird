package model;
import view.Affichage;

import java.awt.Point;
import java.util.ArrayList;
public class Parcours {
    public ArrayList<Point> points;

    public Parcours() {
        points = new ArrayList<Point>();
    }

    public ArrayList<Point> generate() {
        int x = 0;
        int tmp =0;
        //int i = 0;
        while(x < Affichage.LARG){
            x = ((int)(Math.random()*Affichage.LARG+100));
            if (x>=tmp){
                tmp = x;
                Point p1 = new Point();
                p1.x = x;
                p1.y = (int)(Math.random()*Affichage.HAUT);
                points.add(p1);
                //System.out.println(points.get(i));
                //i++;
            }
        }
        return points;

    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
