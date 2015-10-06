import java.io.*;
import java.util.*;

public class Converter {

	//We did this method together. Haven't touched it.
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

	//Patrick Began Work Here

	public static double postfixValue(String expression){
		Scanner input = new Scanner(expression);
		MyStack<Double> stack = new MyStack<Double>();
		double temp1, temp2, result;
		String opr = "";

		while(input.hasNext()){
			//While there are still charachters left, either push them onto the stack or apply the operator
			// to the two top numbers in the stack. We were asked to cast all nnumbers as doubles
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
		//Return the last item in the stack, the answer, once the input is empty.
		return stack.pop();
	}

}
