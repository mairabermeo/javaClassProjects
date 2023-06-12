
import java.awt.*;
import java.awt.event.*;
import java.util.TreeMap;

import javax.swing.*;

/**
 * The RomanNumeralGUI class provides a graphical user interface for the Roman Numeral Converter. 
 * The class extends the JFrame class and includes a menu bar with a file menu and a convert menu, 
 * and a label that displays a welcome message. 
 * The class also includes a FileMenuHandler to handle the file menu events, 
 * and a RomanToArabicMenuItemListener to handle the convert menu events. 
 */
public class RomanNumeralGUI extends JFrame {

    private JLabel label1;
    private JMenuItem openMenuItem, quitMenuItem, romanToArabicMenuItem;
    private FileMenuHandler fileMenuHandler;

    /**
     * Constructor for the RomanNumeralGUI class.
     * Sets the title and size of the frame, sets the default close operation, 
     * creates the menu bar and menus, creates the label, text field, and button, 
     * adds them to the panel, and sets the fileMenuHandler and event listeners. 
     */
    public RomanNumeralGUI() {
        setTitle("Roman Numeral Converter");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create menu bar and menus
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        openMenuItem = new JMenuItem("Open");
        quitMenuItem = new JMenuItem("Quit");
        JMenu convertMenu = new JMenu("Convert");
        romanToArabicMenuItem = new JMenuItem("Roman to Arabic");
        fileMenu.add(openMenuItem);
        fileMenu.add(quitMenuItem);
        convertMenu.add(romanToArabicMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(convertMenu);
        setJMenuBar(menuBar);
        
        // Create label, text field, and button
        label1 = new JLabel("Welcome! HAVE FUN!!");
        new JLabel("");
        new JTextField(25); 
        new JButton("Convert"); 
        
        // Create panel and add label to panel
        JPanel panel = new JPanel();
        panel.add(label1);
        add(panel);
        
        // Create fileMenuHandler and set event listeners
        fileMenuHandler = new FileMenuHandler(this);
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the openFile method, get the array of Roman numerals
                fileMenuHandler.openFile();
                String[] romanNumerals = fileMenuHandler.getRomanNumerals();
                // Create a new RomanComparator and pass in the array of Roman numerals then display
                RomanComparator comparator = new RomanComparator(romanNumerals);
                displaySortedNumerals(comparator.getSortedNumerals());
            }
        });
        // Add the fileMenuHandler as an ActionListener to the quitMenuItem to handle the quit event
        quitMenuItem.addActionListener(fileMenuHandler);
        romanToArabicMenuItem.addActionListener(new RomanToArabicMenuItemListener());
        
        setVisible(true); 
    }
    
    /**
     * Displays the sorted list of Roman numerals and their corresponding Arabic values in a new pop-up window.
     *
     * @param sortedNumerals the TreeMap of Roman numerals and their corresponding Arabic values, sorted in ascending order
     */
    private void displaySortedNumerals(TreeMap<RomanNumeral, Integer> sortedNumerals) {
        // Create a new JPanel with a grid layout of 1 row and 2 columns
        JPanel panel = new JPanel(new GridLayout(1, 2));

        // The outline of the first column for the roman numeral 
        JPanel column1 = new JPanel(new GridLayout(10, 1));
        column1.setBackground(new Color(245, 201, 226));
        JLabel romanLabel = new JLabel(" Roman Numerals ", JLabel.CENTER);
        romanLabel.setOpaque(true);
        romanLabel.setBackground(new Color(229, 155, 198));
        column1.add(romanLabel);
        // Loop through the TreeMap of Roman numerals and add each one as a JLabel to the first column
        for (RomanNumeral numeral : sortedNumerals.keySet()) {
            JLabel label = new JLabel(numeral.toString(), JLabel.CENTER);
            column1.add(label);
        }
        panel.add(column1);

        // The outline of the second column for the arabic value 
        JPanel column2 = new JPanel(new GridLayout(10, 1));
        column2.setBackground(new Color(204, 204, 255));
        JLabel sortedLabel = new JLabel("Arabic Numerals ", JLabel.CENTER);
        sortedLabel.setOpaque(true);
        sortedLabel.setBackground(new Color(196, 188, 244));
        column2.add(sortedLabel);
        // Loop through the TreeMap of Roman numerals and add each Arabic value as a JLabel to the second column
        for (int value : sortedNumerals.values()) {
            JLabel label = new JLabel(String.valueOf(value), JLabel.CENTER);
            column2.add(label);
        }
        panel.add(column2);

        // Create a new JFrame to display the panel as a pop-up window and make it visible 
        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.add(panel);
        popup.setSize(600, 400);
        popup.setVisible(true);
    }

    /**
     * ActionListener for the Roman to Arabic conversion menu item.
     */
    private class RomanToArabicMenuItemListener implements ActionListener {
        /**
         * Displays a dialog box prompting the user to enter a Roman numeral,
         * converts the Roman numeral to an Arabic numeral, and displays the result
         * in a dialog box.
         * 
         * @param e the ActionEvent object representing the user's action
         */
        public void actionPerformed(ActionEvent e) {
            // Prompt the user to enter a Roman numeral
            String input = JOptionPane.showInputDialog(RomanNumeralGUI.this, "Please enter a Roman numeral:");
            
            // Loop until the user types 'stop'
            while (!input.equalsIgnoreCase("stop")) {
                // If the input is not a valid Roman numeral, display an error message
                if (!input.matches("^[ivxlcdmIVXLCDM]+$")) {
                    JOptionPane.showMessageDialog(RomanNumeralGUI.this, "Invalid input. Please enter a valid Roman numeral.");
                } else {
                    // Convert the Roman numeral to an Arabic numeral and display the result
                    input = input.toUpperCase();
                    int result = RomanNumeral.convertToArabic(input);
                    JOptionPane.showMessageDialog(RomanNumeralGUI.this, "Arabic value: " + result);
                }
                
                // Prompt the user to enter another Roman numeral (or 'stop' to exit)
                input = JOptionPane.showInputDialog(RomanNumeralGUI.this, "Enter a Roman numeral (type 'stop' to exit):");
            }
        }
    }
}