import java.util.*;
import java.io.*;

public class TreeTest {
	public static void main(String args[]){
		int arrsize = 20;
		Integer[] arr = new Integer[arrsize];
		int vals = 0;
		Scanner input = new Scanner(System.in);

		while(vals < arrsize && input.hasNext()){
			System.out.print("input: ");
			
			arr[vals] = input.nextInt();
			vals++;
		}

		if(vals == 0){
			System.out.print("the tree is empty");
		}else{
			System.out.println("Heaptest: " + TreeWork.isHeap(arr,vals));
			System.out.println();
			TreeWork.printTree(arr,vals);
		}
		
	}
}