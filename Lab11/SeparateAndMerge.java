import java.util.*;
import java.io.*;

public class SeparateAndMerge{
	public static void main(String args[]){
		LList<Integer> listInt = new LList<Integer>();
		LList<Float> listFloat = new LList<Float>();

		Scanner user_input = new Scanner(System.in);

		while(user_input.hasNext()){
			if (user_input.hasNextInt()) {
				listInt.add(user_input.nextInt());
			} else if (user_input.hasNextFloat()) {
				listFloat.add(user_input.nextFloat());
			} else {
				user_input.next();
			}
		}

		Iterator itInt = listInt.iterator();
		Iterator itFloat = listFloat.iterator();

		System.out.print("Inputted Values: ");

		while(itInt.hasNext() || itFloat.hasNext()) {
			if (itInt.hasNext()) {
				System.out.print(itInt.next() + " ");
			}

			if (itFloat.hasNext()) {
				System.out.print(itFloat.next() + " ");
			}
		}
		System.out.println();
	}
}