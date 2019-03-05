package mather_lab4;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Mather_Lab4 implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String[] state = {
      "alabama",
      "alaska",
      "arizona",
      "arkinsas",
      "california",
      "colorado",
      "connecticut",
      "delaware",
      "florida",
      "georgia",
      "hawaii",
      "idaho",
      "illinois",
      "indiana",
      "iowa",
      "kansas",
      "kentucky",
      "louisiana",
      "maine",
      "maryland",
      "massachusetts",
      "michigan",
      "minnesota",
      "mississippi",
      "missouri",
      "montana",
      "nebraska",
      "nevada",
      "new-hampshire",
      "new-jersey",
      "new-mexico",
      "new-york",
      "north-carolina",
      "north-dakota",
      "ohio",
      "oklahoma",
      "oregon",
      "pennsylvania",
      "rhode-island",
      "south-carolina",
      "south-dakota",
      "tennessee",
      "texas",
      "utah",
      "vermont",
      "virginia",
      "washington",
      "west-virginia",
      "wisconsin",
      "wyoming"};

    public void addComponentToPane(Container pane) throws MalformedURLException {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        JComboBox cb = new JComboBox(state);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        //Create the "cards".
        cards = new JPanel(new CardLayout());
        JPanel[] card = new JPanel[state.length];
        JButton[] button = new JButton[state.length];
        for ( int i =0; i < state.length; i++ ) {
           card[i] = new JPanel();
           String url = "https://raw.githubusercontent.com/CivilServiceUSA/us-states/master/images/flags/" + state[i] + "-large.png";
           button[i] = new JButton(new ImageIcon(new URL(url)));
           card[i].add(button[i]);
           cards.add(card[i], state[i]);
        }
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private static void createAndShowGUI() throws MalformedURLException {
        //Create and set up the window.
        JFrame frame = new JFrame("Mather_Lab4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        Mather_Lab4 demo = new Mather_Lab4();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Mather_Lab4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
