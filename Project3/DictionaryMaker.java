//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.io.*;
import java.lang.*;

public class DictionaryMaker{
	//class that searches through an input file, sorts it alphabetically, and then writes it to an output file. 
	public static void main(String args[]){
		//Main method used to sort the input alphabetically and write it.

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

		while (inIt.hasNext()){
			
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