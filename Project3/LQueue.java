//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;

<<<<<<< HEAD
public class LQueue<T> { // a queue

	public LQueue(){ // constructor for the queue
=======
public class LQueue<T> {
	//Custom generic implementation of a Queue using a linked list structure. 

	public LQueue(){
		//Initiates the Queue by setting the front and the end to null.
>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
		front = null;
		end = null;
	}

<<<<<<< HEAD
	private class Node<T>{ // nodes that will be placed into the queue
=======
	private class Node<T>{
		//class used as the basis of the Linked list to hold the data and references to the next item.

>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
		public T element;
		public Node<T> next;

		public Node(T value,Node node){
			//Creates the Node by setting the element and the pointer to the next node = to the arguments. 
			element = value;
			next = node;
		}
	}	
	
<<<<<<< HEAD
    private Node<T> front; // front of queue
    private Node<T> end; // end of queue


	public void enqueue(T item){ // adds the element to the back
=======
    private Node<T> front; //Node used to hold the beginning of the Queue
    private Node<T> end; //Node used to hold the end of the Queue. 


	public void enqueue(T item){
		//Puts an item at the end of the queue, with a special case for if the queue is empty. 
>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
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
<<<<<<< HEAD

	public T dequeue(){ // deletes element from the front
=======
	public T dequeue(){
		//Removes an item from the beginning of of the queue.

>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
		if(isEmpty()){
			throw new MyException("queue empty"); 
		}
		else{
			T temp = front.element;
			front = front.next;
			return temp;
		}
	}
	
<<<<<<< HEAD
	public boolean isEmpty(){ // checks if queue is empty
=======
	public boolean isEmpty(){
		//Checks to see if the queue is empty. 

>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
		if(front == null){
			return true;
		}
		else{
			return false;
		}
	}
	public static class MyException extends RuntimeException{
<<<<<<< HEAD
		// Custom Error primarily used for empty cases.

        public MyException(){
        //Default constructor used if no output text is given.
        	super();
        }
        public MyException(String message){
        //Takes in message as an error message for custom output.
=======
		//Peronal error used if the queue is refrenced while empty.

        public MyException(){
        	//Creates an error without an error message. 
        	super();
        }
        public MyException(String message){
        	//Creates an error with a message. 
>>>>>>> 63114dec0dc258458ce778dbe41e880cf29a40f3
        	super(message);
        }
	}
}
