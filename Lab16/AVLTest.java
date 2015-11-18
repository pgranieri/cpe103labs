import java.io.*;
import java.util.*;

public class AVLTest{
	public static void main(String args[]){
		//main method used to test the BST structure. 

		Scanner input = new Scanner(System.in);
		BasicAVL avl = new BasicAVL();

		System.out.println("Choose one of the following operations: ");
		System.out.println(" a- Add the element ");		
		System.out.println(" p-	Print the tree in Pre-order using iterator ");		
		System.out.println(" q-	Quit the Program");

		String answer; // variable for the letter input
		boolean cont = true; // variable to see if user quits program

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,p,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be added: ");

					if (input.hasNextInt()) {
						int in = input.nextInt();
						avl.insert(in);
						System.out.println(in + " inserted");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				
				case "p":
					avl.print();
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