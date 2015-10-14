import java.util.*;
import java.io.*;

public class TreeTest {
	public static void main(String args[]){
		int arrsize = 20;
		Integer[] arr = new Integer[arrsize];
		int vals = 0;
		Scanner input = new Scanner(System.in);

		// arr[vals] = input.nextInt();
		// vals++;

		while(vals < arrsize && input.hasNextInt()){		
			arr[vals] = input.nextInt();
			vals++;
		}

		System.out.println("Heaptest: " + TreeWork.isHeap(arr,vals));
		System.out.println();
		TreeWork.printTree(arr,vals);
	
	}
}