package Fractals;

import java.awt.*;
import javax.swing.*;

//fractal formula z(n+1) = z(n)^2 + C
/**
 * We use this class in order to draw the fractal using its
 * formula
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class MandelbrotSet extends JPanel {
    private int MAXITERATIONS = 255;

    public void MandelbrotSet() {
        
    }

    public int iterate(double x, double y) {

        double zReal = x;
        double zImag = y;

        int n = 0;
        while (n < MAXITERATIONS && zReal * zReal + zImag * zImag < 4.0) {
            double tmpReal = zReal;
            double tmpImag = zImag;

            zReal = zReal * zReal - zImag * zImag + x;
            zImag = 2 * tmpReal * tmpImag + y;

            n++;
        }

        return n;
    }

    public static int layer = 1;
    public void drawMandelbrot(Graphics g){
        int maxX = this.getSize().width;
        int maxY = this.getSize().height;
        int currentPixelR;

        for(double x = 0; x < maxX; x++) {
            for(double y = 0; y < maxY; y++) {              
                currentPixelR =  MAXITERATIONS- layer *this.iterate((x-750)/300 , (y-350)/300) ;

                g.setColor(new Color(currentPixelR));

                g.drawRect((int) x, (int) y, 1, 1);
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMandelbrot(g);
    }
        

}
