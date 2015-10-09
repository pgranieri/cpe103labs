// Authors: Patrick Granieri & Nicholas Gatehouse 
// Usersids: pgranier@calpoly.edu ngatehou@calpoly.edu
// Project 1 10/8/15

import java.util.*;

public class MyStack<T>{
	// Stack ADT made from a linked list

	private class Node<T>{
		// Node that holds a value T and a reference to the next Node within MyStack

		public T element; // value held within a node

		public Node<T> next; // reference to the next node

		public Node(T element, Node<T> next){
			// constructor for an individual node within MyStack
			this.element = element;
			this.next = next;
		}
	}

	private Node<T> top; // first node in the stack

	public MyStack(){
		// constructor for the Stack ADT

		top = null;
	}

	public void push(T value){
		// creates a new node, places the value paramater within it, and then puts that new node on top 

		Node<T> temp = new Node<T>(value, top);
		top = temp;
	}

	public T pop() {
		//returns the value within the top node then deletes the top node

		if (top != null) {
			T tValue = top.element;
			top = top.next;
			return tValue;
		} else {
			throw new EmptyStackException();
		}
	}

	public T peek(){
		// returns the top node value 

		if (top != null) {
			return top.element;
		} else {
			throw new EmptyStackException();
		}
	}

	public boolean isEmpty(){
		// check to see if the Stack ADT is emptyq
		
		if (top!=null){
			return false;
		} else {
			return true;
		}
	}
}