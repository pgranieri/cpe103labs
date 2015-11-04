//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

import java.util.*;
import java.lang.*;


public class BST <T extends Comparable<? super T>> {
	//A personal implementation of the Binary Search Tree ADT

	private class BSTNode{
		//This class is used as the basis for the linked structure. 

		T element; //Holds the value for each point in the tree.
		BSTNode leftChild; //Holds the pointer to the next left child. 
		BSTNode rightChild; //Holds the pointer to the next right child.

		public BSTNode(T element){
			//Creates a node with an element and no children.
			this(element, null, null);			
		}

		public BSTNode(T element, BSTNode leftChild, BSTNode rightChild){
			//Creates a new node with an element, and pointers to both children.
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;			
		}
	}
	private BSTNode root; //This is the base of the BST structure.

	private class PreIter implements Iterator<T>{
		//This class is an iterator that follows the Pre- method. 

		private MyStack<BSTNode> stack; //This holds the remaining nodes to be iterated through

		public PreIter(){
			//creates the stack for the iterator and pushes the root into the stack. 
			stack = new MyStack<BSTNode>();
			if (root != null){
				stack.push(root);
			}
		}

		public boolean hasNext(){
			//Checks to see if there is another node inside of the stack.
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){
		//If there is another node in the stack, it returns that node. Otherwise it throws an error. 

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
			//Throws an error if called. 
			throw new UnsupportedOperationException();
		}

	}

	private class InIter implements Iterator<T>{
		//This class is an iterator that implements the In- Method. 

		private MyStack<BSTNode> stack; //Holds the remaining nodes left in the BST

		private void stackUpLefts(BSTNode node){
			while(node.leftChild != null){
				stack.push(node.leftChild);
				node = node.leftChild;
			}
		}

		public InIter(){
			//Creates a stack to hold the nodes, pushs the root into it, and pushs all of the left children in. 
			stack = new MyStack<BSTNode>();
			if(root != null){
				stack.push(root);
				stackUpLefts(root);
			}
		}

		public boolean hasNext(){
			//Checks to see if there are any nodes left within the stack.
			if (stack.isEmpty()) {
				return false;
			} else {
				return true;
			}
		}

		public T next(){
			//Returns the next node in the tree using the In- method, and then pushes that nodes' right child and it's left children. 
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
			//Throws an error if called.
			throw new UnsupportedOperationException();
		}

	}



	private class LevelIter implements Iterator<T>{
		//Creates an iterator that implements the Level method.
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
		//creates the tree by setting the root = null
		root = null;
	}

	public void insert(T item){
		//Inserts the item into the tree by beginning the recurive method call.
		root = insert(item, root);
	}

	private BSTNode insert(T item, BSTNode treeroot){
		//Recursively inserts the item into the tree.
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
		//Deletes the item from the tree by calling the recursive delete method.
		root = delete(item,root);
	}

	private BSTNode delete(T item, BSTNode treeroot){
		//Recursively searches through the tree to find the node to be deleted, then calls deleteNode
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
		//Helper method for the delete method, specifically deletes the node from the tree. 
		BSTNode newRoot;
		if (node.leftChild != null && node.rightChild != null){
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
		//Another helper method, used to find the node that should replace the node being deleted.
		BSTNode temp = node.rightChild;
		while(temp.leftChild != null){
			temp = temp.leftChild;
		}
		return temp.element;
	}

	public boolean find(T item){
		//Begins the recursive method to see if the item is within th tree.
		return find(item,root);
	}

	private boolean find(T item, BSTNode treeroot){
		//Recursively searches through the tree to see if the item is contained within it. 
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
		//Checks to see if the tree is empty by checking the root. 
		if(root == null){
			return true;
		}else{
			return false;
		}
	}

	public void makeEmpty(){
		//Makes the tree empty by setting root = null;
		root = null;
	}

	public int size(){
		//Begins the recursive method to find the size of the tree.
		return size(root);
	}

	private int size(BSTNode treeroot){
		//Recurses through the tree, adding to the size as it goes through each level. 
		int answer;
		if(treeroot == null){
			answer = 0;
		}else{
			answer = 1 + size(treeroot.leftChild) + size(treeroot.rightChild);
		}
		return answer;		
	}

	public T findMinimum(){
		//Begins the recursive call to find the minimum. If it is empty, it throws an error.
		if(root == null){
			throw new MyException();
		}
		return findMinimum(root);
	}

	private T findMinimum(BSTNode treeroot){
		//Finds the minimum of the tree by going all the way to the bottom left. 
		T answer;
		if(treeroot.leftChild == null){
			answer = treeroot.element;
		}else{
			answer = findMinimum(treeroot.leftChild);
		}
		return answer;		
	}

	public T findMaximum(){
		//Begins the recursive call to find the maximum. If it is empty, it throws an error.
		if(root == null){
			throw new MyException();
		}
		return findMaximum(root);	
	}

	private T findMaximum(BSTNode treeroot){
		//Searches through the tree all the way to the bottom right. 
		T answer;
		if(treeroot.rightChild == null){
			answer = treeroot.element;
		}else{
			answer = findMaximum(treeroot.rightChild);
		}
		return answer;	
	}

	public Iterator<T> iteratorPre(){
		//Creates a new Pre- method Iterator
		return new PreIter();
	}


	public Iterator<T> iteratorIn(){
		//Creates a new In- method Iterator.
		return new InIter();
	}


	public Iterator<T> iteratorLevel(){
		//Creates a new Level method Iterator. 
		return new LevelIter();
	}

	public void printTree(){
		//Begins the recursive method call to print out the tree. 
		printTree(root, "");
	}

	private void printTree(BSTNode treeroot, String indent){
		//Recurses through the tree, printing it out to the screen with proper indents for heirarchy.
		if (treeroot != null){
			System.out.println(indent + treeroot.element);
			printTree(treeroot.leftChild, indent + "    ");
			printTree(treeroot.rightChild, indent + "    ");
		}
	}

	public String toString(){
		//Begins the trcursive call to convert the tree to a string.
		return toString(root);
	}

	private String toString(BSTNode treeroot){
		//Recurses through the tree, printing out in a similar method to print tree but without indents and on one line. 
		String answer = "";
		if(treeroot != null){
			answer += treeroot.element + " " + toString(treeroot.leftChild) + toString(treeroot.rightChild);
		}
		return answer;
	}

}
