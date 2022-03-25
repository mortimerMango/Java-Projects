/**
 * 
 * This is the Binary Search Tree algorithm using Comparable<E>.
 * The class is able to Add nodes using the inner private class Node,
 * remove nodes, Search for nodes, and retrieve left or right subtrees,
 * and display the binary tree. 
 * 
 * @author Byron Teran
 *
 */
public class BST<E extends Comparable<E>> {
	private class Node{
		E data;
		Node left;
		Node right;
		
		private Node(E data, Node leftChild, Node rightChild) {
			this.data = data;
			left = leftChild;
			right = rightChild;
		}
	}//NODE
		
	private Node root;
	private static int size = 0;
		
	public boolean add(E data) {
		int size_clone = size;					//get original size
		root = add(data, root);
		return !(size_clone == size);				//compare original size to new potential size
		
	}
	private Node add(E data, Node r_clone) {
		
		if(r_clone == null) {
			size++;
			return new Node(data, null, null);
		}
		else {
			int comparison = data.compareTo(r_clone.data);
			if(comparison < 0)
				r_clone.left = add(data, r_clone.left);
			else if(comparison > 0)
				r_clone.right = add(data, r_clone.right);
			else 
				return r_clone;				//there was a duplicate, and we're just returning the original node
			
			return r_clone;					//return whatever was added or not
		}	
	}
	
	public boolean contains(E target) {				//function to check if given value exist in BST return TRUE if found, FALSE otherwise 
		return contains(target, root);
	}
	private boolean contains(E target, Node r_clone) {
		if(r_clone == null)
			return false;
		else if(target.compareTo(r_clone.data) == 0)
			return true;
		else if(target.compareTo(r_clone.data) < 0)
			return contains(target, r_clone.left);
		else
			return contains(target, r_clone.right);
	}
	
	public boolean remove(E data) {
		int size_clone = size;
		root = remove(data, root);
		return !(size_clone == size);
	}
	private Node remove(E data, Node r_clone) {
		
		if(r_clone == null)
			return null;
		else if(data.compareTo(r_clone.data) < 0)			//go left
			r_clone.left = remove(data, r_clone.left);
		else if (data.compareTo(r_clone.data) > 0)			//go right
			r_clone.right = remove(data, r_clone.right);
		else {								//we got a match
			if(r_clone.left != null && r_clone.right != null) {	//two children
				r_clone.data = removeNode(r_clone.right, r_clone);
				size--;
				return r_clone;
			}
			else if(r_clone.left == null && r_clone.right == null) {//no children
				size--;
				return null;
			}
			else if(r_clone.left != null) {				//left child only
				size--;
				return r_clone.left;
			}
			else{							//right child only
				size--;
				return r_clone.right;
			}
		}
		return r_clone;							//return subtree 
	}
	
	private E removeNode(Node temp, Node temp_shadow) {			//helper function to remove node from tree
		
		if(temp.left == null) {
			E copyData = temp.data;
			if(temp_shadow.right == temp) {				//check if parent node came from the right
				if(temp.right == null)
					temp_shadow.right = null;
				else
					temp_shadow.right = temp.right;
			}
			else {
				if(temp.right == null)				//children are null
					temp_shadow.left = null;
				else 						//right child is not null
					temp_shadow.left = temp.right;
			}
			return copyData;
		}
		else 
			return removeNode(temp.left, temp);
	}
	
	public BST<E> getLeftSubtree(){						//Shallow copy of left subtree from Root
		
		BST<E> copy = new BST<>();
		if(this.root.left == null)
			return copy;
		else if(isLeaf()) 
			copy.root = new Node(this.root.data, null, null);
		else
			copy.root = new Node(this.root.left.data, this.root.left.left, this.root.left.right);
	
		return copy;
		
	}
	public BST<E> getRightSubtree(){					//shallow copy of right subtree from root
		
		BST<E> copy = new BST<>();
		if(this.root.right == null)
			return copy;
		else if(isLeaf()) 
			copy.root = new Node(this.root.data, null, null);
		else
			copy.root = new Node(this.root.right.data, this.root.right.left, this.root.right.right);
	
		return copy;
	
	}
	
	public boolean isLeaf() {						//helper function for getLeft/getRightSubtree()
		return (root.left == null && root.right == null);
	}//isLEAF()
	
	public void prefix() {
		System.out.println("PREFIX");
		prefix(root);
		System.out.println();
	}
	private void prefix(Node r_clone) {
		if(r_clone == null)
			return;
		else {
			System.out.print(r_clone.data+" ");
			prefix(r_clone.left);
			prefix(r_clone.right);
		}
	}
	
	public void inorder() {
		System.out.println("INORDER");
		inorder(root);
		System.out.println();
	}
	private void inorder(Node r_clone) {
		if(r_clone == null)
			return;
		else {
			inorder(r_clone.left);
			System.out.print(r_clone.data+" ");
			inorder(r_clone.right);
		}
	}
	
	public void postfix() {
		System.out.println("POSTFIX");
		postfix(root);
		System.out.println();
	}
	private void postfix(Node r_clone) {
		if(r_clone == null)
			return;
		else {
			postfix(r_clone.left);
			postfix(r_clone.right);
			System.out.print(r_clone.data+" ");
		}
	}
	
	public void nodeLook() {							//public function to to send reference for - nodeLook()
		Node temp = root;
		nodeLook(temp);
	}
	private void nodeLook(Node temp) {						//helper method to show path of nodes prefix style
		if(temp == null)
			return;
		else {
			System.out.print("root: "+temp.data);
			if(temp.left == null)
				System.out.print(", left: null");
			else
				System.out.print(", left: "+temp.left.data);
			
			if(temp.right == null)
				System.out.print(", right: null");
			else
				System.out.print(", right: "+temp.right.data);
			
			System.out.println();
			nodeLook(temp.left);
			nodeLook(temp.right);
		}
	}
	
	public int getSize() {								//return current amount of nodes
		return size;
	}
}
