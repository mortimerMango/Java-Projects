/**
 * 
 * Node object used for Single Linked List (SLL).
 * This class uses a Key / Value pair for the 
 * HashMap and the Single Linked List
 * 
 * @author teran
 *
 */
public class Node<k, v> {
	public k _key;					
	public v _value;
	public Node<k, v> next;
	
	public Node() {
		_key = null;
		_value = null;
		next = null;
	}
	
	public Node(k key, v value) {
        _key = key;
        _value = value;
        next = null;
    }
	
    public Node(k key, v value, Node<k, v> nodeRef) {
    	_key = key;
        _value = value;
        next = nodeRef;
    }
    
}
