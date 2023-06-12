
/**
 * a node in a linked list of Roman numerals.
 * @author maira bermeo
 */
public class RomanNumeralListNode {
    /**
     * the Roman numeral stored in this node.
     */
    public RomanNumeral romanNumeral;

    /**
     * the next node in the linked list.
     */
    public RomanNumeralListNode next;

    /**
     * constructs a new RomanNumeralListNode with the given Roman numeral.
     *
     * @param romanNumeral the Roman numeral to store in this node
     */
    public RomanNumeralListNode(RomanNumeral romanNumeral) {
        this.romanNumeral = romanNumeral;
        this.next = null;
    }
}


