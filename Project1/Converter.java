// Authors: Patrick Granieri & Nicholas Gatehouse 
// Usersids: pgranier@calpoly.edu ngatehou@calpoly.edu
// Project 1 10/8/15

import java.io.*;
import java.util.*;

public class Converter {
	//converts Infix expressions into PostFix expressions and evaluates the expressions 
	
	public static String infixToPostfix(String expression) {
		//converts Infix expressions into PostFix expressions 

		Scanner input = new Scanner(expression); //Scanner that cycles through input expression.
		MyStack<String> stack = new MyStack<String>(); // Instance of MyStack made of Strings
		String temp; // temporary string values
		String output = ""; //The string that will be returned
		String[] low = {"+","-"}; //Collection of low priority operators
		String[] high = {"/","*"}; //Collection of high priority operators

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
					if (!stack.isEmpty() && (contains(high, stack.peek()))) {
						output += stack.pop() + " ";
					}
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
		// returns true if the value is found within the string

		for (String cur : arr) {
			if (cur.equals(val)){
				return true;
			} 
		}
		return false;
	}

	public static double postfixValue(String expression){
		// evaluates the postfix value

		Scanner input = new Scanner(expression); //Scanner that cycles through input expression.
		MyStack<Double> stack = new MyStack<Double>(); // instance of MyStack using type Double
		double temp1, temp2, result; // declaration of Double variables	
		String opr = ""; // the operators for the switch statement

		while(input.hasNext()){
			if (input.hasNextFloat()) {
				stack.push((double)input.nextFloat());
			} else {
				switch(opr = input.next()){
					case("+"):
						temp2 = stack.pop();
						temp1 = stack.pop();
						result = temp1 + temp2;
						stack.push(result);
						break;

					case("-"):
						temp2 = stack.pop();
						temp1 = stack.pop();
						result = temp1 - temp2;
						stack.push(result);
						break;

					case("*"):
						temp2 = stack.pop();
						temp1 = stack.pop();
						result = temp1 * temp2;
						stack.push(result);
						break;

					case("/"):
						temp2 = stack.pop();
						temp1 = stack.pop();
						result = temp1 / temp2;
						stack.push(result);
						break;
				}
			}
		}
		return stack.pop();
	}
}
