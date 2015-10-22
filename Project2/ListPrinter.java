import java.util.*;
import java.io.*;
import java.lang.*;

public class ListPrinter{
	public static void main(String args[]) throws FileNotFoundException {
		Scanner user_input = new Scanner(System.in);

		BinHeap<Student> binStud = new BinHeap<Student>();
		System.out.println("What file are the student records stored in? ");
		String answer = user_input.nextLine();

		File students = new File(answer);
		Scanner student_scan = new Scanner(students);

		String[] student_data;
		Long stud_id;
		String stud_name;

		//Need to make sure that the input is valid.
		//	1. ID is not a long (any int is a long)
		//	2. ID is not positive (0 or negative)
		//	3. ID or name are missing. (Number of values on the line is less than 2)
		//	4. There are additional values on the line (more than 2 values on the line)
		while(student_scan.hasNext()){
			student_data = student_scan.nextLine().split("\\s+");

			if (student_data.length != 2){
				System.out.println("Invalid Format.");
				continue;
			}

			try {
				stud_id = Long.parseLong(student_data[0]);
				stud_name = student_data[1];

				if (stud_id <= 0) {
					System.out.println("Long is not positive.");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Not a long.");
				continue;
			}



			binStud.insert(new Student(stud_id, stud_name));
		}



		//Print out the students in ascending order. 
		System.out.println("Student List:");

		for(int i = 1; !binStud.isEmpty(); i++){
			System.out.println(i + ". " + binStud.deleteMin());
		}
	}
}