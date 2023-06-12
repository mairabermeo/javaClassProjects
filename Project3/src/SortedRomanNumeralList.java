
/**
 * the SortedRomanNumeralList class extends the abstract class RomanNumeralList and uses 
 * linked lists of the Roman numerals to keep its elements sorted in ascending order.
 * 
 * @author Maira Bermeo
 */
import java.util.*;

public class SortedRomanNumeralList extends RomanNumeralList {
    
    private RomanNumeralListNode head;
    private int size;
    
    /**
     * adds a Roman numeral to the list in its sorted position.
     *
     * @param romanNumeral the Roman numeral to add to the list
     */
    public void add(RomanNumeral romanNumeral) {
        RomanNumeralListNode newNode = new RomanNumeralListNode(romanNumeral);
        
        // if the list is empty or the head is greater than or equal to the new Roman numeral, insert the new node at the head.
        if (head == null || head.value.compareTo(romanNumeral) <= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            // cross the list to find the appropriate location for the new Roman numeral.
            RomanNumeralListNode current = head;
            while (current.next != null && current.next.value.compareTo(romanNumeral) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    /**
     * returns an array containing the Roman numerals in the list.
     *
     * @return an array containing the Roman numerals in the list
     */
    public RomanNumeral[] getList() {
        RomanNumeral[] array = new RomanNumeral[size];
        RomanNumeralListNode current = head;
        int i = 0;
        
        // cross the linked list and add each Roman numeral to the array.
        while (current != null) {
            array[i] = current.value;
            current = current.next;
            i++;
        }
        
        return Arrays.copyOf(array, size);
    }
    
    /**
     * a private class that represents a node in the linked list.
     */
    private class RomanNumeralListNode {
    	private RomanNumeral value;
        private RomanNumeralListNode next;
        
        /**
         * constructs a new RomanNumeralListNode with the given Roman numeral.
         *
         * @param value the Roman numeral to store in this node
         */
        private RomanNumeralListNode(RomanNumeral value) {
            this.value = value;
        }
    }
}


