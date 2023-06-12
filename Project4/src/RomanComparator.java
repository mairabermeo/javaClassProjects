
import java.util.Comparator;
import java.util.TreeMap;

/**
 * The RomanComparator class is responsible for sorting a list of Roman numerals based on their
 * equivalent Arabic values. It uses a TreeMap to store the numerals in ascending order of their values.
 */
public class RomanComparator {

    // TreeMap that stores RomanNumeral objects sorted by their equivalent Arabic values
    private TreeMap<RomanNumeral, Integer> sortedNumerals;

    /**
     * Constructs a RomanComparator object with the specified array of Roman numerals. The numerals
     * are sorted based on their equivalent Arabic values.
     *
     * @param romanNumerals the array of Roman numerals to be sorted
     */
    public RomanComparator(String[] romanNumerals) {
        // Create a TreeMap with a custom comparator that sorts RomanNumeral objects by their equivalent Arabic values
        sortedNumerals = new TreeMap<>(new Comparator<RomanNumeral>() {
            public int compare(RomanNumeral rn1, RomanNumeral rn2) {
                if (rn1.getArabicValue() < rn2.getArabicValue()) {
                    return -1;
                } else if (rn1.getArabicValue() > rn2.getArabicValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        // Iterate through each Roman numeral in the array, parse it through RomanNumeral object, add to the sortedNumerals TreeMap
        for (String numeral : romanNumerals) {
            try {
                RomanNumeral romanNumeral = new RomanNumeral(numeral.trim());
                sortedNumerals.put(romanNumeral, romanNumeral.getArabicValue());
            } catch (IllegalRomanNumeralException e) {
                // If the Roman numeral is invalid, print an error message to the console
                System.out.println("Illegal Roman numeral: " + numeral.trim());
            }
        }
    }

    /**
     * Returns the TreeMap of sorted Roman numerals.
     *
     * @return the TreeMap of sorted Roman numerals
     */
    public TreeMap<RomanNumeral, Integer> getSortedNumerals() {
        return sortedNumerals;
    }
}

