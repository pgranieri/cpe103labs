import java.io.*;
import java.util.*;

public class HeapTest {
	public static void main(String args[]){
		Scanner user_input = new Scanner(System.in);		
		boolean cont = true;		
		String answer;		
		int size;
		System.out.println("How big would you like the heap to be? ");
		size = user_input.nextInt();
		user_input.nextLine();
		BinHeap<String> myHeap = new BinHeap<String>(size);
		
		System.out.println("Choose one of the following operations: ");
		System.out.println("	- add an element (enter the letter 'a')");
		System.out.println("	- delete the smallest element (enter the letter 'd')");
		System.out.println("	- is the heap empty (enter the letter 'e')");
		System.out.println("	- size of the collection (enter the letter 's')");
		System.out.println("	- print the collection (enter the letter 'p')");
		System.out.println("	- Quit (enter the letter 'q')");
		



		while(cont){
			System.out.println("Enter a menu choice:  ");
			answer = user_input.nextLine();
			
			switch(answer){
				case "a":
					System.out.println("What would you like to add? ");
					String hin = user_input.nextLine();
					myHeap.insert(hin);
					System.out.println(hin +  " added.");
					break;

				case "d":
					try{
						System.out.println(myHeap.deleteMin() + " deleted.");
					} catch (BinHeap.MyException e) {	
						System.out.println("Invalid operation on Empty Heap.");	
					}	
					break;
				case "e":
					if (myHeap.isEmpty()){
						System.out.println("Heap is empty.");
					} else {
						System.out.println("Heap is not empty.");
					}
					break;
				case "s":
					System.out.println("The size is " + myHeap.size());
					break;
				case "p":
					System.out.println(myHeap);
					break;
				case "q":
					System.out.println("Quitting.");
					cont = false;
					break;
				default:
					System.out.println("Invalid Choice.");
					break;

			}
		
		
		}


		while(!myHeap.isEmpty()){
			System.out.print(myHeap.deleteMin() + " ");
		}
		System.out.println();
	}


}
