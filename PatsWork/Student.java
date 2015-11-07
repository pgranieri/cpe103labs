public class Student{
	private Long studentID;
	private String lastName;

	public Student(long id, String name) {
		studentID = new Long(id);
		lastName = name;
	}

	public boolean equals(Student other) { //Object or Student?
		return this.studentID == other.studentID;
	}

	public String toString(){
		return "{ id: " + studentID + ", name: " + lastName + " }";
	}

	public int hashCode(){
		return studentID.hashCode();
	}
}