import java.io.*;
import java.util.*;

public class HTDriver{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);

		System.out.println("What is the name of the input file? ");

		String inputName = input.nextLine();
		Scanner inputScan = new Scanner(new File(inputName));

		int collectionSize = inputScan.nextInt();
		inputScan.nextLine();

		HashTable hash = new HashTable(collectionSize);

		String[] student_data;
		Long stud_id;
		String stud_name;
		int counter = 0;


		while(counter < collectionSize){
			student_data = inputScan.nextLine().split("\\s+");

			if (student_data.length != 2){
				counter++;
				continue;
			}

			try {
				stud_id = Long.parseLong(student_data[0]);
				stud_name = student_data[1];

				if (stud_id <= 0) {
					counter++;
					continue;
				}
			} catch (NumberFormatException e) {
				counter++;
				continue;
			}



			hash.insert(new Student(stud_id, stud_name));
			counter++;
		}


		//============================================================
		// End hash table student entries
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

		String answer;
		boolean cont = true;

		while(cont) {
			System.out.println("Enter a Menu Choice: (a,d,f,n,e,k,p,o,q)");
			answer = input.nextLine();
			switch (answer){
				case "a": 
					System.out.println("Input a student to be added: (Two Values: StudentID LastName)");

					if (input.hasNext()) {
						student_data = input.nextLine()

												
					} else {
						System.out.println("Invalid Value.");
					}
					System.out.println(ins + " added");
					input.nextLine();
					break;

				case "d":
					System.out.println("Input a value to deleted: ");

					int del = input.nextInt();
					hash.delete(del);
					System.out.println(del + " deleted");
					input.nextLine();
					break;

				case "k":
					hash.makeEmpty();
					System.out.println("Hash table made empty.");
					break;

				case "s":
					System.out.println(hash.size() + " is the size of the hash table.");
					break;

				case "o":
					Iterator<Integer> iter = hash.iterator();
					while(iter.hasNext()){
						System.out.print(iter.next() + " ");
					}
					System.out.println();
					break;

				case "f":
					System.out.println("Input a value to be found: ");

					int fin = input.nextInt();
					if(hash.find(fin)){
						System.out.println(fin + " found");
					}else{
						System.out.println(fin + " not found");
					}	
					input.nextLine();									
					break;

				case "e":
					if(hash.isEmpty()){
						System.out.println("Empty.");
					} else {
						System.out.println("Not Empty.");				
					}
					break;

				case "p":
					hash.print();
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

	private boolean validStudent(String[] stud){
		
	}
}