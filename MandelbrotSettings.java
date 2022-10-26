package Fractals;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;  

/**
 * This class is used to display the specific settings for the Mandelbrot
 * fractal set
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class MandelbrotSettings extends JPanel implements ActionListener {
    JLabel layersTxt;
    JLabel hint;
    JTextField layers;
    JButton button;


    public MandelbrotSettings(){
        setVisible(true);

        layersTxt = new JLabel("number of layers (between 1 and 10^6):");
        layersTxt.setVisible(true);

        hint = new JLabel("Hint: Try 50.000 :D");

        layers = new JTextField();
        layers.setVisible(true);
        layers.setPreferredSize(new Dimension(80, 20));

        button = new JButton("OK");
        button.addActionListener(this);
        
        setPreferredSize(new Dimension(100, 800));

        add(Box.createRigidArea(new Dimension(5,20)));
        add(layersTxt);
        add(Box.createRigidArea(new Dimension(5,20)));
        add(layers);
        add(Box.createRigidArea(new Dimension(5,20)));
        add(button);
        add(Box.createRigidArea(new Dimension(5,20)));
        add(hint);
        add(Box.createRigidArea(new Dimension(5,700)));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        MandelbrotSet.layer = Integer.parseInt(layers.getText());
    }
}
