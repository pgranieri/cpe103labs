//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.io.*;

public class BSTDriver{
	//Class used for testing the BST structure we created.

	public static void main(String args[]){
		//main method used to test the BST structure. 

		Scanner input = new Scanner(System.in);
		BST<Integer> bst = new BST<Integer>();

		System.out.println("Choose one of the following operations: ");
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
					System.out.println("Input a value to be deleted: ");

					if (input.hasNextInt()) {
						int del = input.nextInt();
						bst.delete(del);
						System.out.println(del + " deleted");						
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
					break;

				case "f":
					System.out.println("Input a value to be found: ");

					if (input.hasNextInt()) {
						int fin = input.nextInt();
						if(bst.find(fin)){
							System.out.println("found " + fin);
						}else{
							System.out.println( fin + " is not within the tree :(");
						}
												
					} else {
						System.out.println("Invalid Value.");
					}
					input.nextLine();
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
					System.out.println("the tree was emptied");
					break;

				case "n":
					System.out.println(bst.size() + " is the number of nodes");			
					break;

				case "m":
					try{
						System.out.println(bst.findMinimum() + " is the minimum");
					} catch (BST.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}															
					break;

				case "x":
					try{
						System.out.println(bst.findMaximum() + " is the max");
					} catch (BST.MyException e){
						System.out.println("Invalid Operation: The BST is empty.");
					}
					break;

				case "p":
					Iterator<Integer> preIter = bst.iteratorPre();
					while (preIter.hasNext()){
						System.out.print(preIter.next() + " ");
					}
					System.out.println();
					break;

				case "i":
					Iterator<Integer> inIter = bst.iteratorIn();
					while(inIter.hasNext()){
						System.out.print(inIter.next() + " ");
					}
					System.out.println();
					break;

				case "l":
					Iterator<Integer> levIter = bst.iteratorLevel();
					while(levIter.hasNext()){
						System.out.print(levIter.next() + " ");
					}
					System.out.println();

					break;

				case "t":
					bst.printTree();
					System.out.println();
					break;

				case "o":
					System.out.println(bst);
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
