import java.util.*;
import java.io.*;

public class AStackDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int arrsize =5;
		AStack<Integer> stack = new AStack<Integer>(arrsize);

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	push/add (Enter the letter 'a')");
		System.out.println("-	pop/delete (Enter the letter 'd')");
		System.out.println("-	peek/CheckTopElement (Enter the letter 'p')");
		System.out.println("-	check if the list is empty (enter the letter 'e')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,p,e,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be pushed: ");

					if (input.hasNextInt()) {
						int nq = input.nextInt();
						stack.push(nq);

						System.out.println(nq + " pushed.");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				case "d":
					try{
						System.out.println(stack.pop() + " popped.");
					} catch (AStack.MyException e){
						System.out.println("Invalid Operation: The stack is empty.");
					}
					break;
				case "p":
					try{
						System.out.println(stack.peek() + " peeked");
					} catch (AStack.MyException e){
						System.out.println("Invalid Operation: The stack is empty.");
					}
					break;	
				case "e":
					if(stack.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;
				case "q":
					cont = false;
					System.out.println("Quitting.");
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
			}
		}

		while (!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
}