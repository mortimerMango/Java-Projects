/**
 *
 * Interface to define the HashMap functionality.
 * This is used with the Hash Table Chain file
 * to build the actual Hash Map table.
 * 
 * @author Byron Teran
 *
 */
public interface HashMap<k, v> {
	v get(Object key);				//retrieve the object based on the key encryption
    v put(k key, v value);			//Append new values using a key encryption and value

}
