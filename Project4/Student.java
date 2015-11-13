import java.lang.*;

public class Student{
	// id > 0 , only one id per student even after deletion 
	// no space in last name

	private Long id; // shouldn't this be primitive type, says so in the specs
	private String lastName;

	public Student(long id, String name){
		this.id = new Long(id);
		this.lastName = name;
	}

	public boolean equals(Object otherObj){ 
		Student other = (Student) otherObj;
		return this.id.compareTo(other.id);
	}

	public String toString(){
		return "{ id: " + this.id + ", name: " + this.lastName + " }";
	}

	public int hashCode(){
		return id.hashCode();
	}

}