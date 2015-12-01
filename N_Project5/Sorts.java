public class Sorts{

    ////////////
	// O(N^2) below
	////////////

	public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size){
		for(int i = 0; i < size; i++){
			int minIndex = i;
			for(int j = 0; j < i+1 ; j++){
				if(arr[j].compareTo(arr[minIndex]) < 0){
					minIndex = j;
				}
			}
			T min = arr[minIndex];
			T ith = arr[i];
			arr[i] = min;
			arr[minIndex] = ith;			
		}
	}	



	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size){
		boolean done = false;
		while(!done){
			done = true;
			for(int i = 0; i < size ; i++){
				if(arr[i] > arr[i+1]){
					T iplus = arr[i+1];
					T ireg = arr[i];
					arr[i] = iplus;
					arr[i+1] = ireg;
					// ^^ has to be a more effecient way of doing this
					done = false; 
				}
			}
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size){ // still needs work
		for(int i = 0; i < size; i++){
			T temp = arr[i];
			int j = i;
			while(j != i+1 && arr[j-1] > temp){ // j != leftmost? 
				T jminus = arr[j-1];
				T jreg = arr[j];
				arr[j] = jminus;
				arr[j-1] = jreg;
				j--;
			}
			arr[j] = temp;
		}
	}

	/////////////
	// O(LogN) below
	/////////////

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size){
		mergeSort(arr,0,size-1);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last){
		int middle;
		if(first<last){
			middle = (first + last)/2;
			mergeSort(arr,first,middle);
			mergeSort(arr,middle+1,last);
			mergeSortedHalves(arr,first,middle,last);
		}
	}

	private static void mergeSortedHalves(T[] arr, int left, int middle, int right){
		T[] temp = new T[right-left+1]; // place holder for sorted array
		int indexL = left;
		int indexM = middle+1;
		int index = 0;
		while(left < middle && middle+1 < right){ // how do you check both halves?  arr.length > 0 && temp.length > 0
			if(arr[indexL] < arr[indexM]){
				temp[index] = arr[indexL];
				indexL++;
			}else{
				temp[index] = arr[indexM];
				indexM++;
			}
			index++;
		}
		if(left<middle){ // think below is incorrect
			for(indexL; indexL < indexM; indexL++){
				temp[index] = arr[indexL];
				index++;
			}
		}else{ // the indexs may be incorrect
			for(indexM; indexM < right; indexM++){
				temp[index] = arr[indexM];
				index++;
			}
		}
		for(int i = 0; i <= temp.length-1; i++){ // temp[0..temp.length-1] .. arr[left..right] should fill the array, cant lose any elements
			temp[i] = arr[i];
		}
	}



	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size){
		quickSort(arr,0,size-1);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] arr, int first, int last){
		if(first<last){
			setPivotToEnd(arr,first,last);
			int pivotIndex = splitList(arr,first,last);
			quickSort(arr,first,pivotIndex-1);
			quickSort(arr,pivotIndex+1,last);

		}
	}

	private static void setPivotToEnd(T[] arr, int left, int right){
		int center = (left + right)/2;

		if(arr[center] < arr[left]){
			T temp1 = arr[center];
			T temp2 = arr[left];
			arr[center] = temp2;
			arr[left] = temp1;
		}

		if(arr[right] < arr[left]){
			T temp3 = arr[right];
			T temp4 = arr[left];
			arr[right] = temp4;
			arr[left] = temp3;
		}

		if(arr[center] < arr[right]){
			T temp5 = arr[center];
			T temp6 = arr[right];
			arr[center] = temp6;
			arr[left] = temp5;
		}
	}

	private static int splitList(int[] arr, int left, int right){
		int indexL = left;
		int indexR = right-1;
		T pivot = arr[right];

		while(indexL < indexR){

			while(arr[indexL].compareTo(pivot) < 0){
				indexL++;
			}

			while(indexl < indexR && arr[indexR].compareTo(pivot) > 0){
				indexR--;
			}

			if(indexL < indexR){
				T temp1 = arr[indexR];
				T temp2 = arr[indexL];
				arr[indexR] = temp2;
				arr[indexL] = temp1;	
				indexL++;
				indexR--;	
			}
		}
		T temp3 = arr[indexL];
		T temp4 = arr[right];
		arr[indexL] = temp4;
		arr[right] = temp3;
		return indexL; // the new pivot being returned
	}


}