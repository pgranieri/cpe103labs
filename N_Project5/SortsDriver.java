import java.util.*;
import java.io.*;
import java.util.*;

public class SortsDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		

		System.out.println("Choose one of the following sorting algorithms: )");
		System.out.println("-	selectionSort (Enter the letter 'ss')");
		System.out.println("-	bubbleSort (enter the letter 'bs')");
		System.out.println("-	insertionSort (Enter the letter 'is')");
		System.out.println("-	mergeSort (Enter the letter 'ms')");
		System.out.println("-	quickSort (Enter the letter 'qs')");
		System.out.println("-	quit (enter the letter 'q')");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (ss,bs,is,ms,qs,q)");
			answer = input.nextLine();
			switch (answer){

				case"ss":
				 	int[] arr = new int[5];
		        	arr[0] = 4;
					arr[1] = 3;
					arr[2] = 1;
					arr[3] = 5;
					arr[4] = 2;
					Sorts.selectionSort(arr,5);
					for(int i = 0; i < arr.length; i++){
						System.out.print(arr[i] + " ");
					}
					break;

				case"bs":
					int[] arr = new int[5];
		        	arr[0] = 4;
					arr[1] = 3;
					arr[2] = 1;
					arr[3] = 5;
					arr[4] = 2;
					Sorts.bubbleSort(arr,5);
					for(int i = 0; i < arr.length; i++){
						System.out.print(arr[i] + " ");
					}
					break;

				case"is":
					int[] arr = new int[5];
		        	arr[0] = 4;
					arr[1] = 3;
					arr[2] = 1;
					arr[3] = 5;
					arr[4] = 2;
					Sorts.insertionSort(arr,5);
					for(int i = 0; i < arr.length; i++){
						System.out.print(arr[i] + " ");
					}
					break;

				case"ms":
					int[] arr = new int[5];
		        	arr[0] = 4;
					arr[1] = 3;
					arr[2] = 1;
					arr[3] = 5;
					arr[4] = 2;
					Sorts.mergeSort(arr,5);
					for(int i = 0; i < arr.length; i++){
						System.out.print(arr[i] + " ");
					}
					break;

				case"qs":
					int[] arr = new int[5];
		        	arr[0] = 4;
					arr[1] = 3;
					arr[2] = 1;
					arr[3] = 5;
					arr[4] = 2;
					Sorts.quickSort(arr,5);
					for(int i = 0; i < arr.length; i++){
						System.out.print(arr[i] + " ");
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
	}
}