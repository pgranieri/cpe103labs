import java.util.*;
import java.io.*;

public class MyHashTest{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		MyHashTable<Integer>  htab = new MyHashTable<Integer>(10);

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	add (Enter the letter 'a')");
		System.out.println("-	find (enter the letter 'f')");
		System.out.println("-	delete (Enter the letter 'd')");
		System.out.println("-	make empty (Enter the letter 'k')");
		System.out.println("-	size (Enter the letter 's')");
		System.out.println("-	output the collection (Enter the letter 'o')");
		System.out.println("-	check if the list is empty (enter the letter 'e')");
		System.out.println("-	print (Enter the letter 'p')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,f,d,k,s,o,e,p,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be added: ");

					if (input.hasNextInt()) {
						int nq = input.nextInt();
						htab.insert(nq);

						System.out.println(nq + " added");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;

				case "d":
					System.out.println("Input a value to deleted: ");

					int del = input.nextInt();
					htab.delete(del);
					System.out.println(del + " deleted");
					input.nextLine();
					break;

				case "k":
					htab.makeEmpty();
					System.out.println("Hash table made empty.");
					break;

				case "s":
					System.out.println(htab.size() + " is the size of the hash table.");
					break;

				case "o":
					Iterator<Integer> iter = htab.iterator();
					while(iter.hasNext()){
						System.out.print(iter.next() + " ");
					}
					System.out.println();
					break;

				case "f":
					System.out.println("Input a value to be found: ");

					int fin = input.nextInt();
					if(htab.find(fin)){
						System.out.println(fin + " found");
					}else{
						System.out.println(fin + " not found");
					}	
					input.nextLine();									
					break;

				case "e":
					if(htab.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;

				case "p":
					htab.print();
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

