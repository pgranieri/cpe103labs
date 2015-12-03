//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 5,  12/2/2015

import java.util.*;

public class DriverSorts{
	public static void main(String args[]){
		Integer[] list1 = new Integer[20];
		Integer[] list2 = new Integer[20];
		Integer[] list3 = new Integer[20];
		Integer[] list4 = new Integer[20];
		Integer[] list5 = new Integer[20];
		Random r = new Random();


		System.out.println("Original List: ");
		for(int i = 0; i < 20; i++){
			list1[i] = r.nextInt(100);
			list2[i] = list1[i];
			list3[i] = list1[i];
			list4[i] = list1[i];
			list5[i] = list1[i];

			System.out.print(list1[i] + " ");
		}
		System.out.println();

		System.out.println("Selection Sort: ");
		Sorts.selectionSort(list1, 20);
		printArray(list1);

		System.out.println("Bubble Sort: ");
		Sorts.bubbleSort(list2, 20);
		printArray(list2);

		System.out.println("Insertion Sort: ");
		Sorts.insertionSort(list3, 20);
		printArray(list3);

		System.out.println("Merge Sort: ");
		Sorts.mergeSort(list4, 20);
		printArray(list4);

		System.out.println("Quick Sort: ");
		Sorts.quickSort(list5, 20);
		printArray(list5);		


	}

	private static void printArray(Integer[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}