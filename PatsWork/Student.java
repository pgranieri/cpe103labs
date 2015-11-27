//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 4, 10/13/2015

public class Student{ // an object representation of a student
	private Long studentID; // the id of the student
	private String lastName; // the students last name

	public Student(long id, String name) { // constructor creating a new student
		studentID = new Long(id);
		lastName = name;
	}

	public boolean equals(Object other) { // compares 2 students for equality based on their id's
		Student other_student = (Student) other;
		return this.studentID.compareTo(other_student.studentID) == 0;
	}

	public String toString(){ // converts the students data into a string
		return "{ id: " + studentID + ", name: " + lastName + " }";
	}

	public int hashCode(){ // returns the hashcode for the id
		return studentID.hashCode();
	}
}


