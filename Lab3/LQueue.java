import java.util.*;

public class LQueue<T> {

	public LQueue(){
		front = null;
		end = null;
	}
	private class Node<T>{
		public T element;
		public Node next;
		public Node(T value,Node node){
			element = value;
			next = node;
		}
	}	
    private Node front;
    private Node end;
	public void enqueue(T item){
		if (isEmpty()){
			Node blah = new Node(item, null);
			front = blah;
			end = blah;
		} else {
			Node temp = new Node(item,null);
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
        public MyExcpetion(){
        	super();
        }
        public MyExcpetion(String message){
        	super(message);
        }
	}
}
