
/**
 * Date: 2/13/2023
 * Name: Maira Bermeo
 * CUNY ID: 24175075
 * Lab Section: 11A
 * Function: 
 * This is a Java program that reads a list of Roman numerals from a file, 
 * converts them to Arabic numerals, and displays them in a GUI. The program 
 * defines a class called Project1, which contains the main method and a helper 
 * method called valueOf. In the main method, the program initializes the numeralArray 
 * and arabicArray arrays, reads the list of Roman numerals from a file using TextFileInput, 
 * splits each line into an array of individual numerals, and then converts each numeral to its 
 * Arabic numeral equivalent using the valueOf method. The resulting arrays are passed to a 
 * new instance of the RomanNumeralGUI class, which displays them in a window. The valueOf method 
 * takes a Roman numeral string as input and returns an integer representing its Arabic numeral equivalent. 
 *
 */

public class Project1 {
    static final int LIST_SIZE = 20;
    static String[] numeralArray;
    static int numeralSize;
    static int[] arabicArray;
    
    
    public static void main(String[] args) {
    	
        // Initialize the array of Roman numerals,array of Arabic numerals, and numeralSize variable
        numeralArray = new String[LIST_SIZE];
        arabicArray = new int[LIST_SIZE];
        numeralSize = 0;

        // Create a TextFileInput object that reads from a file named input.txt.
        TextFileInput in = new TextFileInput("input.txt");
        String line = in.readLine();
        // Read each line of the file until the end of the file is reached.
        while (line != null) {
            // Split the line by commas and store the resulting array of strings in a variable.
            String[] numerals = line.split(",");
            String numeral;
            // Go through each Roman numeral in the numerals array.
            for (int i = 0; i < numerals.length; i++) {
                // Store the current Roman numeral in the numeral variable.
                numeral = numerals[i];
                numeralArray[numeralSize] = numeral;
                // Convert to an Arabic numeral and store it in the arabicArray
                arabicArray[numeralSize] = valueOf(numeral);
                numeralSize++;
            }
            line = in.readLine();
        }

        // Call the  RomanNumeralGUI and input the array for Roman Numerals and Arabic Numerals 
        RomanNumeralGUI gui = new RomanNumeralGUI(numeralArray, arabicArray);
    }

    // Method for converting a Roman numeral to an Arabic numeral.
    public static int valueOf(String numeral) {
       
        int arabicNumber = 0;
        int previousValue = 0;
        
        // Goes through each character in the numeral string
        for (int i = numeral.length() - 1; i >= 0; i--) {
            // Determine the value of the current Roman numeral character.
            int currentValue = numeral.charAt(i) == 'I' ? 1 :
                               numeral.charAt(i) == 'V' ? 5 :
                               numeral.charAt(i) == 'X' ? 10 :
                               numeral.charAt(i) == 'L' ? 50 :
                               numeral.charAt(i) == 'C' ? 100 :
                               numeral.charAt(i) == 'D' ? 500 :
                               numeral.charAt(i) == 'M' ? 1000 : 0;
            
           
            // If current numeral value is smaller, the current value is subtracted from the total arabicNumber 
            if (currentValue < previousValue) {
                arabicNumber -= currentValue;
                //Else add the two
            } else {
                arabicNumber += currentValue;
            }
            // previousValue is updated to the currentValue
            previousValue = currentValue;
        }
        //Returns the final arabicNumber value, 
        return arabicNumber;
    }
    

}
