import java.util.*;

public class AStack<T>{
	private T[] arr; // the array
	private int top; //index of top element
	
	public AStack(int arrsize){
		arr = (T[]) new Object[arrsize];
		top = -1;  
	}


	public void push(T value){
		if(top == arr.length-1){
			T[] temparr = (T[]) new Object[arr.length*2];
			for(int i =0; i< arr.length; i++){
				temparr[i] = arr[i];
			}
			arr = temparr;
		}
		top++;
		arr[top] = value;		
	}

	public T pop(){
		if(top < 0){
        	throw new MyException("Stack Empty");
		}
		else{
			T value = arr[top];
			top--;
			return value;
		}		 
	}

	public T peek(){
		if(top < 0){
        	throw new MyException("Stack Empty");
		}
		else{
			return arr[top];
		}
	}

	public boolean isEmpty(){
		if(top<0){
			return true;
		}
		else{
			return false;
		}
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