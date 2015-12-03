//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 5,  12/2/2015

public class SortTimes2{
	//A class that prints the sort times of a reverse sorted list
	public static void main(String args[]){
		//the method that runs the program
		Integer[] list1 = new Integer[80000];
		Integer[] list2 = new Integer[80000];
		Integer[] list3 = new Integer[80000];
		Integer[] list4 = new Integer[80000];
		Integer[] list5 = new Integer[80000];
		long startTime, endTime;
		long ssTime, bsTime, isTime, msTime, qsTime;

		System.out.println("TEST2: reverse sorted list");
		int n = 5000;
		int index;
		while(n <= 80000){
			index = 0;
			for(int i = n-1; i >= 0; i--){
				list1[index] = i;
				list2[index] = i;
				list3[index] = i;
				list4[index] = i;
				list5[index] = i;
				index++;
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

			n=n*2;

		}

		System.out.println("END TEST2");
	}	
}