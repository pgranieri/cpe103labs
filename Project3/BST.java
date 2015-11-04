//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.lang.*;


public class BST <T extends Comparable<? super T>> { // a Binary search tree with operations of LogN time

	private class BSTNode{ // the node class which contains two pointers to a left and right child and it also holds an element of T type
		T element; // item stored in the node
		BSTNode leftChild; // left next node
		BSTNode rightChild; // right next node

		public BSTNode(T element){ // a constructor that creates a node that points to nothing and contains a desired element
			this(element, null, null);			
		}

		public BSTNode(T element, BSTNode leftChild, BSTNode rightChild){ // a constructor that creates a node containing an element and two pointers to the left and right
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;			
		}
	}
	private BSTNode root; // the top of the tree

	private class PreIter implements Iterator<T>{ // and iterator that goes through the tree in pre-order

		private MyStack<BSTNode> stack; // creates a variable for mystack

		public PreIter(){ // constructor that creates the mystack and pushes the root into the stack if it isn't null
			stack = new MyStack<BSTNode>();
			if (root != null){
				stack.push(root);
			}
		}

		public boolean hasNext(){ // see's if the stack is empty or not
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){ // cycles to the next spot in the tree in preorder
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

		public void remove(){ // unsupported operation
			throw new UnsupportedOperationException();
		}

	}

	private class InIter implements Iterator<T>{ // class iterator the cycles through the tree in in-order

		private MyStack<BSTNode> stack; // creates a variable of mystack

		private void stackUpLefts(BSTNode node){ // private method that puts all the left nodes into the stack
			while(node.leftChild != null){
				stack.push(node.leftChild);
				node = node.leftChild;
			}
		}

		public InIter(){ // the constructor of the iterator that calls stack up lefts to fill the stack
			stack = new MyStack<BSTNode>();
			if(root != null){
				stack.push(root);
				stackUpLefts(root);
			}
		}

		public boolean hasNext(){ // see's if the stack is empty or not
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){ // cycles into the next in-order position of the tree
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


		public void remove(){ // unsupported operation
			throw new UnsupportedOperationException();
		}

	}



	private class LevelIter implements Iterator<T>{ // iterator the cycles through the tree in level-order
		
		LQueue<BSTNode> q; // creates a variable for the LQueue

		public LevelIter(){ // constructor for the level iterator that enqueues the root of the tree
			q = new LQueue<BSTNode>();

			if (root != null) {
				q.enqueue(root);
			}
		}

		public boolean hasNext(){ // checks to see if the queue is empty
			if (q.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next() { // cycles to the next position in level-order
			if (q.isEmpty()) 
				throw new NoSuchElementException();
			BSTNode nextNode = q.dequeue();
			if (nextNode.leftChild != null)
				q.enqueue(nextNode.leftChild);
		
			if (nextNode.rightChild != null)
				q.enqueue(nextNode.rightChild);

			return nextNode.element;
		}

		public void remove(){ // unsupported operation
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

	public BST(){ // constructor for empty binary search tree
		root = null;
	}

	public void insert(T item){ // public method for the user to insert an item
		root = insert(item, root);
	}

	private BSTNode insert(T item, BSTNode treeroot){ // recursive private method that inserts the item into the correct position in the tree
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

	public void delete(T item){ // public method for the user to delete the item
		root = delete(item,root);
	}

	private BSTNode delete(T item, BSTNode treeroot){ // private recursive method used to delete the item 
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

	private BSTNode deleteNode(BSTNode node){ // private method to assist the recursive method in arranging the tree in the right order after the delete
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

	private T successor(BSTNode node){ // finds the successor of the node being deleted
		BSTNode temp = node.rightChild;
		while(temp.leftChild != null){
			temp = temp.leftChild;
		}
		return temp.element;
	}

	public boolean find(T item){ // public method for the user to call to see if an item is within the bst
		return find(item,root);
	}

	private boolean find(T item, BSTNode treeroot){ // private recursive method used to find the item
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

	public boolean isEmpty(){ // checks if the tree is empty
		if(root == null){
			return true;
		}else{
			return false;
		}
	}

	public void makeEmpty(){ // empties the tree
		root = null;
	}

	public int size(){ // public method for user to use to find the size of the bst
		return size(root);
	}

	private int size(BSTNode treeroot){ //recursive method that sums up all the nodes and returns it as the size
		int answer;
		if(treeroot == null){
			answer = 0;
		}else{
			answer = 1 + size(treeroot.leftChild) + size(treeroot.rightChild);
		}
		return answer;		
	}

	public T findMinimum(){ // public method for the user to find the minimum element
		if(root == null){
			throw new MyException();
		}
		return findMinimum(root);
	}

	private T findMinimum(BSTNode treeroot){ // goes to the left most element and returns it
		T answer;
		if(treeroot.leftChild == null){
			answer = treeroot.element;
		}else{
			answer = findMinimum(treeroot.leftChild);
		}
		return answer;		
	}

	public T findMaximum(){ // public method for the user to call to find largest element
		if(root == null){
			throw new MyException();
		}
		return findMaximum(root);	
	}

	private T findMaximum(BSTNode treeroot){ // finds the right most node and returns the element within it
		T answer;
		if(treeroot.rightChild == null){
			answer = treeroot.element;
		}else{
			answer = findMaximum(treeroot.rightChild);
		}
		return answer;	
	}

	public Iterator<T> iteratorPre(){ // constructor for the pre order iterator
		return new PreIter();
	}


	public Iterator<T> iteratorIn(){ // constructor for the in order iterator
		return new InIter();
	}


	public Iterator<T> iteratorLevel(){ // constructor for the level order iterator
		return new LevelIter();
	}

	public void printTree(){ // public method for user to use to print the tree
		printTree(root, "");
	}

	private void printTree(BSTNode treeroot, String indent){ // private method that recursivley prints the tree adding the correct indentation
		if (treeroot != null){
			System.out.println(indent + treeroot.element);
			printTree(treeroot.leftChild, indent + "    ");
			printTree(treeroot.rightChild, indent + "    ");
		}
	}

	public String toString(){ // converts the tree into a string
		return toString(root);
	}

	private String toString(BSTNode treeroot){ // converts the tree into a string
		String answer = "";
		if(treeroot != null){
			answer += treeroot.element + " " + toString(treeroot.leftChild) + toString(treeroot.rightChild);
		}
		return answer;
	}

}