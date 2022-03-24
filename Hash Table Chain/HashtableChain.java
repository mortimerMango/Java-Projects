/*
 *
 * This class is used to create the Hash Table using Single Linked List.
 * The class uses the CHAINING technique by incorporating Buckets 
 * where each hash table element references a linked list that contains
 * all the objects that hash to the same index.
 * 
 * @author Byron Teran
 *
 */
public class HashtableChain<k, v> extends SLL<k, v> implements HashMap<k,v>  {
	
	SLL<k, v> table[];									//Single Linked List Hash Table array
	
	public HashtableChain() {								//Initialize Hash Table size for key.hashCode() % table.length
		table = new SLL[5];								//Reduce collisions by increasing the table size
	}
	
	public v get(Object key) {
		
		int index = key.hashCode() % table.length;
		 if (index < 0)									//Increment index if negative value created
			 index += table.length;
		 if (table[index] == null)
			 return null; 								//key is not in the table.
		 Node<k, v> search = table[index].head;						//Look through the Linked list based on index
		 while(search != null) {
			 if(search._key.equals(key)) 
				 return search._value;						//Return value of key if it exist
			 search = search.next;							//Move to the next linked list since key wasn't found
		 }
	
		return null;									//Key was not found, return NULL
	}
	
    public v put(k key, v value) {								//Function to put in key value pairs into Single Linked List		
    	int index = key.hashCode() % table.length;						//Create hash code for index
		if (index < 0)
			 index += table.length;
		if (table[index] == null) {							//If the index is null, create a Single Linked List
			table[index] = new SLL();
			table[index].addFirst(key, value);					//Add the given key and value to Single Linked List
			return null;
		}
		
		Node<k, v> search = table[index].head;						//Reference Single Linked List with SEARCH
		while(search != null) {								//Search if Linked list contains input
			if(search._key.equals(key)) {						//If it already exist, replace and return replacement
				v oldVal = search._value;
				search._value = value;
				 return oldVal;
			}
			search = search.next;							//else keep searching till null
		}
		
		table[index].addFirst(key, value);						//While loop ended at NULL (Not found) add the key value pair to hashtable
    	return null;
    }
    public void print() {									//Print Hash Table entries
    	for(int i = 0; i<table.length; i++) {
    		if(table[i] == null)
    			System.out.println("[null]");
    		else {
    			Node<k, v> search = table[i].head;
    			
    			while(search != null) {
    				System.out.print("["+search._key+", "+search._value+"] ");
    				search = search.next;
    			}
    			System.out.println();
    		}
    	}
    }//END print()
}
