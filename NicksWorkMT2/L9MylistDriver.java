import java.util.*;
import java.io.*;

public class L9MylistDriver{ // dont use recursion
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		MySortedList list = new L9MySortedList();

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	add (Enter the letter 'a')");
		System.out.println("-	delete (Enter the letter 'd')");
		System.out.println("-	max (enter the letter 'x')");
		System.out.println("-	min (enter the letter 'm')");
		System.out.println("-	print array (enter the letter 'p')");
		System.out.println("-	check if list is empty (enter the letter 'e')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,x,m,p,e,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be added: ");

					if (input.hasNextInt()) {
						int ad = input.nextInt();
						list.add(ad);

						System.out.println(ad + " Add");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				case "d":
					System.out.println("input a value to be deleted :)");
					int de = input.nextInt();
					list.delete(de); 
					System.out.println(de + " is deleted");
					input.nextLine();
					
					break;
				case "x":
						if (list.isEmpty()) {
							System.out.println("invalid operation.");
						} else {
							System.out.println(list.max() + " is the maximum");					
						}
					break;
				case "m":
					if(list.isEmpty()){
						System.out.println("invalid operation.");
					} else {
						System.out.println(list.min() + " is the min");					
					}
					break;		
				case "e":
					if(list.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;
				case "p":
					list.print();
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