//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.lang.*;


public class BST <T extends Comparable<? super T>> {
	private class BSTNode{
		T element;
		BSTNode leftChild;
		BSTNode rightChild;

		public BSTNode(T element){
			this(element, null, null);			
		}

		public BSTNode(T element, BSTNode leftChild, BSTNode rightChild){
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;			
		}
	}
	private BSTNode root;

	private class PreIter implements Iterator<T>{
		private MyStack<BSTNode> stack;

		public PreIter(){
			stack = new MyStack<BSTNode>();
			if (root != null){
				stack.push(root);
			}
		}

		public boolean hasNext(){
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){
			if (stack.isEmpty())
				throw new NoSuchElementException(); 
			BSTNode nextNode;

			nextNode = stack.pop();
			if (nextNode.rightChild != null) {
				stack.push(nextNode.rightChild);
			}
			if (nextNode.leftChild != null) {
				stack.push(nextNode.leftChild);
			}
			return nextNode.element;

		}

		public void remove(){
			throw new UnsupportedOperationException();
		}

	}

	private class InIter implements Iterator<T>{
		private MyStack<BSTNode> stack;

		private void stackUpLefts(BSTNode node){
			while(node.leftChild != null){
				stack.push(node.leftChild);
				node = node.leftChild;
			}
		}

		public InIter(){
			stack = new MyStack<BSTNode>();
			if(root != null){
				stack.push(root);
				stackUpLefts(root);
			}
		}

		public boolean hasNext(){
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){
			if (stack.isEmpty())
				throw new NoSuchElementException(); 
			BSTNode nextNode;

			nextNode = stack.pop();
			if(nextNode.rightChild != null){
				stack.push(nextNode.rightChild);
				stackUpLefts(nextNode.rightChild);
			}
			return nextNode.element;
		}


		public void remove(){
			throw new UnsupportedOperationException();
		}

	}



	private class LevelIter implements Iterator<T>{
		LQueue<BSTNode> q;

		public LevelIter(){
			q = new LQueue<BSTNode>();

			if (root != null) {
				q.enqueue(root);
			}
		}

		public boolean hasNext(){
			if (q.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next() {
			if (q.isEmpty()) 
				throw new NoSuchElementException();
			BSTNode nextNode = q.dequeue();
			if (nextNode.leftChild != null)
				q.enqueue(nextNode.leftChild);
		
			if (nextNode.rightChild != null)
				q.enqueue(nextNode.rightChild);

			return nextNode.element;
		}

		public void remove(){
			throw new UnsupportedOperationException();
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

	public BST(){
		root = null;
	}

	public void insert(T item){
		root = insert(item, root);
	}

	private BSTNode insert(T item, BSTNode treeroot){
		if (treeroot == null){
			treeroot = new BSTNode(item);
		} else {
			if (item.compareTo(treeroot.element) < 0) {
				treeroot.leftChild = insert(item, treeroot.leftChild);
			} else{
				treeroot.rightChild = insert(item, treeroot.rightChild);
			}
		}
		return treeroot;
	}

	public void delete(T item){
		root = delete(item,root);
	}

	private BSTNode delete(T item, BSTNode treeroot){
		if (treeroot != null){
			if(item.compareTo(treeroot.element) < 0){
				treeroot.leftChild = delete(item,treeroot.leftChild); 
			}else if (item.compareTo(treeroot.element) > 0){
				treeroot.rightChild = delete(item,treeroot.rightChild);
			}else{
				treeroot = deleteNode(treeroot);
			}
		}
		return treeroot;
	}

	private BSTNode deleteNode(BSTNode node){
		BSTNode newRoot;
		if ( node.leftChild != null && node.rightChild != null ){
			T nextValue = successor(node);
			node.element = nextValue;
			node.rightChild = delete(nextValue,node.rightChild);
			newRoot = node;
		}else{
			if(node.leftChild != null){
				newRoot = node.leftChild;
			}else{
				if(node.rightChild != null){
					newRoot = node.rightChild;
				}else{
					newRoot = null;
				}
			}
		}
		return newRoot;
	}

	private T successor(BSTNode node){
		BSTNode temp = node.rightChild;
		while(temp.leftChild != null){
			temp = temp.leftChild;
		}
		return temp.element;
	}

	public boolean find(T item){
		return find(item,root);
	}

	private boolean find(T item, BSTNode treeroot){
		boolean answer;
		if(treeroot == null){
			answer = false;
		}else{
			if(item.compareTo(treeroot.element) == 0){
				answer = true;
			}else{
				if(item.compareTo(treeroot.element) < 0){
					answer = find(item,treeroot.leftChild);
				}else{
					answer = find(item,treeroot.rightChild);
				}
			}
		}
		return answer;
	}

	public boolean isEmpty(){
		if(root == null){
			return true;
		}else{
			return false;
		}
	}

	public void makeEmpty(){
		root = null;
	}

	public int size(){
		return size(root);
	}

	private int size(BSTNode treeroot){
		int answer;
		if(treeroot == null){
			answer = 0;
		}else{
			answer = 1 + size(treeroot.leftChild) + size(treeroot.rightChild);
		}
		return answer;		
	}

	public T findMinimum(){
		if(root == null){
			throw new MyException();
		}
		return findMinimum(root);
	}

	private T findMinimum(BSTNode treeroot){
		T answer;
		if(treeroot.leftChild == null){
			answer = treeroot.element;
		}else{
			answer = findMinimum(treeroot.leftChild);
		}
		return answer;		
	}

	public T findMaximum(){
		if(root == null){
			throw new MyException();
		}
		return findMaximum(root);	
	}

	private T findMaximum(BSTNode treeroot){
		T answer;
		if(treeroot.rightChild == null){
			answer = treeroot.element;
		}else{
			answer = findMaximum(treeroot.rightChild);
		}
		return answer;	
	}

	public Iterator<T> iteratorPre(){
		return new PreIter();
	}


	public Iterator<T> iteratorIn(){
		return new InIter();
	}


	public Iterator<T> iteratorLevel(){
		return new LevelIter();
	}

	public void printTree(){
		printTree(root, "");
	}

	private void printTree(BSTNode treeroot, String indent){
		if (treeroot != null){
			System.out.println(indent + treeroot.element);
			printTree(treeroot.leftChild, indent + "    ");
			printTree(treeroot.rightChild, indent + "    ");
		}
	}

	public String toString(){
		return toString(root);
	}

	private String toString(BSTNode treeroot){
		String answer = "";
		if(treeroot != null){
			answer += treeroot.element + " " + toString(treeroot.leftChild) + toString(treeroot.rightChild);
		}
		return answer;
	}

}