
/**
 * Thrown to indicate that a given string is not a valid Roman numeral.
 */
public class IllegalRomanNumeralException extends IllegalArgumentException {

    /**
     * Constructs a new IllegalRomanNumeralException object with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval by the getMessage() method.
     */
    public IllegalRomanNumeralException(String message) {
        super(message);
    }
}

