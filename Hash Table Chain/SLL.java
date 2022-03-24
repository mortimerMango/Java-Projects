/**
 *
 * Class for a Single Linked List (SLL) that uses
 * a Key/Value pair for CHAINING. This uses the
 * Node Class to ADD key/value objects to the
 * Single Link List. Only an addFrist method is 
 * needed to help create the HashMap this is used for.
 * 
 * @author Byron Teran
 *
 */
public class SLL<k, v> extends Node<k, v> {
	
	public Node head;						//Start of the SLL link
	private static int size = 0;					//Keep track of size of this SLL
	
	public void addFirst(k key, v value) {
		if(head == null) 
			head = new Node(key, value);			//Make head start of the link
		else 
			head = new Node(key, value , head);		//Head is not null, add new node to end of head
		size++;
	}
	public int getSize() {
		return size;
	}
	
}
