import java.util.*;

public class LinkedList<T>{
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	public LinkedList() {//constructor
		head = tail;
	}
	
	public LinkedList(T data) {//parameterized constructor
		pushFront(data);
	}
	
	public void pushFront(T data) {
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
	
	public void pushBack(T data) {
		if(this.tail == null) {
			pushFront(data);//same thing as pushFront for first Node
		}
		else {
			Node temp = new Node(data, this.tail, null);
			this.tail.next = temp;
			this.tail = temp;
			size++;
		}
	}//pushBack()
	
	public int getSize() {
		return size;
	}
	
	public Node peek() {
		if(head == null)
			return null;
		else {
			Node temp = head;
			return temp;
		}
	}
	
	public boolean contains(T target) {
		Node temp = head;
		while(temp != null) {
			if(temp.data == target) 
				return true;
			else
				temp = temp.next;
		}

		return false;
	}//END contains()
	
	public void displayR() {
		Node temp = this.head;
		displayR(temp);
	}
	private void displayR(Node temp) {
		if(temp != null) {
			System.out.printf(" --[%2d]", temp.data);
			displayR(temp.next);
		}
		else { 
			System.out.println();
		}
	}//displayR()
}
