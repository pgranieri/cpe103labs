import java.util.*;

public class MyStack<T>{
	private class Node<T>{
		public T element;
		public Node<T> next;

		public Node(T element, Node<T> next){
			this.element = element;
			this.next = next;
		}
	}

	private Node<T> top;

	public MyStack(){
		top = null;
	}

	public void push(T value){
		Node<T> temp = new Node<T>(value, top);
		top = temp;
	}

	public T pop() {
		if (top != null) {
			T tValue = top.element;
			top = top.next;
			return tValue;
		} else {
			throw new EmptyStackException();
		}
	}

	public T peek(){
		if (top != null) {
			return top.element;
		} else {
			throw new EmptyStackException();
		}
	}

	public boolean isEmpty(){
		if (top!=null){
			return false;
		} else {
			return true;
		}
	}
}