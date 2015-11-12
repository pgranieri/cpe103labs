import java.io.*;
import java.lang.*;
import java.util.*;

public class HTDriver{
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);


		System.out.println("what is the input file's name?: ");
		File infile;
		Scanner filereader;

		try{
			infile = new File(input.nextLine());			
		}catch(FileNotFoundException fnfe){
			
		}

		filereader = new Scanner(infile);
		int size = filereader.nextInt();
		filereader.nextLine();

		HashTable hash = new HashTable(size);

		String[] line;
		long id;
		String name;


		for(int i = 0; i < size; i++){
			line = filereader.nextLine().split(" ");
			if(line.length == 2){
				try{
					if(Long.parseLong(line[0]) <= 0){
						id = Long.parseLong(line[0]);
						name = line[1];
						hash.insert(new Student(id,name));
					}
					
				}catch( NumberFormatException e){
				
				}
				
			}			
		}


		//================================================
		// "PatsWork" below
		// ===============================================

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
					
					String[] student_data;
					String stud_line;
					Student astud;

					if (input.hasNext()) {
						stud_line = input.nextLine();
						student_data = stud_line.split(" ");

						if(student_data.length == 2){

							try{
								if(Long.parseLong(student_data[0]) <= 0){
									id = Long.parseLong(student_data[0]);
									name = student_data[1];
									astud = new Student(id,name);
									hash.insert(astud);	
								}									

							}catch(NumberFormatException e){}				
						}

					} else {
						System.out.println("Invalid Value.");
					}
					System.out.println( astud.toString() + " was added to the table");
					input.nextLine();
					break;

				case "d":
					System.out.println("Input a value to deleted: ");

					Long delkey = input.nextLong();
										
					if(delkey >= 0){
						Student dummy = new Student(delkey,"nonsense");
						hash.delete(dummy);
						System.out.println("we have deleted the student");
					}else{
						System.out.println("student not found");
					}	
					input.nextLine();							
					break;

				case "k":
					hash.makeEmpty();
					System.out.println("Hash table made empty.");
					break;

				case "o":
					Iterator<Integer> iter = hash.iterator();
					while(iter.hasNext()){
						System.out.print(iter.next() + " ");
					}
					System.out.println();
					break;

				case "f":
					System.out.println("Input a id to be found: ");

					long key = input.nextInt();
					Student dummy = new Student(key,"nonsense");
					Object stud;
					if(hash.find(dummy) != null){
						stud = (Student) hash.find(dummy);
						System.out.println("we have found the student: " + stud.toString());
					}else{
						System.out.println("not found");
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
					hash.printTable();
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