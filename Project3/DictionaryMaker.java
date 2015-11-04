//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.io.*;
import java.lang.*;

public class DictionaryMaker{ // class that reads a file and outputs its contents onto an output file in lexigraphical order

	public static void main(String args[]){ // main method to run the program
		

		Scanner input = new Scanner(System.in); // creates a scanner to obtain file names

		System.out.println("What's the name of the input file? ");
		String fileIn = input.nextLine(); // obtains the name of the in file
		Scanner fileReader;
		try{
			fileReader = new Scanner(new File(fileIn));	
		} catch (FileNotFoundException e) {
			System.out.println("Oops.");
			return;
		} 
		
		System.out.println("What's the name of the output file? ");
		String fileOut = input.nextLine(); // obtains the name of the out file
		FileWriter outputFile;
		try{
			outputFile = new FileWriter(new File(fileOut)); 
		} catch (IOException e) {
			System.out.println("Whoops.");
			return;
		} 

		BST<String> bst = new BST<String>(); // creates an instance of bst


		String word; // variable for the word

		while(fileReader.hasNext()){
			word = fileReader.next();

			if(!bst.find(word)){
				bst.insert(word);
			}

		}

		Iterator<String> inIt = bst.iteratorIn();	// creates iterator to search tree

		while (inIt.hasNext()) { // while the iterator traverses the tree, write each element onto a new line in the output file
			
			try{
				outputFile.write(inIt.next() + "\n");
			} catch (IOException e) {
				System.out.println("Could not write to file.");
			}
		}

		try{
			outputFile.close();
		} catch (IOException e) {
			System.out.println("Could not close file.");
		}
	}	
}