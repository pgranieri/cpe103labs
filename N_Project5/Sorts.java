public class Sorts{

    ////////////
	// O(N^2) below
	////////////

	public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size){
		for(int i = 0; i < size; i++){
			int minIndex = i;
			for(int j = 0; j < i+1 ; j++){
				if(arr[j].compareTo(arr[minIndex]) < 0{
					minIndex = j;
				}
			}
			T min = arr[minIndex];
			T ith = arr[i];
			arr[i] = min;
			arr[minIndex] = ith;
			// ^^ has to be a more effecient way of doing this
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

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size){
		for(int i = 0; i < size; i++){
			T temp = arr[i];
			int j = i;
			while(j && arr[j-1] > arr[i])
		}
	}

	/////////////
	// O(LogN) below
	/////////////

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size){
		
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size){
		
	}

}