import java.lang.*

public class Student{
	// id > 0 , only one id per student even after deletion 
	// no space in last name

	private long id;
	private String lastName;

	public student(long id, String name){
		this.id = id;
		this.lastName = name;
	}

	public boolean equals(Object other){
		return this.id == other;
	}

	public String toString(){
		return "{ id: " + this.id + ", name: " + this.lastName + " }";
	}

	public int hashCode(){
		return Long.hashCode(this.id);
	}

}