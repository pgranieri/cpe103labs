//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 5,  12/2/2015

import java.util.*;

public class SortTimes3{
	//A class that prints the sort times of a randomy sorted list
	public static void main(String args[]){
		//method that runs the progam
		Integer[] list1 = new Integer[80000];
		Integer[] list2 = new Integer[80000];
		Integer[] list3 = new Integer[80000];
		Integer[] list4 = new Integer[80000];
		Integer[] list5 = new Integer[80000];
		long startTime, endTime;
		long ssTime, bsTime, isTime, msTime, qsTime;

		Random r = new Random();

		System.out.println("TEST3: unsorted list");
		int n = 5000;

		while(n <= 80000){
			for (int z = 0; z < 3; z++){
				for(int i = 0; i < n; i++){
					list1[i] = r.nextInt(n-1);
					list2[i] = list1[i];
					list3[i] = list1[i];
					list4[i] = list1[i];
					list5[i] = list1[i];
				}

				startTime = System.nanoTime();
				Sorts.selectionSort(list1, n);
				endTime = System.nanoTime();
				ssTime = (endTime - startTime)/1000000;

				startTime = System.nanoTime();
				Sorts.bubbleSort(list2, n);
				endTime = System.nanoTime();
				bsTime = (endTime - startTime)/1000000;

				startTime = System.nanoTime();
				Sorts.insertionSort(list3, n);
				endTime = System.nanoTime();
				isTime = (endTime - startTime)/1000000;

				startTime = System.nanoTime();
				Sorts.mergeSort(list4, n);
				endTime = System.nanoTime();
				msTime = (endTime - startTime)/1000000;

				startTime = System.nanoTime();
				Sorts.quickSort(list5, n);
				endTime = System.nanoTime();
				qsTime = (endTime - startTime)/1000000;

				System.out.println("N=" + n + ": T_ss=" + ssTime + ", T_bs=" + bsTime + ", T_is=" + isTime + ", T_ms=" + msTime + ", T_qs=" + qsTime);

			}
			System.out.println();
			n=n*2;
		}

		System.out.println("END TEST3");
	}	
}