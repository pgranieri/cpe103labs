public class SortTimes1{
	public static void main(String[] args){
		int[] arrSS = new int[80000];
		int[] arrBS = new int[80000];
		int[] arrIS = new int[80000];
		int[] arrMS = new int[80000];
		int[] arrQS = new int[80000];
		long N = 5000;
		long startTime, endTimeS, endTimeB, endTimeI;
		long endTimeM, endTimeQ; 

		System.out.println("TEST1: presorted list");

		while(N <= 80000){

			for(int i = 0; i <= N-1; i++){ // should be a faster way to do this
				arrSS[i] = i;
				arrBS[i] = i;
				arrIS[i] = i;
				arrMS[i] = i;
				arrQS[i] = i;
			}

			startTime = System.nanoTime();
			Sorts.selectionSort(arrSS,N);
			endTimeS = System.nanoTime();
			
			startTime = System.nanoTime();
			Sorts.bubbleSort(arrBS,N);
			endTimeB = System.nanoTime();

			startTime = System.nanoTime();
			Sorts.insertionSort(arrIS,N);
			endTimeI = System.nanoTime();

			startTime = System.nanoTime();
			Sorts.mergeSort(arrMS,N);
			endTimeM = System.nanoTime();

			startTime = System.nanoTime();
			Sorts.quickSort(arrQS,N);
			endTimeQ = System.nanoTime();

			System.out.println("N= " + N + ": T_ss= " + endTimeS + ", T_bs= " + endTimeB + ", T_is= " + endTimeI + ", T_ms= " + endTimeM + ", T_qs= " + endTimeQ);

			N = N*2;
		}

		System.out.println("END TEST1");

	}
}