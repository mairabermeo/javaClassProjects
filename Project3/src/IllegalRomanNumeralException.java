

/**
 * Thrown to indicate that a given string is not a valid Roman numeral.
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {

    /**
     * Constructs an IllegalRomanNumeralException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public IllegalRomanNumeralException(String message) {
        super(message);
    }
}



