public class Student 
	implements Comparable<Student>{

	private long studentID; //the student ID
	private String lastName; // the students last name

	public student(long studentID, String lastName){ //Constructor for student class
		this.studentID = studentID;
		this.lastName = lastName;
	}

	public int CompareTo(Student other){ // comparing "this" student's ID to the "other" student's ID
		if(this.studentID < other.studentID){
			return -1;
		}else if(this.studentID > other.studentID){
			return 1;
		}else{
			return 0;
		}
	}

	public String toString(){ //prints "this" student's ID and Name 
		return "{ " + "id: " + this.studentID + ", " + "name: " + this.lastName + " }";
	}

}