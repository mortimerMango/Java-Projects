
public class Node<T>{					//GENERAL CLASS Node Object used for Linked List
	
	public T data;					//hold whatever object to be used as a node
	public Node prev;
	public Node next;
	
	public Node(T data, Node next) {		//Parameterized Constructor 
		this.data = data;
		this.next = next;
	}
	
	public Node(T data, Node _head, Node _tail) {	//Constructor used for Linked List
		this.data = data;
		prev = _head;
		next = _tail;
	}
	
	public String toString() {			//Value to be returned when toString() is called
		return "["+data+"]";
	}
}
