
/**
 * The UnsortedRomanNumeralList class extends the abstract class RomanNumeralList and
 * represents a list of Roman numerals in an unsorted order.
 * @author maira bermeo
*/

import java.util.*;

public class UnsortedRomanNumeralList extends RomanNumeralList {
    private RomanNumeralListNode head;

    /**
     * adds a RomanNumeral to the end of the list.
     *
     * @param romanNumeral the RomanNumeral to be appended to the list.
     */
    public void append(RomanNumeral romanNumeral) {
        RomanNumeralListNode newNode = new RomanNumeralListNode(romanNumeral);
        if (head == null) {
            head = newNode;
        } else {
            RomanNumeralListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * returns an array of RomanNumerals in the order they were added to the list.
     *
     * @return an array of RomanNumerals in the order they were added to the list.
     */
    public RomanNumeral[] getList() {
        List<RomanNumeral> list = new ArrayList<>();
        RomanNumeralListNode current = head;
        while (current != null) {
            list.add(current.numeral);
            current = current.next;
        }
        RomanNumeral[] array= list.toArray(new RomanNumeral[0]);
        return array;
    }

    /**
     * a private inner class that represents a node in the unsorted RomanNumeralList.
     */
      private static class RomanNumeralListNode {
        RomanNumeral numeral;
        RomanNumeralListNode next;

        /**
         * constructor for the RomanNumeralListNode.
         *
         * @param numeral the RomanNumeral to be stored in the node.
         */
       RomanNumeralListNode(RomanNumeral numeral) {
            this.numeral = numeral;
        
       }
      }
}