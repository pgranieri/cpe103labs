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
		
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] arr, int first, int last){
		
	}


}