import java.io.*;
import java.util.*;

public class Converter {
	public static String infixToPostfix(String expression) {

		Scanner input = new Scanner(expression);
		MyStack<String> stack = new MyStack<String>();
		String temp;
		String output = "";
		String[] low = {"+","-"}; 
		String[] high = {"/","*"};

		while (input.hasNext()){
			switch(temp = input.next()){
				case"+": case"-":
					if (!stack.isEmpty() && contains(high,stack.peek())) {
						while(!stack.isEmpty() && !stack.peek().equals("(")) {
							output += stack.pop() + " ";
						}
					} 
					stack.push(temp);
					break;

				case"*": case"/":
					stack.push(temp);
					break;			

				case"(":
					stack.push(temp);
					break;

				case")":
					while(!stack.peek().equals("(")){
						output += stack.pop() + " ";
					}
					stack.pop();
					break;

				default :
					output += temp + " ";
					break;
			}
		}

		while (!stack.isEmpty()){
			output += stack.pop() + " ";
		}

		return output;
	}

	private static boolean contains (String [] arr, String val) {
		for (String cur : arr) {
			if (cur.equals(val)){
				return true;
			} 
		}

		return false;
	}
}
// 	temp = input.next();
		// 	if (contains(operators, temp)){

		// 		if(contains(low,temp)){
		// 			if (!stack.isEmpty() && contains(high,stack.peek()) {
		// 				while(!stack.isEmpty() && !stack.peek().equals("(")) {
		// 					output += stack.pop() + " ";
		// 				}
		// 			} 
		// 			stack.push(temp);
		// 		} else if (contains(high, temp)){

		// 		} else if (temp.equals("(")){
		// 			stack.push(temp);
		// 		} else{
		// 			while(!stack.peek().equals("(")){
		// 				output += stack.pop() + " ";
		// 			}
		// 			stack.pop();
		// 		}

		// 	} else {
		// 		output += temp + " ";
		// 	}
		// } else {
		// 	while (!stack.isEmpty()) {
		// 		output += stack.pop() + " ";
		// 	}
		// }