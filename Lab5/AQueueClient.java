import java.util.*;
import java.io.*;

public class AQueueClient{
	public static void main(String args[]){
		AQueue<Float> q = new AQueue<Float>(5);
		Scanner input = new Scanner(System.in);
		// String result = "";	

		while (input.hasNext()){
			if (input.hasNextFloat()){
				q.enqueue(input.nextFloat());
			} else {
				input.next();
			}
		}
		while(!q.isEmpty()){
			System.out.print(q.dequeue() + " ");
		}

		System.out.print("\n");
	}
}