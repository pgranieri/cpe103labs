import java.util.*;
import java.io.*;

public class ConTest{
	public static void main(String args[]){
		

		boolean cont = true;
		Scanner user_input = new Scanner(System.in);
		String answer = "";

		System.out.println("Choose one of the following operations: ");
		System.out.println("-	Infix to postfix converstion (Endter the letter 'i')");
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
					break;

				case "a":
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

		//Still needed:
		//	a case, p case, thorough testing of functions.

		//I just set up the framework for this one, there's not much complicated about it. You've
		// seen it before

		// Original contents: 
		// String test = "a  +  b * c  + ( d * e + f ) *   g";
		// System.out.println(Converter.infixToPostfix(test));

		// test = "4.0 2.5 3.5 + * 2.0 / 8.0 9.0 + +"; //Expected Value: 29.0
		// System.out.println(Converter.postfixValue(test)); 