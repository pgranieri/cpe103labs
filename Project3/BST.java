//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 3,  10/29/2015

public class BST <T extends Comparable<? super T>> {
	private class BSTNode{
		T element;
		BSTNode leftChild;
		BSTNode rightChild;

		public BSTNode(int element, BSTNode leftChild,BSTNode rightChild){
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;			
		}
	}
	private BSTNode root;

	private class PreIter{

	}

	private class InIter{

	}

	private class LevelIter{

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

	}

	public void delete(T item){

	}

	public boolean find(T item){

	}

	public boolean isEmpty(){

	}

	public void makeEmpty(){

	}

	public int size(){
		return size(root);
	}

	private int size(BSTNode treeroot){
		int answer;

		if(treeroot == null){
			answer = 0;
		}
		
	}

	public T findMinimum(){

	}

	public T findMaximum(){

	}

	public Iterator<T> iteratorPre(){

	}


	public Iterator<T> iteratorIn()){
		
	}


	public Iterator<T> iteratorLevel(){
		
	}

	public void printTree(){

	}

	public String toString(){

	}

}