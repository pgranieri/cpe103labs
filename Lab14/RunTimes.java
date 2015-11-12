public class RunTimes{
	public static void main(String args[]){
		System.out.println("Logorithmic algorithm's running times: ");
		
		long N = 10000;
		long startTime, endTime;

		while (N < 100000000) {
			startTime = System.nanoTime();
			Algorithms.logarithmicAlgorithm(N);
			endTime = System.nanoTime();
			System.out.println("T(" + N + ") = " + (endTime - startTime)/1000000);
			N = N*2;
		}

		System.out.println();

		System.out.println("Linear algorithm's running times: ");

		N = 10000;
		while (N < 100000000) {
			startTime = System.nanoTime();
			Algorithms.linearAlgorithm(N);
			endTime = System.nanoTime();
			System.out.println("T(" + N + ") = " + (endTime - startTime)/1000000);
			N = N*2;
		}

		System.out.println();
		System.out.println("NlogN algotithm's running times: ");

		N = 10000;
		while (N < 100000000) {
			startTime = System.nanoTime();
			Algorithms.NlogNAlgorithm(N);
			endTime = System.nanoTime();
			System.out.println("T(" + N + ") = " + (endTime - startTime)/1000000);
			N = N*2;
		}

		System.out.println();
		System.out.println("Quadratic algotithm's running times: ");

		N = 10000;
		while (N < 800000) {
			startTime = System.nanoTime();
			Algorithms.quadraticAlgorithm(N);
			endTime = System.nanoTime();
			System.out.println("T(" + N + ") = " + (endTime - startTime)/1000000);
			N = N*2;
		}
	}
}