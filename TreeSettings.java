package Fractals;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is used to display the specific settings for the pythagoras tree
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class TreeSettings extends JPanel implements ChangeListener {

    JSlider angleSlide;
    JSlider iterationSlide;
    JSlider red;
    JSlider green;
    JSlider blue;

    JLabel angleTxt;
    JLabel iterationTxt;
    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    int selectedShape = 0;

    public TreeSettings(){
        setVisible(true);
        setPreferredSize(new Dimension(200, 800));


        String[] chooseShape = {"Background", "Square", "Triangle", "OutLine"};

        JComboBox selectShape = new JComboBox<String>(chooseShape);
        selectShape.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == selectShape) {
                    selectedShape = selectShape.getSelectedIndex();
                }
                
            }
            
        });

        angleTxt = new JLabel();
        angleTxt.setText("  Angle:");
        angleTxt.setVisible(true);

        iterationTxt = new JLabel();
        iterationTxt.setText("  Iterations:");
        iterationTxt.setVisible(true);

        redLabel = new JLabel();
        redLabel.setText("  Red:");
        redLabel.setVisible(true);

        greenLabel = new JLabel();
        greenLabel.setText("  Green:");
        greenLabel.setVisible(true);

        blueLabel = new JLabel();
        blueLabel.setText("  Blue:");
        blueLabel.setVisible(true);

        angleSlide = new JSlider(2, 88, 45);
        angleSlide.setValue(45);
        angleSlide.setMajorTickSpacing(30);
        angleSlide.setPaintTicks(true);
        angleSlide.addChangeListener(this);
        angleSlide.setVisible(true);

        iterationSlide = new JSlider(0, 15, 10);
        iterationSlide.setValue(10);
        iterationSlide.setMajorTickSpacing(2);
        iterationSlide.setPaintTicks(true);
        iterationSlide.setVisible(true);
        iterationSlide.addChangeListener(this);

        red = new JSlider(0, 255, 100);
        red.setMajorTickSpacing(30);
        red.setPaintTicks(true);
        red.addChangeListener(this);
        
        green = new JSlider(0, 255, 100);
        green.setMajorTickSpacing(30);
        green.setPaintTicks(true);
        green.addChangeListener(this);
        
        blue = new JSlider(0, 255, 100);
        blue.setMajorTickSpacing(30);
        blue.setPaintTicks(true);
        blue.addChangeListener(this);
      
        add(selectShape);

        add(angleTxt);
        add(angleSlide);

        add(iterationTxt);
        add(iterationSlide);

        add(redLabel);
        add(red);

        add(greenLabel);
        add(green);

        add(blueLabel);
        add(blue);

        setLayout(new GridLayout(0,1));



    }
    

    @Override
    public void stateChanged(ChangeEvent e) {
        PythagorasTree.angle = angleSlide.getValue();
        if(iterationSlide.getValue()==0){
            PythagorasTree.iterations = 16;
        } else {
            PythagorasTree.iterations = iterationSlide.getValue();
        }
        
        if(selectedShape == 0) {
            PythagorasTree.backgroundColor = new Color(red.getValue(), green.getValue(), blue.getValue());
        }
        if(selectedShape == 1) {
            PythagorasTree.squareColor = new Color(red.getValue(), green.getValue(), blue.getValue());
        }
        if(selectedShape == 2) {
            PythagorasTree.triangleColor = new Color(red.getValue(), green.getValue(), blue.getValue());
        }
        if(selectedShape == 3) {
            PythagorasTree.lineColor = new Color(red.getValue(), green.getValue(), blue.getValue());
        }
        
    }
   
    
}
