
//-----------------------------------------------------
// Title: Bag class
// Author: Sevkıye Sıla Kahya
// ID: 14620089482
// Section: 03
// Assignment: 1
// Description: Structure of Bag object.
//-----------------------------------------------------

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
	
    private Node<Item> first;    // First node in bag
    private int e;               // Number of elements 

    // Helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        e = 0;
    }

    
    public boolean isEmpty() {   //Returns true if this bag is empty.
        return first == null;
    }

    public int size() {   //Returns the number of items in this bag.
        return e;
    }
    
    public void add(Item item) {
        Node<Item> oldfirst = first;   //Adds the item to this bag.
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        e++;
    }

    public Iterator<Item> iterator()  {      //Returns an iterator that iterates over the items in this bag in arbitrary order.
        return new LinkedIterator(first);  
    }

                                                                  
    private class LinkedIterator implements Iterator<Item> { // an iterator which doesn't implement remove() since it's optional
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

	
}