import java.util.*;
/**
*
* This is the BREADTH FIRST SEARCH class algorithm.
* It uses the traditional formula to create the algorithm 
* usisng an ADJACENCY LIST
* @author Byron Teran
* @ver 3.0
*
**/

public class BFS{								

	private boolean discovered[];						//Array to keep track of visted nodes
	private int L[];							//L = order of traversal
	private LinkedList Tree[];						//Breadth First Search Tree
	
	public void BreadthFirstSearch(ArrayList<LinkedList> adjlst, int start) {
		
		discovered = new boolean[adjlst.size()];			//array to hold visited nodes, currently all indexes are false by default
		L = new int[adjlst.size()];					//array to hold order of traversal
		discovered[start] = true;					//set the first index as the starting node to be true
		L[0] = start;							//first index is the start of the traversal
		int i = 0;							//counter for the position of the traversal
		Tree = new LinkedList[adjlst.size()];				//our actual BFS tree
		int k = 1;							//counter for our L array. WE start at 1 b/c START is always at index 0
		
		while(i < L.length) {						//check until we're out of traversable nodes
			Tree[i] = new LinkedList<>();				//initialize the BFS tree
			Node temp = adjlst.get(L[i]).peek();			//get the head of the linked list node
			
			while(temp != null) {					//traverse the list until there are no more nodes
				if (discovered[(int)temp.data] == false) {	//if the node we're looking at has not been discovered
					discovered[(int)temp.data] = true;	//mark it as discovered 
					Tree[i].pushBack(temp.data);		//link that now TRUE node as a child to the parent node i
					L[k] = (int)temp.data;			//that TRUE node is now set as a traversed nodes
					k++;
				}
				else
					temp = temp.next;			//current node has already been visited, so move to the next one
			}
			i++;							//all children have been checked for parent. Increment to the next parent
		}
	}//END BreadthFirstSearch()
	
	/**
	*
	* Display Fucntion shows the Breadth Firts Search Tree, and utilizes
	* the Linked List DisplayR() class function 
	*
	**/
	public void displayTree() {						
		for(int j = 0; j < L.length; j++) {
			System.out.print(L[j]+": ");				//display based of order of traversal
			Tree[j].displayR();					//display all contents from that link
		}
	}//END displayTree()
}
