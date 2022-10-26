package Fractals;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

/**
 * This class is used to display the specific settings for the Phoenix
 * fractal set
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class PhoenixSettings extends JPanel implements ActionListener{
    JLabel layersTxt;
    JLabel hint;
    JTextField layers;
    JButton button;
    JSlider cSlider;
    JSlider pSlider;


    public PhoenixSettings(){
        setVisible(true);

        layersTxt = new JLabel("number of layers (between 1 and 10^6):");
        layersTxt.setVisible(true);

        hint = new JLabel("Hint: Try 50.000 :D");

        layers = new JTextField();
        layers.setVisible(true);
        layers.setPreferredSize(new Dimension(80, 20));

        button = new JButton("OK");
        button.addActionListener(this);

        
        
        setPreferredSize(new Dimension(60, 800));

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
        PhoenixSet.layer = Integer.parseInt(layers.getText());
        
    }
}
