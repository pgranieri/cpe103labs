public class Student{
	private Long studentID;
	private String lastName;

	public Student(long id, String name) {
		studentID = new Long(id);
		lastName = name;
	}

	public boolean equals(Object other) {
		Student other_student = (Student) other;
		return this.studentID.compareTo(other_student.studentID) == 0;
	}

	public String toString(){
		return "{ id: " + studentID + ", name: " + lastName + " }";
	}

	public int hashCode(){
		return studentID.hashCode();
	}
}