
/**
 * Date: 4/21/2023
 * Name: Maira Bermeo
 * Function: 
 * The Project2 class is the main class of the Roman numeral project.
 * It reads a list of Roman numerals from an input file, converts them to
 * integers and displays them in a GUI sorted in ascending order and the order 
 * they are in they are in the txt file. Any invalid Roman numeral will be ignored.
 *  @author Maira Bermeo
*/

import java.util.*;

import javax.swing.JFileChooser;
public class Project3 {
	public static String filename;

	/**
	 * The main method reads the Roman numerals from the input file, converts them 
	 * to integers and displays them in a GUI sorted in ascending order. Any invalid
	 * Roman numeral will be ignored and printed in the console.
	 */


	public static void main(String[] args) {
	    // create a new unsorted Roman numeral list and new sorted Roman numeral list
	    UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
	    SortedRomanNumeralList sortedList = new SortedRomanNumeralList();

	    // read file
	    String filename = "";
	    if (args.length == 0 && filename.isEmpty()) {
	        // show the GUI to select a file
	        RomanNumeralGUI gui = new RomanNumeralGUI();
	    } else {
	        filename = !filename.isEmpty() ? filename : args[0];
	        TextFileInput in = new TextFileInput(filename);

	        // create a new list to store the Roman numerals as strings
	        List<String> stringList = new ArrayList<String>();
	        String line = in.readLine();
	        while (line != null) {
	            // split the line into an array of Roman numerals
	            String[] numerals = line.split(",");
	            // loop through each Roman numeral in the array
	            for (String numeral : numerals) {
	                try {
	                    // create a new Roman numeral object from the string
	                    RomanNumeral romanNumeral = new RomanNumeral(numeral);
	                    // add the Roman numeral as a stringList, unsortedList, sortedList
	                    stringList.add(numeral);
	                    unsortedList.append(romanNumeral);
	                    sortedList.add(romanNumeral);
	                } catch (IllegalArgumentException error) {
	                    // if an invalid Roman numeral is encountered, print an error message to the console
	                    System.out.println("Invalid Roman numeral: " + numeral.trim());
	                }
	            }
	            line = in.readLine();
	        }

	        // convert the list of Roman numerals as strings to an array
	        String[] stringArray = stringList.toArray(new String[0]);

	        // create a GUI to display the sorted Roman numerals
	        RomanNumeralGUI gui = new RomanNumeralGUI();
	    } 
	    }
	}
