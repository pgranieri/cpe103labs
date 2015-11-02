//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;

public class LQueue<T> {

	public LQueue(){
		front = null;
		end = null;
	}

	private class Node<T>{
		public T element;
		public Node<T> next;
		public Node(T value,Node node){
			element = value;
			next = node;
		}
	}	
	
    private Node<T> front;
    private Node<T> end;


	public void enqueue(T item){
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
		if(front == null){
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
