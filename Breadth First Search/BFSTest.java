import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class BFSTest {
	public static void main(String[] args)throws IOException {//needed for Scanner Class
		
		int startNode;												//used to hold value of input to start BFS
		StringBuffer buffer = new StringBuffer("");					//temporarily hold String values from text file 
		ArrayList<String> temp = new ArrayList<>();					//ArrayList to hold formatted string from StringBuffer
		ArrayList<LinkedList> adjList = new ArrayList<>();			//ArrayList to hold actual Adjacency List
		Scanner keyboard = new Scanner(System.in);					//Scanner object to read matrix file
		
		System.out.print("Please input file name: ");				//ask for the file name
		String input = keyboard.nextLine();							//get file name as String object
		
		File file = new File(input);								//Use input given to check file
		if(!file.exists()) {										//check if file exist
			System.out.printf("File %s does not exist. Exiting...", input);
			System.exit(0);
		}
		
		System.out.println("**********MATRIX****************************");
		Scanner read = new Scanner(file);								//get file to start reading contents
		while(read.hasNext()) {											//read file contents
			buffer.append(read.nextLine());								//temporarily hold string line from file
			if(checkString(buffer.toString())) {						//CHECK STRING before COMMITING to ArrayList
				temp.add(buffer.toString().replaceAll("[^0-1]", ""));	//Valid string, COMMIT everything except 0 or 1
				buffer.delete(0, buffer.length());						//clear the buffer
			}
			else {														//String was not valid
				System.out.println("Matrix contained invalid characters... closing");
				System.exit(0);											//close out program
			}
		}//END while()
		
		Iterator itr = temp.iterator();									//create iterator for temp ArrayList, size should be size(ArrayList) x size(elements)
		while(itr.hasNext()) {
			buffer.append(itr.next());									//get first index of ArrayList into buffer
			if(buffer.length() != temp.size()) {						//check if contents from index in buffer is the same size as whole temp ArrayList
				System.out.println("Matrix size not valid... closing");
				System.exit(0);											//close system b/c size was not valid
			}
			else														//size(ArrayList) x size(elements) matched 
				buffer.delete(0, buffer.length());						//clear the buffer for next string
		}//END while()
		
		for(int i = 0; i < temp.size(); i++) {										//CREATE ADJACENCY LIST
			adjList.add(new LinkedList());											//initialize adjacency list
			for(int k = 0; k < temp.get(i).length(); k++) {
				if(Integer.parseInt(String.valueOf(temp.get(i).charAt(k))) != 0) {	//add values of 1(edges) into adjacency list
					adjList.get(i).pushBack(k);										//push edge(1 elements) using LinkedList
				}
			}//END for loop INNER
		}//END for loop OUTTER
		
		if(isValidGraph(adjList)) {		
			System.out.println("**********ADJACENCY LIST*******************");//Verify Edges exist to each node
			displayAdjacencyList(adjList);								//verified true, display the ADJACENCY LIST
		}
		else {															//verified false
			System.out.println("Graph was not valid... closing");
			System.exit(0);												//close the system
		}
		
		while(true) {													//Make sure that user chooses a valid node
			System.out.println("**********\\/*******************************\n");
			System.out.print("Starting Node:");
			startNode = keyboard.nextInt();
			if(startNode < 0 || startNode >= adjList.size()) 			//check if user input is negative or greater than actual size
				System.out.println("Node "+startNode+" does not exist. Please use another... ");
			else if(adjList.get(startNode).getSize() == 0)				//Node might have 0 edges. It shouldn't be checked
				System.out.println("Node "+startNode+" is not present\n Please use another...");
			else
				break;													//input was valid, break the loop
		}
		
		BFS bfs = new BFS();											//CREATE instance of BFS
		bfs.BreadthFirstSearch(adjList, startNode);						//CREATE BFS TREE from adjacency list
		
		System.out.println("\n**********BFS TREE*************************"+
				"\nParent: Child");
		bfs.displayTree();												//display the BFS tree
		System.out.println("**********END******************************");
		
		keyboard.close();												//close scanner for keyboard reading
		read.close();													//close scanner for file reading
		
		
	}
	public static boolean checkString(String s) {
		if(Pattern.matches(".*[a-zA-Z].*", s))						//check everywhere in string for characters a-z and A-Z 
			return false;
		if(Pattern.matches(".*\\p{Punct}.*", s))					//check everywhere in string for !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
			return false;
		
		System.out.println("\t"+s);									//display the String if invalid characters were NOT found
		return true;
	}//END checkString()
	
	public static boolean isValidGraph(ArrayList<LinkedList> ajl) {	//THIS METHOD CHECKS if the graph is CONNECTED, and count actual nodes
		int nodeCount = 0;											//variable to count actual nodes
		Node temp;													//temporary node to iterate through linked list
		for(int i = 0; i < ajl.size(); i++) {						//start at 1st index of Adjacency List through last index
			temp = ajl.get(i).peek();								//get the HEAD from that Adjacency List INDEX
			
			if(temp != null)										//IF head is not null, then it's a node with a linked list
				nodeCount++;										//count the non NULL node
	
			while(temp != null) {									//ONLY check NON-NULL nodes
				if(!ajl.get((int)temp.data).contains(i)) {			//Use NODE(target) as index in adjlst to find the INDEX in LinkedList
					System.out.println("Missing edge from "+temp.data+" to "+i);
					return false;									//an edge didn't exist between nodes
				}
				else												//There were edges between nodes
					temp = temp.next;								//go the next node in linked list in current INDEX
			}
		}//END for loop
		System.out.println("number of nodes: "+nodeCount);		//display actual node count
		if(nodeCount == 0)											//Graph must have at least ONE node
			return false;											//return false b/c Graph needs at least 1 node
		return true;												//everything checks out
	}//END isValidGraph()
	
	public static void displayAdjacencyList(ArrayList<LinkedList> ajl) {
		for(int i = 0; i < ajl.size(); i++) {					//iterate through adjacency list size
			System.out.print("Node "+i+": ");					//print out starting node
			ajl.get(i).displayR();								//call display LinkedList method displayR for LinkedList contents
		}
	}//END displayAdjacencyList()
	
}//END BFSTest
