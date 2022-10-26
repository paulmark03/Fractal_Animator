package Fractals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * This is the class we use as the main frame
 * here we have all the components like save load and exit.
 * This frame is split between two panels. One of them is the fractal
 * and the other is the sidemenu with the settings.
 */
/**
 * NAME: Paul Nicolae Marcu
 * ID: 1844989
 */
public class GUI extends JFrame implements ActionListener {
    JMenuItem saveSetting;
    JMenuItem loadSetting;
    JMenuItem exit;
    JMenuItem toggleSettings;
    JMenuItem pythegorian;
    JMenuItem mandelbrot;
    JMenuItem pheonix;

    JScrollPane zoom = new JScrollPane();    

    JSlider angleSlide;
    JSlider iterationSlide;

    JLabel angleTxt;
    JLabel iterationTxt;

    CardLayout layout = new CardLayout();
    CardLayout layout1 = new CardLayout();
    JPanel painting = new JPanel(layout);
    JPanel fractalSettinss = new JPanel(layout1);

    JScrollPane scrollPane = new JScrollPane();

    

    


    public GUI(String title) {

        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1400, 800));

        JMenuBar menuBar = new JMenuBar();
        JMenu fractalMenu = new JMenu("Fractals");
        JMenu tools = new JMenu("Tools");

        setJMenuBar(menuBar);

        
        JMenu fileMenu = new JMenu("File");
        fractalMenu = new JMenu("Fractals");
        tools = new JMenu("Tools");


        menuBar.add(fileMenu);
        menuBar.add(fractalMenu);
        menuBar.add(tools);


        saveSetting = new JMenuItem("Save Settings");
        loadSetting = new JMenuItem("Load Settings");
        exit = new JMenuItem("Exit");

        saveSetting.addActionListener(this);
        loadSetting.addActionListener(this);
        exit.addActionListener(this);
        

        pythegorian = new JMenuItem("Pythegorian Tree");
        mandelbrot = new JMenuItem("Mandelbrot set");
        pheonix = new JMenuItem("Phoenix set");

        pythegorian.addActionListener(this);
        pheonix.addActionListener(this);
        mandelbrot.addActionListener(this);

        toggleSettings = new JMenuItem("Toggle Settigs");
        toggleSettings.addActionListener(this);


        fileMenu.add(saveSetting);
        fileMenu.add(loadSetting);
        fileMenu.add(exit);

        fractalMenu.add(pythegorian);
        fractalMenu.add(mandelbrot);
        fractalMenu.add(pheonix);

        tools.add(toggleSettings);


        PythagorasTree fractal1 = new PythagorasTree();
        PhoenixSet fractal2 = new PhoenixSet();
        MandelbrotSet fractal3 = new MandelbrotSet();

        TreeSettings treeSettings = new TreeSettings();
        MandelbrotSettings mandelSettings = new MandelbrotSettings();
        PhoenixSettings phoenixSettings = new PhoenixSettings();

        painting.add(fractal1, "fractal1");
        painting.add(fractal2, "fractal2");
        painting.add(fractal3, "fractal3");

        fractalSettinss.add(treeSettings, "TreeSettings");
        fractalSettinss.add(mandelSettings, "MandelSettings");
        fractalSettinss.add(phoenixSettings, "PhoenixSettings");

        add(painting);
        add(fractalSettinss);

    
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fractalSettinss, painting);
        getContentPane().add(split);

        pack();
        setVisible(true);
    }

    boolean flag = fractalSettinss.isVisible();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadSetting) {
            File file = new File("Settings.txt");
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String variable;
                variable = br.readLine();
                PythagorasTree.angle = Integer.parseInt(variable);
                variable = br.readLine();
                PythagorasTree.iterations = Integer.parseInt(variable);
                variable = br.readLine();
                MandelbrotSet.layer = Integer.parseInt(variable);
                variable = br.readLine();
                PhoenixSet.layer = Integer.parseInt(variable);




            } catch (FileNotFoundException e1) {

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == saveSetting) {
            try{
                PrintWriter writer = new PrintWriter("Settings.txt", "UTF-8");
                writer.write(String.valueOf(PythagorasTree.angle));
                writer.println();
                writer.write(String.valueOf(PythagorasTree.iterations));
                writer.println();
                writer.write(String.valueOf(MandelbrotSet.layer));
                writer.println();
                writer.write(String.valueOf(PhoenixSet.layer));
                writer.println();
                // writer.write(String.valueOf(PythagorasTree.angle));
                // writer.println();

                writer.close();
            } catch (IOException f) {
                System.out.println("An error occurred.");
                f.printStackTrace();
            }
                

        }
        if (e.getSource() == exit) {

            System.exit(0);
        }
        if (e.getSource() == toggleSettings) {

            flag = !flag;
            fractalSettinss.setVisible(flag);
            SwingUtilities.updateComponentTreeUI(this);
        }
        if (e.getSource() == pythegorian) {

            layout.show(painting, "fractal1");
            layout1.show(fractalSettinss, "TreeSettings");
        }
        if (e.getSource() == pheonix) {

            layout.show(painting, "fractal2");
            layout1.show(fractalSettinss, "PhoenixSettings");
        }
        if (e.getSource() == mandelbrot) {

            layout.show(painting, "fractal3");
            layout1.show(fractalSettinss, "MandelSettings");
        }

    }

}