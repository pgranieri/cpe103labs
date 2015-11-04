//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;

public class LQueue<T> {
	//Custom generic implementation of a Queue using a linked list structure. 

	public LQueue(){
		//Initiates the Queue by setting the front and the end to null.
		front = null;
		end = null;
	}

	private class Node<T>{
		//class used as the basis of the Linked list to hold the data and references to the next item.

		public T element;
		public Node<T> next;

		public Node(T value,Node node){
			//Creates the Node by setting the element and the pointer to the next node = to the arguments. 
			element = value;
			next = node;
		}
	}	
	
    private Node<T> front; //Node used to hold the beginning of the Queue
    private Node<T> end; //Node used to hold the end of the Queue. 


	public void enqueue(T item){
		//Puts an item at the end of the queue, with a special case for if the queue is empty. 
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
	public T dequeue(){
		//Removes an item from the beginning of of the queue.

		if(isEmpty()){
			throw new MyException("queue empty"); 
		}
		else{
			T temp = front.element;
			front = front.next;
			return temp;
		}
	}
	
	public boolean isEmpty(){
		//Checks to see if the queue is empty. 

		if(front == null){
			return true;
		}
		else{
			return false;
		}
	}
	public static class MyException extends RuntimeException{
		//Peronal error used if the queue is refrenced while empty.

        public MyException(){
        	//Creates an error without an error message. 
        	super();
        }
        public MyException(String message){
        	//Creates an error with a message. 
        	super(message);
        }
	}
}
