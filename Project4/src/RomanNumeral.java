

import java.util.*;

/**
 * A class for representing Roman numerals and converting them to Arabic numerals.
 */
public class RomanNumeral{ 
    
    /**
     * A mapping from Roman numeral characters to their corresponding Arabic values.
     */
    private static Map<Character, Integer> romanToArabicMap;
    
    static {
        romanToArabicMap = new HashMap<>();
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }
    
    private String romanNumeral;
    private int arabicValue;
    
    /**
     * Creates a new RomanNumeral object from the given Roman numeral string.
     * 
     * @param romanNumeral the Roman numeral string to create an object from
     * @throws IllegalRomanNumeralException if the given string contains an invalid Roman numeral character
     */
    public RomanNumeral(String romanNumeral) {
        for (int i = 0; i < romanNumeral.length(); i++) {
            char c = romanNumeral.charAt(i);
            if (!romanToArabicMap.containsKey(c)) {
                throw new IllegalRomanNumeralException("Invalid character in Roman numeral: " + c);
            }
        }
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);
    }
    
    /**
     * Returns the Roman numeral string represented by this object.
     * 
     * @return the Roman numeral string represented by this object
     */
    public String getRomanNumeral() {
        return romanNumeral;
    }
    
    /**
     * Sets the Roman numeral string represented by this object, and updates the Arabic value accordingly.
     * 
     * @param romanNumeral the new Roman numeral string to represent with this object
     */
    public void setRomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);
    }
    
    /**
     * Returns the Arabic value of this Roman numeral.
     * 
     * @return the Arabic value of this Roman numeral
     */
    public int getArabicValue() {
        return arabicValue;
    }
    
    /**
     * Compares this Roman numeral to another Roman numeral for equality.
     * 
     * @param rnum the other Roman numeral to compare to
     * @return true if the two Roman numerals are equal, false otherwise
     */
    public boolean equals(Object rnum) {
        if (rnum == this) { 
            return true;
        }
        if (!(rnum instanceof RomanNumeral)) {
            return false;
        }
        RomanNumeral other = (RomanNumeral) rnum;
        return Objects.equals(this.romanNumeral, other.romanNumeral);
    }
    
    /**
     * Returns a string representation of this Roman numeral.
     * 
     * @return a string representation of this Roman numeral
     */
    public String toString() {
        return romanNumeral;
    }
    
    /**
     * This method compares the current RomanNumeral object with another RomanNumeral object passed as a parameter.
     * @param other the RomanNumeral object to be compared with
     * @return an integer value representing the difference between the Arabic values of the two RomanNumeral objects
     */
	public int compareTo(RomanNumeral other) {
	    return this.arabicValue - other.arabicValue;
	}
	
	 /**
     * This method converts a Roman numeral to an Arabic numeral.
     * @param romanNumeral a String representation of the Roman numeral to be converted
     * @return an integer value representing the Arabic equivalent of the Roman numeral
     * @throws IllegalRomanNumeralException if the input string contains an invalid character
     */
	public static int convertToArabic(String romanNumeral) {
	    int arabicNumber = 0;
	    int previousValue = 0;
	    for (int i = romanNumeral.length() - 1; i >= 0; i--) {
	        char c = romanNumeral.charAt(i);
	        int currentValue = 0;
	        switch (c) {
	            case 'I': currentValue = 1;
	            	break;
	            case 'V': currentValue = 5;
	                break;
	            case 'X': currentValue = 10;
	                break;
	            case 'L': currentValue = 50;
	                break;
	            case 'C': currentValue = 100;
	                break;
	            case 'D': currentValue = 500;
	                break;
	            case 'M': currentValue = 1000;
	                break;
	            default:
	                throw new IllegalRomanNumeralException("Invalid character in Roman numeral: " + c);
	        }
	        // if the current value is less than the previous value, subtract it from the total
	        // otherwise, add it to the total
	        if (currentValue < previousValue) {
	            arabicNumber -= currentValue;
	        } else {
	            arabicNumber += currentValue;
	        }
	        previousValue = currentValue;
	    }
	    return arabicNumber;
	}
}



