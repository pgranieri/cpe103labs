//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 4, 10/13/2015

import java.io.*;
import java.util.*;

public class HTDriver{ // driver created to test the HashTable
	public static void main(String args[]){ // main method to run the program
		Scanner input = new Scanner(System.in); // creates a scanner to read keyboard input

		System.out.println("What is the name of the input file? ");

		String inputName = input.nextLine(); // first arguement given by user which should be the input file
		Scanner inputScan; // scanner created to go through the input file
		try{
			inputScan = new Scanner(new File(inputName));
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
			return;
		}

		int collectionSize = inputScan.nextInt(); // size of the HashTable
		inputScan.nextLine();

		HashTable hash = new HashTable(collectionSize); // creates the Hashtable object

		String[] student_data; // each line of the input file should contain an id and a name
		Long stud_id; // the students id
		String stud_name; // the students name
		int counter = 0; // counts each line within the file that the driver has traversed


		while(counter < collectionSize){
			student_data = inputScan.nextLine().split("\\s+");


			if(isValidStudent(student_data)){
				stud_id = Long.parseLong(student_data[0]);
				stud_name = student_data[1];
				hash.insert(new Student(stud_id, stud_name));
				counter++;
			} else {
				counter++;
			}
		}


		//============================================================
		// End file student entries
		//============================================================

		System.out.println("Choose one of the following operations: )");
		System.out.println("-	a - add the element");
		System.out.println("-	d - delete the element");
		System.out.println("-	f - find and retreive the element");
		System.out.println("-	n - get the number of elements in the collection ");
		System.out.println("-	e - check if the collection is empty");
		System.out.println("-	k - make the hash table empty");
		System.out.println("-	p - print the collection of the hash table");
		System.out.println("-	o - output the elements of the collection");
		System.out.println("-	q - Quit the program");

		String answer; // variable for the letter input
		boolean cont = true; // variable to see if user quits program

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,f,n,e,k,p,o,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a student to be added: (Two Values: StudentID LastName)");

					student_data = input.nextLine().split("\\s+");
					if (isValidStudent(student_data)){

						stud_id = Long.parseLong(student_data[0]);
						stud_name = student_data[1];
						Student ins = new Student(stud_id,stud_name);
						hash.insert(ins);
						System.out.println(ins + " added.");

					} else {
						System.out.println("Invalid Student.");
					}
					break;

				case "d":
					System.out.println("Input the key of the student to be deleted: ");

					if(input.hasNextLong()){
						Long del_id = input.nextLong();

						if (del_id <= 0){
							System.out.println("Invalid Key");
						} else {
							Student del = new Student(del_id, "Dummy");
							hash.delete(del);
							System.out.println(del_id + " deleted.");
						}
					} else {
						System.out.println("Invalid Key.");
					}

					input.nextLine();
					break;

				case "f":
					System.out.println("Input the key of the student to be found: ");

					if(input.hasNextLong()){
						Long find_id = input.nextLong();

						if(find_id <= 0){
							System.out.println("Invalid Key.");
						} else {
							Student find = new Student(find_id, "Dummy");
							Student found = (Student) hash.find(find);

							if (found != null) {
								System.out.println("A student with that id was found: " + found);
							} else {
								System.out.println("No student with that id found.");
							}
						}
					} else {
						System.out.println("Invalid Key.");
					}

					input.nextLine();									
					break;

				case "n":
					System.out.println("There are " + hash.elementCount() + " elements in the collection.");
					break;

				case "e":
					if(hash.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;

				case "k":
					hash.makeEmpty();
					System.out.println("Hash table made empty.");
					break;

				case "p":
					hash.printTable();
					break;

				case "o":
					Iterator iter = hash.iterator();
					while(iter.hasNext()){
						System.out.println(iter.next());
					}
					System.out.println();
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

	private static boolean isValidStudent(String[] stud){
		if (stud.length !=2){
			return false;
		}
		try{
			Long student_num = Long.parseLong(stud[0]);

			if (student_num <= 0) {
				return false;
			}
		} catch (NumberFormatException e){
			return false;
		}

		return true;
	}
}