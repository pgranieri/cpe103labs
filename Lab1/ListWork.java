//Patrick Granieri and Nick Gatehouse

import java.util.*;
import java.lang.*;

public class ListWork
{
	public static <T> boolean search(T [] arr, T target) {
		boolean result = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				result = true;
			}
		}
		return result;
	}

	public static <T> void print(T [] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
		}
	}

	public static void main(String[] args) {
		

		Scanner user_input = new Scanner(System.in);

		Integer[] userints = new Integer[10];
	

		for (int k = 0; k < userints.length; k++) {
			
			try {
				userints[k] = user_input.nextInt();
			}
			catch (InputMismatchException e){
				k--;
				user_input.next();
			}
		}
		user_input.nextLine();



		boolean keepgoing = true;
		String answer;
        while (keepgoing){		

			System.out.println("Search for a term? y:n");
	        
        	answer = user_input.next();  

			if(answer.equals("y"))
			{
				try{

					System.out.println(search(userints,user_input.nextInt()));
				}
				catch(InputMismatchException e){
					System.out.println("invalid value");
					user_input.next();
				}
			   
			}
			else if(answer.equals("n"))
			{
				keepgoing = false;
                print(userints);  
			} 
			else{
				System.out.println("yes...or no...");
			}  

		}
			
	}
	
}
