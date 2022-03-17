import java.util.*;

public class LinkedList<T>{
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	public LinkedList() {						//Default constructor
		head = tail;
	}
	
	public LinkedList(T data) {					//parameterized constructor
		pushFront(data);
	}
	
	public void pushFront(T data) {					//Function to place object front of Linked List
		if(this.head == null) {
			this.head = new Node(data, null, null);
			this.tail = this.head;
			size++;
		}
		else {
			Node temp = new Node(data, null, this.head);
			this.head.prev = temp;
			this.head = temp;
			size++;
		}
	}//pushFront()
	
	public void pushBack(T data) {					//Fucntion to place object to rear of Linked List
		if(this.tail == null) {
			pushFront(data);				//same thing as pushFront for first Node
		}
		else {
			Node temp = new Node(data, this.tail, null);
			this.tail.next = temp;
			this.tail = temp;
			size++;
		}
	}//pushBack()
	
	public int getSize() {						//Fucntion to return amount of links for this Linked List
		return size;
	}
	
	public Node peek() {						//Function to get the head of the Linked List
		if(head == null)
			return null;
		else {
			Node temp = head;
			return temp;
		}
	}
	
	public boolean contains(T target) {				//Function to locate object in Linked List
		Node temp = head;
		while(temp != null) {
			if(temp.data == target) 
				return true;
			else
				temp = temp.next;
		}

		return false;
	}//END contains()
	
	public void displayR() {					//Helper Function to display contents of Linked List
		Node temp = this.head;
		displayR(temp);
	}
	private void displayR(Node temp) {				//Recursive function to diplay contents of linked list
		if(temp != null) {
			System.out.printf(" --[%2d]", temp.data);
			displayR(temp.next);
		}
		else { 
			System.out.println();
		}
	}//displayR()
}
