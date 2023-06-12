/**
 * Date: 3/26/2023
 * Name: Maira Bermeo
 * Function: 
 * The Project2 class is the main class of the Roman numeral project.
 * It reads a list of Roman numerals from an input file, converts them to
 * integers and displays them in a GUI sorted in ascending order and the order 
 * they are in they are in the txt file. Any invalid Roman numeral will be ignored.
 *  @author Maira Bermeo
*/

import java.util.*;
public class Project2 {

/**
 * The main method reads the Roman numerals from the input file, converts them 
 * to integers and displays them in a GUI sorted in ascending order. Any invalid
 * Roman numeral will be ignored and printed in the console.
 */
	public static void main(String[] args) {
	    String filename = "input.txt";
	    // create a new unsorted Roman numeral list and new sorted Roman numeral list
	    UnsortedRomanNumeralList unsortedList = new UnsortedRomanNumeralList();
	    SortedRomanNumeralList sortedList = new SortedRomanNumeralList();

	    //read file
	    TextFileInput in = new TextFileInput(filename);
	    String line = in.readLine();
	    // create a new list to store the Roman numerals as strings
	    List<String> stringList = new ArrayList<String>();
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
	            } catch (IllegalArgumentException errorBabes) {
	                System.out.println("Illegal Roman numeral: " + numeral.trim());
	            }
	        }
	        line = in.readLine();
	    }

	    // convert the list of Roman numerals as strings to an array
	    String[] stringArray = stringList.toArray(new String[0]);

	    RomanNumeralGUI gui = new RomanNumeralGUI(stringArray, unsortedList.getList(), sortedList.getList());
	}
}
