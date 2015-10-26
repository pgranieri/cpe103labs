import java.util.*;
import java.io.*;

public class BSTWork{
	public void static main(String args[]){
		Scanner input = new Scanner(System.in);
		BasicBST basic = new BasicBST();

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
					input.nextLine();					
					break;

					
				case "x":
						if (basic.isEmpty()) {
							System.out.println("invalid operation.");
						} else {
							System.out.println(basic.max() + " is the maximum");					
						}
					break;
				case "m":
					if(basic.isEmpty()){
						System.out.println("invalid operation.");
					} else {
						System.out.println(basic.min() + " is the min");					
					}
					break;		
				case "e":
					if(basic.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;
				case "p":
					basic.print();
					System.out.println();
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