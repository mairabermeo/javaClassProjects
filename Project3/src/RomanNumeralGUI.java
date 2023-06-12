
/**

The RomanNumeralGUI class provides a graphical user interface for the RomanNumeral class.
It allows the user to input a Roman numeral and convert it to an Arabic numeral.
It also allows the user to open a file containing Roman numerals and display them in a table
along with their equivalent Arabic numerals sorted and unsorted.
This class extends the JFrame class to create a window for the GUI.

 */

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class RomanNumeralGUI extends JFrame {

    private JLabel label1, label2;
    private JTextField inputField;
    private JButton convertButton;
    private JMenuItem openMenuItem, quitMenuItem, romanToArabicMenuItem;

    public RomanNumeralGUI() {
        setTitle("Roman Numeral Converter");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create file menu and menu items
        JMenu fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Open");
        quitMenuItem = new JMenuItem("Quit");

        // Create convert menu and menu items
        JMenu convertMenu = new JMenu("Convert");
        romanToArabicMenuItem = new JMenuItem("Roman to Arabic");

        // Add file menu items to file menu
        fileMenu.add(openMenuItem);
        fileMenu.add(quitMenuItem);

        // Add convert menu item to convert menu
        convertMenu.add(romanToArabicMenuItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(convertMenu);

        // Set menu bar
        setJMenuBar(menuBar);

        // Create components
        label1 = new JLabel("Welcome! HAVE FUN!!");
        label2 = new JLabel("");
        inputField = new JTextField(25);
        convertButton = new JButton("Convert");

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(label1);

        // Add panel to frame
        add(panel);

        // Add action listeners to menu items
        openMenuItem.addActionListener(new OpenMenuItemListener());
        quitMenuItem.addActionListener(new QuitMenuItemListener());
        romanToArabicMenuItem.addActionListener(new RomanToArabicMenuItemListener());

        setVisible(true);
    }
    
    /**
     * The OpenMenuItemListener class implements ActionListener interface
     * to handle the "Open" menu item.
     * It opens a file chooser dialog to allow the user to select a file containing
     * Roman numerals, reads the file, and displays the Roman numerals and their
     * Arabic equivalents sorted and unsorted in a table.
     */
    
    private class OpenMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(RomanNumeralGUI.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filename = selectedFile.getAbsolutePath();

                // read file and add Roman numerals to the lists
                UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
                SortedRomanNumeralList sortedList = new SortedRomanNumeralList();
                List<String> stringList = new ArrayList<String>();
                TextFileInput in = new TextFileInput(filename);
                String line = in.readLine();
                while (line != null) {
                    String[] numerals = line.split(",");
                    for (String numeral : numerals) {
                        try {
                            RomanNumeral romanNumeral = new RomanNumeral(numeral.trim());
                            stringList.add(numeral.trim());
                            unsortedList.append(romanNumeral);
                            sortedList.add(romanNumeral);
                        } catch(IllegalArgumentException errorBabes) {
                            System.out.println("Illegal Roman numeral: " + numeral.trim());
                        }
                    }
                    line = in.readLine();
                }
                // convert the list of Roman numerals as strings to an array
                String[] stringArray = stringList.toArray(new String[0]);
             // update the label to show the number of Roman numerals read from the file
                label2.setText(stringArray.length + " Roman numerals read from file");
                RomanNumeralGUI gui = new RomanNumeralGUI();
                
              
                RomanNumeral[] unsorted = unsortedList.getList();
                RomanNumeral[] sorted = sortedList.getList();


                // create new panel with three columns if "Open" is chosen
                JPanel panel = new JPanel(new GridLayout(1, 3));
                
                // create first panel for Roman Numeral
                JPanel column1 = new JPanel(new GridLayout(10, 1));
                column1.setBackground(new Color(204, 255, 204));
                JLabel romanLabel = new JLabel(" Roman Numeral ", JLabel.CENTER);
                romanLabel.setOpaque(true);
                romanLabel.setBackground(new Color( 131, 209, 95));
                column1.add(romanLabel);
                for (String numeral : stringArray) {
                    JLabel label = new JLabel(numeral, JLabel.CENTER);
                    column1.add(label);
                }
                panel.add(column1);
                
                // create second panel for Unsorted Roman Numeral
                JPanel column2 = new JPanel(new GridLayout(10, 1));
                column2.setBackground(new Color(204, 204, 255));
                JLabel unsortedLabel = new JLabel(" Unsorted Roman Numeral ", JLabel.CENTER);
                unsortedLabel.setOpaque(true);
                unsortedLabel.setBackground(new Color( 58, 110, 165));
                column2.add(unsortedLabel);
                for (RomanNumeral numeral : unsorted) {
                    JLabel label = new JLabel(String.valueOf(numeral.getArabicValue()), JLabel.CENTER);
                    column2.add(label);
                }
                panel.add(column2);

                
                // create third panel for Sorted Roman Numeral
                JPanel column3 = new JPanel(new GridLayout(10, 1));
                column3.setBackground(new Color(255, 204, 204));
                JLabel sortedLabel = new JLabel(" Sorted Roman Numeral ", JLabel.CENTER);
                sortedLabel.setOpaque(true);
                sortedLabel.setBackground(new Color( 221, 81, 76));
                column3.add(sortedLabel);
                for (int i = sorted.length - 1; i >= 0; i--) {
        	        RomanNumeral numeral = sorted[i];
        	        JLabel label = new JLabel(String.valueOf(numeral.getArabicValue()), JLabel.CENTER);
        	        column3.add(label);
        	    }
                
                panel.add(column3);

                JFrame popup = new JFrame();
                popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                popup.add(panel);

                // set size and make frame visible
                popup.setSize(600, 400);
                popup.setVisible(true);
            }
        }
    }
    
    
    private class QuitMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    private class RomanToArabicMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(RomanNumeralGUI.this, "Please enter a Roman numeral:");
            while (!input.equalsIgnoreCase("stop")) {
                // Validate input as Roman numeral
                if (!input.matches("^[ivxlcdmIVXLCDM]+$")) {
                    JOptionPane.showMessageDialog(RomanNumeralGUI.this, "Invalid input. Please enter a valid Roman numeral.");
                } else {
                    input = input.toUpperCase(); // convert any lowercase letters to uppercase
                    int result = RomanNumeral.convertToArabic(input);
                    JOptionPane.showMessageDialog(RomanNumeralGUI.this, "Arabic value: " + result);
                }
                input = JOptionPane.showInputDialog(RomanNumeralGUI.this, "Enter a Roman numeral (type 'stop' to exit):");
            }
        }
    
    }
}
    
