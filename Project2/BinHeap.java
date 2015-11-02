//	Authors: Patrick Granieri and Nick Gatehouse
//	ID's: pgranier@calpoly.edu and ngatehou@calpoly.edu
//	Project 2, 10/22/15

public class BinHeap <T extends Comparable<? super T>> {
	// BinHeap is a custom ADT of a binary heap stucture. 

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

	private T[] heap; //Implementation of the heap that holds all of the data.
	private int  heapsize; // Used to keep track of how many elements are inside of the heap.
	


	public BinHeap(){
		//Initializes the heap with a default size of 100 items. 

		heap = (T[]) new Comparable[100];
		heapsize = 0;
	}

	public BinHeap(int size){
		//Initializes the heap with a custom amount (size) of items.

		heap = (T[]) new  Comparable[size];
		heapsize = 0;
	}




	public void insert(T element){
		// Inserts 'element' into the correct space in the heap.

		if(heapsize == heap.length){
			T[] temp = (T[]) new  Comparable[heap.length*2];
			for(int i = 0; i < heap.length; i++){
				temp[i] = heap[i];
			}
			heap = temp;
		}

		int holeIndex = heapsize;
		T hole = heap[holeIndex];
		int parentIndex = (heapsize-1)/2;
		T parent = heap[parentIndex];

		while (holeIndex > 0 && !isParentValid(element,parent)) {
			heap[holeIndex] = parent;
			holeIndex = parentIndex;
			parentIndex = (parentIndex-1)/2;
			parent = heap[parentIndex];
		}

		heap[holeIndex] = element;
		heapsize++;
	}


	private boolean isParentValid(T child, T parent){
		//Checks to see if the parent is less than the child. 

		boolean result;

		if(child.compareTo(parent) < 0){
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	public T deleteMin(){
		//Deletes the smallest element in the heap, and adjusts the rest of the heap to be valid.

		if(heapsize == 0){
			throw new MyException(); 
		}
		T returnValue = heap[0]; //the root of the tree -> smallest item in heap		
		int itemIndex = heapsize-1; // the item's index
		T item = heap[itemIndex]; // the item that will be swapped through the holes
		heapsize--;//decrease size of collection
		int hole = 0; // set hole at root

		int nHole = newHole(hole,item);		
		while(nHole != -1){
			heap[hole] = heap[nHole];
			hole = nHole;
			nHole =newHole(hole,item);
		}

		heap[hole] = item;
		return returnValue;
	}

	private int newHole(int hole, T item){
		//Takes the index of the hole, and the value of the element being moved, and gives 
		//	the index of the next available hole in the heap.

		int returnIndex = -1;
		int smallestChild;
		if(2*hole +1 <= heapsize){ // left child of hole within collection
			if(2*hole +2 > heapsize){// right child of hole NOT within collection
				if(heap[2*hole+1].compareTo(item) < 0){
					returnIndex = 2*hole+1; //left child is new hole
				}				
			}else{ //the hole has 2 children
				if(heap[2*hole+1].compareTo(heap[2*hole+2]) < 0){ //finding the smallest child
					smallestChild = 2*hole+1; //left
				}else{
					smallestChild = 2*hole+2; //right
				}
				if(heap[smallestChild].compareTo(item) < 0){ // compare smallest child to item
					returnIndex = smallestChild;
				}
			}
		}
		return returnIndex;
	}

	public boolean isEmpty(){
		// Checks to see if the heap is empty.

		if(heapsize == 0){
			return true;
		}else{
			return false;
		}
	}

	public int size(){
		//returns the amount of elements within the heap.
		return heapsize;
	}
	
	public String toString(){
		//Outputs the values of the heap in the format of a string.

		String output = "";
		for(int i = 0; i < heapsize ; i++){
			output += heap[i] + " ";
		}
		return output;
	}
}
