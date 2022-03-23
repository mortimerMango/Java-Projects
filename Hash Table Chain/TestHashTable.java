/**
 * 
 * This is the driver class to test the Hash Table Chain 
 * 
 * @author Byron Teran
 *
 */
public class TestHashTable {
	public static void main(String[] args) {
		HashtableChain<String, String> chain = new HashtableChain<>();
		chain.put("C11", "Lion");
		chain.put("C01", "Penguin");
		chain.put("C51", "Rhino");
		chain.put("C3", "Chameleon");
		chain.put("C92", "African Snail");
		chain.print();
		
		
		System.out.println(chain.get("Chameleon"));
	}
}
