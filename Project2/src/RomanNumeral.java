
/**
 * The RomanNumeral class represents a Roman numeral, which can be converted
 * to an integer value. The class provides methods to retrieve the Roman numeral,
 * the integer value, set a new Roman numeral, and compare it with another Roman
 * numeral. The class also overrides the equals method to check if two Roman
 * numerals are equal, and the toString method to provide a string representation
 * of the Roman numeral and its corresponding integer value.
 * @author maira bermeo
*/

import java.util.*;


public class RomanNumeral{ 
	
	
	private String romanNumeral;
	private int arabicValue;

	/**
	 * creates a new RomanNumeral object from a string representing a Roman numeral.
	 *
	 * @param romanNumeral the string representing the Roman numeral.
	 */
	public RomanNumeral(String romanNumeral) {
	    this.romanNumeral = romanNumeral;
	    this.arabicValue = convertToArabic(romanNumeral);
	}

	/**
	 * returns the Roman numeral as a string.
	 *
	 * @return the Roman numeral as a string.
	 */
	public String getRomanNumeral() {
	    return romanNumeral;
	}

	/**
	 * sets a new Roman numeral for this object.
	 *
	 * @param romanNumeral the new Roman numeral as a string.
	 */
	public void setRomanNumeral(String romanNumeral) {
	    this.romanNumeral = romanNumeral;
	    this.arabicValue = convertToArabic(romanNumeral);
	}


	/**
	 * returns the integer value of the Roman numeral.
	 *
	 * @return the integer value of the Roman numeral.
	 */
	public int getArabicValue() {
	    return arabicValue;
	}

	/**
	 * compares this RomanNumeral object to another RomanNumeral object.
	 *
	 * @param rnum the other RomanNumeral object to compare.
	 * @return true if the two RomanNumerals are equal, false otherwise.
	 */
	public boolean equals(Object rnum) {
		// check if the objects are identical
	    if (rnum == this) { 
	    	return true;
	    }
	       // check if the object is of the correct type
	    if (!(rnum instanceof RomanNumeral)) {
	    	return false;
	    }
	    // cast the object to a RomanNumeral and compare the two objects' Roman numerals
	    RomanNumeral other = (RomanNumeral) rnum;
	    return Objects.equals(this.romanNumeral, other.romanNumeral);
	   }

	/**
	 * returns a string representation of the RomanNumeral object.
	 *
	 * @return a string representation of the RomanNumeral object.
	 */
	public String toString() {
	    return romanNumeral + " = " + arabicValue;
	}

	/**
	 * compares this RomanNumeral object to another RomanNumeral object.
	 *
	 * @param other the other RomanNumeral object to compare.
	 * @return the difference between the integer values of the two RomanNumerals.
	 */
	public int compareTo(RomanNumeral other) {
	    return this.arabicValue - other.arabicValue;
	}

	/**
	 * converts a Roman numeral string to its corresponding integer value.
	 *
	 * @param romanNumeral the string representing the Roman numeral to be converted.
	 * @return the integer value of the Roman numeral.
	 */
	private int convertToArabic(String romanNumeral) {
		int arabicNumber = 0;
        int previousValue = 0;
		 // goes through each character in the numeral string
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            // determine the value of the current Roman numeral character.
            int currentValue = romanNumeral.charAt(i) == 'I' ? 1 :
            				   romanNumeral.charAt(i) == 'V' ? 5 :
            				   romanNumeral.charAt(i) == 'X' ? 10 :
            			       romanNumeral.charAt(i) == 'L' ? 50 :
            				   romanNumeral.charAt(i) == 'C' ? 100 :
            				   romanNumeral.charAt(i) == 'D' ? 500 :
            				   romanNumeral.charAt(i) == 'M' ? 1000 : 0;
            
           
            // if current numeral value is smaller, the current value is subtracted from the total arabicNumber 
            if (currentValue < previousValue) {
                arabicNumber -= currentValue;
                //else add the two
            } else {
                arabicNumber += currentValue;
            }
            // previousValue is updated to the currentValue
            previousValue = currentValue;
        }
        return arabicNumber;
    }
}



