import java.util.*;

public class Separator {
	public static void endgame(int[] intarr,float[] floatarr, int int_counter, int float_counter) {
		System.out.print("Integers: ");
		for(int i = 0; i < int_counter; i++){
			System.out.print(intarr[i] + " ");
		}
		System.out.println();
		
		System.out.print("Floats: ");
		for(int i = 0; i < float_counter; i++){
			System.out.print(floatarr[i] + " ");
		}
		System.out.println();
	}
	public static void main (String args[]){
		int n = 5;
		int int_counter = 0;
		int float_counter = 0;
		Scanner user_input = new Scanner(System.in);
        float[] floatarr = new float[n];
        int[]  intarr = new int[n];
        System.out.println("Input?");


		while (user_input.hasNext() && int_counter < n+1 && float_counter < n+1){

			if(user_input.hasNextInt() )
			{
				if(int_counter == 5){
					break; //endgame(intarr, floatarr, int_counter, float_counter);
				}
				intarr[int_counter] = user_input.nextInt();
                int_counter++;
			}
			else if(user_input.hasNextFloat() )
			{
				if(float_counter == 5){
					break;//endgame(intarr, floatarr, int_counter, float_counter);
				}
				floatarr[float_counter] = user_input.nextFloat();
                float_counter++;
			}
			else
			{
				endgame(intarr, floatarr, int_counter, float_counter);
				break;
			}
		}
		if(user_input.hasNext() == false || int_counter== n || float_counter == n){
			endgame(intarr, floatarr, int_counter, float_counter);
		}	
	}
}