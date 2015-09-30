import java.util.*;

public class LQueueDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		LQueue<Integer> q = new LQueue<Integer>();

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	enqueue/add (Enter the letter 'a')");
		System.out.println("-	dequeue/delete (Enter the letter 'd')");
		System.out.println("-	check if the list is empty (enter the letter 'e')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,e,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be enqueued: ");

					if (input.hasNextInt()) {
						int nq = input.nextInt();
						q.enqueue(nq);

						System.out.println(nq + " enqueued");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				case "d":
					try{
						System.out.println(q.dequeue() + " dequeued");
					} catch (LQueue.MyException e){
						System.out.println("Invalid Operation: The Queue is empty.");
					}
					break;
				case "e":
					if(q.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
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

		while (!q.isEmpty()){
			System.out.print(q.dequeue() + " ");
		}
		System.out.println();
	}
}