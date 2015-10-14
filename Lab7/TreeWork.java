import java.lang.Math;

public class TreeWork{
	public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int N){
		for(int i = 0; i < N; i++ ){
			if(2 *i + 1 < N){ // left-child
				if(arr[i].compareTo(arr[2*i+1]) > 0){
					return false;
				}
				if(2*i+2 < N){ // right-child
					if(arr[i].compareTo(arr[2*i + 2]) > 0){
						return false;
					}				
				}
			}
		}
		return true;
	}


	public static <T> void printTree(T[] arr, int N){
		if (N == 0){
			System.out.println("The tree is empty.");
			return;
		}

		int count = 0;
		int max_height = (int) Math.floor(Math.log(N)/Math.log(2));
		for (int l = 0; l <= max_height; l++){
			if (l < max_height){	
				for (int i = 0; i < Math.pow(2,l); i ++) {
					System.out.print(arr[count + i] + " ");
				}
			} else {
				while(count < N){
					System.out.print(arr[count] + " ");
					count ++;
				}
			}
			System.out.println();
			count += Math.pow(2,l);
		}
	}
	
}