// Authors: Patrick Granieri & Nicholas Gatehouse 
// Usersids: pgranier@calpoly.edu ngatehou@calpoly.edu
// Project 1 10/8/15


import java.util.*;
import java.io.*;

public class ConTest{ 
	//Converter class driver

	public static void main(String args[]){
		//Main method for testing the converter class
		

		boolean cont = true; // boolean whether we want to continue the program
		Scanner user_input = new Scanner(System.in); // menu input
		String answer = ""; // output answer

		System.out.println("Choose one of the following operations: ");
		System.out.println("-	Infix to postfix converstion (Enter the letter 'i')");
		System.out.println("-	Postfix expression evaluation (Enter the letter 'p')");
		System.out.println("-	Arithmetic expression evaluation (Enter the letter 'a')");
		System.out.println("-	Quit (enter the letter 'q')");

		while(cont){
			System.out.print("Choose:  ");
			answer = user_input.nextLine();

			switch (answer){
				case "i": 
					System.out.println("Please give an Infix expression: ");
					answer = user_input.nextLine();

					System.out.println("The postfix expression is: " + Converter.infixToPostfix(answer));
					break;	

				case "p":
					System.out.println("Please give an Postfix expression: ");
					answer = user_input.nextLine();

					System.out.println("The value of the Postfix expression is: " + Converter.postfixValue(answer));
					break;

				case "a":
					System.out.println("Please give an Arithmetic expression: ");
					answer = user_input.nextLine();

					System.out.println("The value of the Arithmetic expression is: " + Converter.postfixValue(Converter.infixToPostfix(answer)));
					break;

				case "q":
					cont = false;
					System.out.println("Quitting.");
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		System.out.println("Adios, Mi Amigo.");
	}
}