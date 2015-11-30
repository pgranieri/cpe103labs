public class Sorts{

	public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size){
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
		T temp;
		int j;
		for(int i =1; i < size; i++){
			temp = arr[i];
			j = i;

			while(j!=0 && arr[j-1].compareTo(temp)){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size){
		mergeSort(arr, 0, size-1);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] arr, int first, int last){
		int middle;

		if (first<last){
			middle = (first + last)/2;
			mergeSort(arr, first, middle);
			mergeSort(arr, middle+1, last);
			mergeSortedHalves(arr, first, middle, last);
		}
	}

	private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right){
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
			for (index1; index1<middle+1; index1++){
				temp[index] = arr[index1];
				index++;
			}
		} else {
			for (index2; index2<right+1; index2++){
				temp[index] = arr[index2];
				index++;
			}
		}

		for (int i = 0; i < temp.length; i++){
			arr[left + i] = temp[i]; //might need to adjust by one
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size){
		
	}
}