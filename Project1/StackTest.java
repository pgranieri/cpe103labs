import java.util.*;
import java.io.*;

public class StackTest {
	public static void main (String args[]){
		MyStack<String> sms = new MyStack<String>();
		Scanner keyboard = new Scanner(System.in);
		boolean cont = true;
		String answer;

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	push/add (Enter the letter 'a')");
		System.out.println("-	pop/delete (Enter the letter 'd')");
		System.out.println("-	peek (Enter the letter 'p')");
		System.out.println("-	check if the list is empty (enter the letter 'e')");
		System.out.println("-	quit (enter the letter 'q')");

		while(cont){
			System.out.print("Choose:  ");

			answer = keyboard.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be pushed: ");

					if (keyboard.hasNext()) {
						String pushy = keyboard.nextLine();
						sms.push(pushy);

						System.out.println(pushy + " pushed in.");						
					} else {
						System.out.println("Invalid Value.");
					}
					break;

				case "d":
					try{
						System.out.println(sms.pop() + " popped out.");
					} catch (EmptyStackException e){
						System.out.println("Invalid Operation: The stack is empty.");
					}
					break;

				case "p":
					try{
						System.out.println(sms.peek() + " on the top.");
					} catch (EmptyStackException e){
						System.out.println("Invalid Operation: The stack is empty.");
					}
					break;

				case "e":
					if(sms.isEmpty()){
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

		System.out.println("Adios, Mi Amigo.");
	}
}