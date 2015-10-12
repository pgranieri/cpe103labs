import java.util.*;
import java.io.*;
public class AQueueDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		AQueue<Integer> aq = new AQueue<Integer>(5);

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	enqueue/add (Enter the letter 'a')");
		System.out.println("-	dequeue/delete (Enter the letter 'd')");
		System.out.println("-	check if the list is empty (enter the letter 'e')");
		System.out.println("-	print array (enter the letter 'p')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,e,p,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be enqueued: ");

					if (input.hasNextInt()) {
						int nq = input.nextInt();
						aq.enqueue(nq);

						System.out.println(nq + " enqueued");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				case "d":
					try{
						System.out.println(aq.dequeue() + " dequeued");
					} catch (AQueue.MyException e){
						System.out.println("Invalid Operation: The Queue is empty.");
					}
					break;
				case "e":
					if(aq.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;
				case "p":
					aq.printArray();
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

		while (!aq.isEmpty()){
			System.out.print(aq.dequeue() + " ");
		}
		System.out.println();
	}
}