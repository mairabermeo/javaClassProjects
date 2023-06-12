
/**
 * The RomanNumeralGUI class creates a graphical user interface that displays a table with
 * Roman numeral strings and their corresponding Arabic values in both unsorted and sorted order.
 * The table is divided into three columns: Roman Numeral, Unsorted Arabic Numbers, and Sorted Arabic Numbers.
 * Each column is a JPanel that contains a JLabel with a header, followed by JLabels that display the
 * values from the input arrays of RomanNumeral objects and their corresponding Arabic values.
 * @author maira bermeo
*/

import java.awt.*;
import javax.swing.*;

public class RomanNumeralGUI extends JFrame {
	private JPanel panel;

	/**
	 * constructs a RomanNumeralGUI object with the given arrays of RomanNumeral objects in Roman numeral strings, 
	 * unsorted Arabic values, and sorted Arabic values.
	 * 
	 * @param romanNumeral an array of Roman numeral strings
	 * @param unsorted an array of RomanNumeral objects with unsorted Arabic values
	 * @param sorted an array of RomanNumeral objects with sorted Arabic values
	 */
	public RomanNumeralGUI(String[] romanNumeral, RomanNumeral[] unsorted, RomanNumeral[] sorted) {
		setTitle("Converter");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(550, 400);

	    panel = new JPanel(new GridLayout(1, 3));
	    
	    // create first panel for Roman Numeral
	    JPanel column1 = new JPanel(new GridLayout(10, 1));
	    column1.setBackground(new Color(204, 255, 204));
	    JLabel romanLabel = new JLabel(" Roman Numeral ", JLabel.CENTER);
	    romanLabel.setOpaque(true);
	    romanLabel.setBackground(new Color( 131, 209, 95));
	    column1.add(romanLabel);
	    for (String numeral : romanNumeral) {
	        JLabel label = new JLabel(numeral, JLabel.CENTER);
	        column1.add(label);
	    }
	    
	    // create middle column for Unsorted
	    JPanel column2 = new JPanel(new GridLayout(10, 1));
	    column2.setBackground(new Color(255, 204, 204));
	    JLabel unsortedLabel = new JLabel(" Unsorted Arabic Numbers ", JLabel.CENTER);
	    unsortedLabel.setOpaque(true);
	    unsortedLabel.setBackground(new Color(238, 144, 192));
	    column2.add(unsortedLabel);
	    for (RomanNumeral numeral : unsorted) {
	        JLabel label = new JLabel(String.valueOf(numeral.getArabicValue()), JLabel.CENTER);
	        column2.add(label);
	    }

	    // create right column for Sorted
	    JPanel column3 = new JPanel(new GridLayout(10, 1));
	    column3.setBackground(new Color(229, 204, 255));
	    JLabel sortedLabel = new JLabel(" Sorted Arabic Numbers ", JLabel.CENTER);
	    sortedLabel.setOpaque(true);
	    sortedLabel.setBackground(new Color(212, 110, 219));
	    column3.add(sortedLabel);
	    for (int i = sorted.length - 1; i >= 0; i--) {
	        RomanNumeral numeral = sorted[i];
	        JLabel label = new JLabel(String.valueOf(numeral.getArabicValue()), JLabel.CENTER);
	        column3.add(label);
	    }


	    panel.add(column1);
	    panel.add(column2);
	    panel.add(column3);

	    JScrollPane scrollPane = new JScrollPane(panel);
	    add(scrollPane);

	    setLocationRelativeTo(null);
	    setVisible(true);
	}
}
