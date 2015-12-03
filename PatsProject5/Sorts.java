//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 5,  12/2/2015


public class Sorts{
	//Class that holds five different sorting algorithms

	public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size){
		//Method that sorts an array using the selection sort algorithm.
		int minIndex;
		for (int i = 0; i < size-1; i++){
			minIndex = i;

			for(int j = i+1; j < size; j++){
				if (arr[j].compareTo(arr[minIndex]) < 0){
					minIndex = j;
				}
			}

			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size){
		//Method that sorts an array using the bubble sort algorithm.
		boolean done = false;
		T temp;
		while(!done){
			done = true;
			for (int i = 0; i < size - 1; i++){
				if (arr[i].compareTo(arr[i+1]) > 0){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;	
					done = false;
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size){
		//Method that sorts an array using the insertion sort algorithm.
		T temp;
		int j;
		for(int i = 1; i < size; i++){
			temp = arr[i];
			j = i;

			while(j!=0 && arr[j-1].compareTo(temp)>0){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size){
		//Method that sorts an array using the merge sort algorithm.
		mergeSort(arr, 0, size-1);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last){
		//Recursively called helper method for the merge sort algorithm. 
		int middle;

		if (first<last){
			middle = (first + last)/2;
			mergeSort(arr, first, middle);
			mergeSort(arr, middle+1, last);
			mergeSortedHalves(arr, first, middle, last);
		}
	}

	private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right){
		//Sorts the two halves of an array for helping the merge sort algortithms. 
		T[] temp = (T[]) new Comparable[right-left+1];
		int index1 = left;
		int index2 = middle+1;
		int index = 0;

		while(middle + 1 > index1 && right + 1 > index2){
			if(arr[index1].compareTo(arr[index2]) < 0){
				temp[index] = arr[index1];
				index1++;
			} else {
				temp[index] = arr[index2];
				index2++;				
			}
			index++;
		}

		if(middle+1 > index1){
			for (; index1<middle+1; index1++){
				temp[index] = arr[index1];
				index++;
			}
		} else {
			for (; index2<right+1; index2++){
				temp[index] = arr[index2];
				index++;
			}
		}

		for (int i = 0; i < temp.length; i++){
			arr[left + i] = temp[i]; 
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size){
		//Method that sorts an array using the quick sort algorithm.
		quickSort(arr, 0, size - 1);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] arr, int first, int last){
		//Recursively called helper method for the quick sort algorithm .
		if (first<last) {
			setPivotToEnd(arr, first, last);
			int pivotIndex = splitList(arr, first, last);
			quickSort(arr, first, pivotIndex -1);
			quickSort(arr, pivotIndex+1, last);
		}
	}

	private static <T extends Comparable<? super T>> void setPivotToEnd(T[] arr, int left, int right){
		//Sets the pivot used in quick sort to the right side. 
		int center = (left + right)/2;
		T temp;
		if (arr[center].compareTo(arr[left]) < 0){
			temp = arr[center];
			arr[center] = arr[left];
			arr[left] = temp;
		}
		if (arr[right].compareTo(arr[left]) < 0){
			temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
		}
		if (arr[center].compareTo(arr[right]) < 0){
			temp = arr[center];
			arr[center] = arr[right];
			arr[right] = temp;
		}
	}

	private static <T extends Comparable<? super T>> int splitList (T[] arr, int left, int right) {
		//Helps to sort the array during the quick sort recursive calls. 
		int indexL = left;
		int indexR = right -1;
		T pivot = arr[right];
		T temp;

		while(indexR>=indexL){
			while(arr[indexL].compareTo(pivot) < 0){
				indexL++;
			}
			while(indexR>=indexL && arr[indexR].compareTo(pivot) > 0){
				indexR--;
			}
			if(indexR>=indexL){
				temp = arr[indexL];
				arr[indexL] = arr[indexR];
				arr[indexR] = temp;

				indexL++;
				indexR--;
			}
		}

		temp = arr[indexL];
		arr[indexL] = arr[right];
		arr[right] = temp;
		return indexL;
	}
}