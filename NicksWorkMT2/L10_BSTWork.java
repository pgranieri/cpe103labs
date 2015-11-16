import java.io.*;
import java.util.*;

public class L10_BSTWork{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		L10_BasicBST basic = new L10_BasicBST();

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	add (Enter the letter 'a')");
		System.out.println("-	odds (Enter the letter 'o')");
		System.out.println("-	height (enter the letter 'h')");
		System.out.println("-	leaves (enter the letter 'l')");
		System.out.println("-	one child nodes  (enter the letter 'c')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,o,h,l,c,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be added: ");

					if (input.hasNextInt()) {
						int ad = input.nextInt();
						basic.insert(ad);

						System.out.println(ad + " Add");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;

				case "o":
					int odds = basic.countOdds(); 
					System.out.println( odds + " is the number of odds");					
					break;

					
				case "h":
					System.out.println("The height of the tree is " + basic.height());
					break;


				case "l":
					System.out.println("The number of leaves is " + basic.countLeaves());					
					break;

				case "c":
					System.out.println("The number of one child nodes is " + basic.countOneChildParents());
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