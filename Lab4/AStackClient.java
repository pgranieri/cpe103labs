import java.util.*;
import java.io.*;


public class AStackClient{
	public static void main (String args[]) throws FileNotFoundException{
		int arrsize =5;
		AStack<Integer> intstack = new AStack<Integer>(arrsize);
		AStack<Float> floatstack = new AStack<Float>(arrsize);
		AStack<String> stack = new AStack<String>(arrsize);

		Scanner user_input = new Scanner(System.in);
		String filename = user_input.next();
		Scanner input = new Scanner(new FileReader(filename));

		while (input.hasNext()){
			if(input.hasNextInt()){
				intstack.push(input.nextInt());
			} else if (input.hasNextFloat()) {
				floatstack.push(input.nextFloat());
			} else {
				stack.push(input.next());
			}
		}
	   	
	   	System.out.print("Strings: ");
		while (!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();

	   	System.out.print("Floats: ");
		while (!floatstack.isEmpty()){
			System.out.print(floatstack.pop() + " ");
		}
		System.out.println();

	   	System.out.print("Integers: ");
		while (!intstack.isEmpty()){
			System.out.print(intstack.pop() + " ");
		}
		System.out.println();

	}
}