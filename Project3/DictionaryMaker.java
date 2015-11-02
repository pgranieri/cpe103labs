//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.io.*;
import java.lang.*;

public class DictionaryMaker{
	public static void main(String args[]){
		
		// try catch to check if in and out file are real files so the program doesn't crash?

		Scanner input = new Scanner(System.in);

		System.out.println("What's the name of the input file? ");
		String fileIn = input.nextLine();
		Scanner fileReader;
		try{
			fileReader = new Scanner(new File(fileIn));	
		} catch (FileNotFoundException e) {
			System.out.println("Oops.");
			return;
		} 
		
		System.out.println("What's the name of the output file? ");
		String fileOut = input.nextLine();
		FileWriter outputFile;
		try{
			outputFile = new FileWriter(new File(fileOut));
		} catch (IOException e) {
			System.out.println("Whoops.");
			return;
		} 

		BST<String> bst = new BST<String>();


		String word;

		while(fileReader.hasNext()){
			word = fileReader.next();

			if(!bst.find(word)){
				bst.insert(word);
			}

		}

		Iterator<String> inIt = bst.iteratorIn();	

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