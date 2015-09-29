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

		String answer = input.nextLine();

		switch (answer){
			case "a": 
				System.out.println("Input a value to be enqueued: ");

				input.next();

				if (input.hasNextInt()) {
					int nq = input.nextInt();
					q.enqueue(nq);

					System.out.println(nq + "enqueued");
				}
			case "d":
				input.nextLine();
				System.out.println(q.dequeue());
			case "e":
				input.nextline();
				q.isEmpty();
			case "q":

			default:

		}
	}
}