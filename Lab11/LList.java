import java.util.*;
import java.lang.*;

public class LList<T> {
	private Node head;

	private class Node {
		public T element;
		public Node next;
	}

	private class Iter 
		implements Iterator <T> {
		public Node cursor;

		public Iter () {
			cursor = head;
		}

		public boolean hasNext() {
			return cursor != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			T answer = cursor.element;
			cursor = cursor.next;
			return answer;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}


	}

	public LList(){
		head = null;
	}

	public Iter iterator() {
		return new Iter();
	}

	public void add(T element) {
		if(head == null){
			head = new Node();
			head.element = element;
			head.next = null;
			return; 
		}
		Node current = head;
		while(current.next!=null){
			current = current.next;
		}
		current.next = new Node();
		current = current.next;
		current.element = element;
		current.next = null;
	}
}