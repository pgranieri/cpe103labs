import java.util.*;
import java.io.*;
public class BSTDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		BST<Integer> bst = new BST<Integer>();

		System.out.println("Choose one of the following operations: )");
		System.out.println(" a- Add the element ");
		System.out.println(" d-	Delete the element ");
		System.out.println(" f-	Find the element ");
		System.out.println(" e-	Check if the tree is empty ");
		System.out.println(" k-	Make the tree empty ");
		System.out.println(" n-	Get the number of nodes in the tree (size) ");
		System.out.println(" m-	Find the minimal element ");
		System.out.println(" x-	Find the maximal element ");
		System.out.println(" p-	Print the tree in Pre-order using iterator ");
		System.out.println(" i-	Print the tree in In-order using iterator ");
		System.out.println(" l-	Print the tree in Level-order using iterator");
		System.out.println(" t-	Print the tree using printTree ");
		System.out.println(" o-	Output the tree using toString ");
		System.out.println(" q-	Quit the Program");

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,f,e,k,n,m,x,p,i,l,t,o,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a value to be added: ");

					if (input.hasNextInt()) {
						int in = input.nextInt();
						bst.insert(in);
						System.out.println(in + " inserted");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;
				case "d":
					try{
						System.out.println(bst.delete() + " deleted");
					} catch (bst.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;
				case "f":
					try{
						System.out.println(bst.find() + " found");
					} catch (bst.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;
				case "e":
					if(bst.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;
				case "k":
					bst.makeEmpty();
					break;
				case "n":
					try{
						System.out.println(bst.size() + " is the number of nodes");
					} catch (bst.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;
				case "m":
					try{
						System.out.println(bst.findMinimum() + " is the min");
					} catch (bst.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;
				case "x":
					try{
						System.out.println(bst.findMaximum() + " is the max");
					} catch (bst.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;
				case "p":
					break;
				case "i":
					break;
				case "l":
					break;
				case "t":
					bst.printTree();
					System.out.println();
					break;
				case "o":
					System.out.println(bst.toString());
					break;
				case "q":
					cont = false;
					System.out.println("Quitting.");
					break;
				default:
					System.out.println("Invalid Choice.");
					break;
			}
		}
	}
}