import java.util.*;
import java.io.*;

public class DictionaryMaker{
	public static void main(String args[]){
		
		// try catch to check if in and out file are real files so the program doesn't crash?

		Scanner input = new Scanner(System.in);

		System.out.println("What's the name of the input file? : ");
		String fileIn = input.nextLine();

		System.out.println("What's the name of the output file? : ");
		String fileOut = input.nextLine(); 

		BST<String> bst = new BST<String>();

		while(input.hasNextLine()){

			String word = input.next();

			if(bst.find(word) == false){
				bst.insert(word);
			}

		}

		inIter inIt = new bst.iteratorIn();	

		while () { // while the iterator traverses the tree, write each element onto a new line in the output file
			fileOut.write();
		}

	}	
}