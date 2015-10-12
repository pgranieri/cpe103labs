import java.util.*;
import java.io.*;

public class StringChecker {


	public static boolean isBalanced(String symbols){
		AStack<Character> stack = new AStack<Character>(5);
		int size = symbols.length();
		char let;

		for(int i = 0; i < size; i ++) {
			let = symbols.charAt(i);

			if(let == "(".charAt(0) || let == "[".charAt(0) || let == "{".charAt(0)){
				stack.push(let);	
			} else if (let == ")".charAt(0) || let == "}".charAt(0) || let == "]".charAt(0)){
				if (stack.isEmpty()){
					return false;
				} else {
					if (let == ")".charAt(0)){
						if (stack.peek() == ("(".charAt(0))){
							stack.pop();
						} else {
							return false;
						}
					} else if (let == "]".charAt(0)){
						if (stack.peek() == ("[".charAt(0))){
							stack.pop();
						} else {
							return false;
						}
					} else if (let == "}".charAt(0)) {
						if (stack.peek() == ("{".charAt(0))){
							stack.pop();
						} else {
							return false;
						}
					}
				}
			} 
		}

		if (!stack.isEmpty()) {
			return false;
		}

		return true;
	}

	public static void main(String args[]) {
		Scanner user_input = new Scanner(System.in);
		boolean cont = true;

		System.out.println("Please Choose from the following options: ");
		System.out.println("	- Check if a string is balanced (Enter 's')");
		System.out.println("	- Quit. (Enter 'q')");
		
		while (cont) {
			System.out.println("Enter a menu choice: (s,q)");
			switch(user_input.nextLine()){
				case "s":
					System.out.println("Please give a string to be checked: ");
					System.out.println("Balnced? 				" + isBalanced(user_input.nextLine()));
					break;
				case "q":
					System.out.println("Quitting.");
					cont = false;
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
			}
		}
		
	}
}
