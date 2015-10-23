//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 2, 10/22/15


public class Student 
	implements Comparable<Student>{
		// class of a student holding and ID and Last Name.

	private long studentID; //the student ID
	private String lastName; // the students last name

	public Student(long studentID, String lastName){ 
		//Constructor for student class with custom ID and Last Name.
		
		this.studentID = studentID;
		this.lastName = lastName;
	}

	public int compareTo(Student other){ 
		// comparing "this" student's ID to the "other" student's ID

		if(this.studentID < other.studentID){
			return -1;
		}else if(this.studentID > other.studentID){
			return 1;
		}else{
			return 0;
		}
	}

	public String toString(){ 
		//prints "this" student's ID and Name 
		
		return "{ " + "id: " + this.studentID + ", " + "name: " + this.lastName + " }";
	}

}