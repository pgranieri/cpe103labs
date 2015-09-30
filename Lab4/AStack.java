import java.util.*;

public class AStack<T>{
	private T arr[]; // the array
	private int top; //index of top element
	
	public AStack(int arrsize){
		arr = new T[arrsize];
		top = -1;  
	}
	public void push(T value){
		top++;
		arr[top] = value;
	}

	public static class MyException extends RuntimeException{
        public MyException(){
        	super();
        }
        public MyException(String message){
        	super(message);
        }
	}
}