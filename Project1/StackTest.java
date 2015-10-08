// Authors: Patrick Granieri & Nicholas Gatehouse 
// Usersids: pgranier@calpoly.edu ngatehou@calpoly.edu
// Project 1 10/8/15

import java.util.*;
import java.io.*;

public class StackTest {
	// Test Driver for the MyStack class

	public static void main (String args[]){ 
		// Main method for testing

		MyStack<String> sms = new MyStack<String>(); // Instance of MyStack made of Strings
		Scanner keyboard = new Scanner(System.in);	//User input from keyboard
		boolean cont = true;	//boolean variable made to keep the while going until told otherwise
		String answer; 	// Placeholder for all input given by user. 

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