
/**
 * A linked list of Roman numeral nodes.
 * @author maira bermeo
 */
public class RomanNumeralList {
    /**
     * the head of the linked list.
     */
    protected RomanNumeralListNode head;

    /**
     * constructs an empty RomanNumeralList.
     */

    public RomanNumeralList() {
        head = null;
    }

    /**
     * adds a new node to the end of the list.
     */
    public void add() {
        RomanNumeralListNode current = head;
        while (current != null) {
            current = current.next;
        }
    }
}

