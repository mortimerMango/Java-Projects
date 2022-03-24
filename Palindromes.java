import java.util.*;

public class Palindromes {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		System.out.printf("Palindrome Checker%nPlease type a word or sentence:%n" );
		String check = input.nextLine();
		String checker = check.replaceAll("[^a-zA-Z_0-9]+", "");//replace EVERTHING except letters a -z and A - Z and numbers 0-9 one or more times with empty space

		System.out.printf("Is \"%s\" a Palindrome? %b",check, isPalindrome(checker));
	
		input.close();
	}
	
	public static boolean isPalindrome(String checkStr) {
		
		Stack<Character> stack = new Stack<>();//create char stack
		for(int x = 0; x < checkStr.length(); x++) //add each char from string to stack
			stack.push(checkStr.charAt(x));
	
		int x = 0;//incrementor for checkStr
		String r = new String();//String to hold top of stack
		
		while(!stack.empty()) {
			r =r.valueOf(stack.peek());//get object from top of stack
			if(checkStr.valueOf(checkStr.charAt(x)).equalsIgnoreCase(r)) {//compared first char in string to top object from stack
				stack.pop();//remove object from top of stack
				x++;//increment for regular string
			}
			else
				return false;//does not match
		}
		
		return true;//return TRUE b/c everything matched or string contained 1 char(even empty String)
		
	}//END isPalindrom()
}
