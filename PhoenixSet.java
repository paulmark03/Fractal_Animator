package Fractals;

import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Graphics;
/**
 * Phoenix fractal class 
 * fractal formula z(n+1) = z(n)^2 + c * z(n) + p*z(n-1) 
 */
/**
 * We use this class in order to draw the fractal using its
 * formula
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class PhoenixSet extends JPanel {
    

    /*
     * This constant is only used to test the fractal. 
     * Later, it should be replaced by the user or 
     * a parent class
     */
    private final int MAXITERATIONS = 255;

    // initial fractal constants
    public static double C = 0.56667;
    public static double P = -0.5;

    PhoenixSet() {

    }

    int iterate(double x, double y) {


        double zReal = y;
        double zImag = x;


        double zPrevRe = 0;
        double zPrevIm = 0;

        int n = 0;
        while (n < MAXITERATIONS && zReal * zReal + zImag * zImag < 4.0) {
            double tmpReal = zReal;
            double tmpImag = zImag;

            zReal = zReal * zReal - zImag * zImag + C + P * zPrevRe;
            zImag = 2 * tmpReal * tmpImag + P * zPrevIm;

            zPrevRe = tmpReal;
            zPrevIm = tmpImag;
            n++;
        }

        return n;
    }

    public static int layer = 1;
    public void drawPhoenix(Graphics g){
        int maxX = this.getSize().width;
        int maxY = this.getSize().height;
        int currentPixel;
        for(double x = 0; x < maxX; x++) {
            for(double y = 0; y < maxY; y++) {
                currentPixel = MAXITERATIONS- layer*this.iterate((x-550)/400 , (y-350)/400);

                g.setColor(new Color(currentPixel));

                g.drawRect((int) x, (int) y, 1, 1);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPhoenix(g);
    }

}
