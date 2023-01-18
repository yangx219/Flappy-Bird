package view;

import model.Etat;
import model.Parcours;

import java.awt.*;

public class Vue {
    public Parcours parcours;
    public Etat e;

    public Vue(Etat e,Parcours p1){
        this.parcours = p1;
       this.e=e;
    }

    public void vue(Graphics g){

        Vue vue = new Vue(e,parcours);
        e.drawline(parcours,g);


    }
}
