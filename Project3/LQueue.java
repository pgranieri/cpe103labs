//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;

public class LQueue<T> { // a queue

	public LQueue(){ // constructor for the queue
		front = null;
		end = null;
	}

	private class Node<T>{ // nodes that will be placed into the queue
		public T element;
		public Node<T> next;
		public Node(T value,Node node){
			element = value;
			next = node;
		}
	}	
	
    private Node<T> front; // front of queue
    private Node<T> end; // end of queue


	public void enqueue(T item){ // adds the element to the back
		if (isEmpty()){
			Node<T> blah = new Node(item, null);
			front = blah;
			end = blah;
		} else {
			Node<T> temp = new Node(item,null);
			end.next=temp;
			end = temp;
		}
		
	}

	public T dequeue(){ // deletes element from the front
		if(isEmpty()){
			throw new MyException("queue empty"); 
		}
		else{
			T temp = front.element;
			front = front.next;
			return temp;
		}
	}
	
	public boolean isEmpty(){ // checks if queue is empty
		if(front == null){
			return true;
		}
		else{
			return false;
		}
	}
	public static class MyException extends RuntimeException{
		// Custom Error primarily used for empty cases.

        public MyException(){
        //Default constructor used if no output text is given.
        	super();
        }
        public MyException(String message){
        //Takes in message as an error message for custom output.
        	super(message);
        }
	}
}
