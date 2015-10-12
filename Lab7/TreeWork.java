import java.lang.Math;

public class TreeWork{
	public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N){
		for(int i = 0; i < N; i++ ){
			if(2 *i + 1 < N){ // left-child
				if(arr[i].compareTo(arr[2*i+1]) <= 0 ){
					return false;
				}
				if(2*i+2 < N){ // right-child
					if(arr[i].compareTo(arr[2*i + 2]) <= 0){
						return false;
					}				
				}
			}
		}
		return true;
	}


	public static <T> void printTree(T[] arr, int N){
		int count = 0;

		for (int l = 0; l <= Math.floor(Math.log(N)/Math.log(2)); l++){
			for (int i = 1; i <= Math.pow(2,l); i ++) {
				System.out.print(arr[count + i] + " ");
			}
			System.out.println();
			count += Math.pow(2,l);
		}
	}
	
}