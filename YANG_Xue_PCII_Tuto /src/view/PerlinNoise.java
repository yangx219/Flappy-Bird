package view;

import java.awt.*;
import java.util.Random;


public class PerlinNoise {
    private Random random;
    private int width, height;

    /**
     * Constructeur PerlinNoise
     *
     * @param width la largeur
     * @param height la hauteur
     */
    public PerlinNoise(int width, int height) {
        this.width = width;
        this.height = height;
        this.random = new Random();
    }

    /**
     * Génère un bruit de Perlin
     *
     * @return une matrice de doubles représentant le bruit de Perlin
     */
    public double[][] generatePerlinNoise() {
        double[][] noise = new double[width][height];
        // Initialiser les valeurs de bruit
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                noise[x][y] = random.nextDouble()* 0.5;
            }
        }

        return noise;
    }

    /**
     * Dessine des nuages à partir du bruit de Perlin
     *
     * @param noise la matrice de bruit de Perlin
     * @param g le contexte graphique
     */
    public void drawClouds(double[][] noise,Graphics2D g) {
        int count = 0;
        // Dessiner des ovales uniquement tous les 5 pixels en x et en y
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double n = noise[x][y];
                int ovalSize = (int) (n * 50);
                if (x % 5 == 0 && y % 5 == 0) {
                    // Dessiner seulement 1/10 des ovales
                    if (count++ < (width * height) / 10) {
                        int ovalX = x * ovalSize;
                        int ovalY = y * ovalSize;
                        int ovalWidth = ovalSize;
                        int ovalHeight = ovalSize;
                        g.setColor(new Color(240, 255, 255));
                        g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
                    } else {
                        break;
                    }
                }
            }
            if (count >= (width * height) / 10) {
                break;
            }


        }


    }
}
