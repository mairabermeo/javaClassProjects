
import java.awt.*;
import javax.swing.*;

public class RomanNumeralGUI extends JFrame {
    
    public RomanNumeralGUI(String[] roman, int[] arabic) {
    	// set up the GUI
        setTitle("RomanNumeralConverter"); 
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        
        // sets up the Roman numeral side by adding a label and giving it the color yellow
        JPanel westPanel = new JPanel(new BorderLayout());
        westPanel.setBackground(new Color (119, 179, 0)); // greyish green 
        JLabel romanLabel = new JLabel("Roman Numerals:", JLabel.CENTER);
        westPanel.add(romanLabel, BorderLayout.NORTH);
        JTextArea romanTextArea = new JTextArea();
        romanTextArea.setBackground(new Color(230, 255, 179)); // light green
        romanTextArea.setEditable(false); 
        westPanel.add(romanTextArea, BorderLayout.CENTER);
        getContentPane().add(westPanel);
        
        //sets up the Arabic numeral side by adding a label and giving it the color red
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setBackground(new Color(255, 159, 128));
        JLabel arabicLabel = new JLabel("Arabic Numbers:", JLabel.CENTER);
        eastPanel.add(arabicLabel, BorderLayout.NORTH);
        JTextArea arabicTextArea = new JTextArea();
        arabicTextArea.setBackground(new Color(255, 198, 179)); 
        arabicTextArea.setEditable(false); 
        eastPanel.add(arabicTextArea, BorderLayout.CENTER);
        getContentPane().add(eastPanel);
        
        
        // this puts the two arrays from Project 1 into their respected are
        for (int i = 0; i < arabic.length; i++) {
            if (arabic[i] == 0 || roman[i].equals("null")) {
                continue; // Skip over invalid values
            }
            // allows one Roman numeral to be displayed on one line as well as the Arabic numbers 
            romanTextArea.append("   " +roman[i] + "\n" );
            arabicTextArea.append("   " +arabic[i] + "\n");
        
        // allows the GUI to be seen 
        setVisible(true);
    }
}
}
