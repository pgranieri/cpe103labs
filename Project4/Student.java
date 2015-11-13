public class Student{
	// id > 0 , only one id per student even after deletion 
	// no space in last name

	private Long id; // shouldn't this be primitive type, says so in the specs
	private String lastName;

	public Student(long id, String name){
		this.id = new Long(id);
		this.lastName = name;
	}

	public boolean equals(Object other){ 
		Student other_student = (Student) other;
		return this.id.compareTo(other.id);
	}

	// public boolean equals(Object other) {
	// 	Student other_student = (Student) other;
	// 	return this.studentID.compareTo(other_student.studentID) == 0;
	// }

	public String toString(){
		return "{ id: " + this.id + ", name: " + this.lastName + " }";
	}

	public int hashCode(){
		return id.hashCode();
	}

}