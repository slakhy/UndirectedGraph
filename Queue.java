import java.util.Iterator;

public class  Queue<Item> implements Iterable<Item> {
	
	private Node first; 
	private Node last;  
   	private int I;      // Number of items on the queue
   	
   	private  class Node{  	                     
   		Item item;
   		Node next;
   	}
   	public boolean isEmpty() {  return first == null;  }  
   	public int size()        {  return I;  }
   	
   	public void enqueue(Item item){     // Add item to the end of the list.
   		Node lastold = last;
   		last = new Node();
   		last.item = item;
   		last.next = null;
   		if (isEmpty()) first = last;
   		else           lastold.next = last;
   		I++;
   	}
   	public Item dequeue(){           // Remove item from the beginning of the list.
   		Item item = first.item;
   		first = first.next;
   		if (isEmpty()) last = null;
   		I--;
   		return item;
   	}

   	public Iterator<Item> iterator()
   	{  return new ListIterator();  }
    
   	private class ListIterator implements Iterator<Item>{
    	private Node current = first;
        public boolean hasNext()
        {  return current != null;  }
        public void remove() { }
        
        public Item next(){
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
   	
}