import java.util.*;
import java.io.*;

public class MyListDriver{
	public static void main(String args[]){
		MyList list = new MyList();

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	Add Element (Enter the letter 'a')");
		System.out.println("-	Find Element (Enter the letter 'f')");
		System.out.println("-	Print List (enter the letter 'p')");
		System.out.println("-	Sum List (enter the letter 's')");
		System.out.println("-	quit (enter the letter 'q')");

		Scanner input = new Scanner(System.in);
		boolean cont = true;
		String answer;

		while(cont){
			System.out.println("Input menu choice a,f,p,s,q: ");
			answer = input.nextLine();
			switch(answer){

				case "a":
					System.out.println("Input a value to be added: ");
					list.add(input.nextInt());
					System.out.println("Added.");
					input.nextLine();
					break;

				case "f":
					System.out.println("Input a value to be found: ");
					System.out.println("found: " + list.find(input.nextInt()));
					input.nextLine();
					break;

				case "p":
					list.print();
					System.out.println();
					break;

				case "s":
					System.out.println("sum: " + list.sum());
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
	}
}