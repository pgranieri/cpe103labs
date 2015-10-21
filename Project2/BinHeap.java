public class BinHeap <T extends Comparable<? super T>> {

	public static class MyException extends RuntimeException{
        public MyException(){
        	super();
        }
        public MyException(String message){
        	super(message);
        }
	}

	private T[] heap;
	private int  heapsize;
	


	public BinHeap(){
		T[] heap = (T[]) new Comparable[100];
		heapsize = 0;
	}

	public BinHeap(int size){
		T[] heap = (T[]) new  Comparable[size];
		heapsize = 0;
	}

	public void insert(T element){
		if(heapsize == heap.length){
			T[] temp = (T[]) new  Object[heap.length*2];
			for(int i = 0; i < heap.length; i++){
				temp[i] = heap[i];
			}
			heap = temp;
		}

		int holeIndex = heapsize;
		T hole = heap[holeIndex];
		int parentIndex = (heapsize-1)/2;
		T parent = heap[parentIndex];
		//We need to use the compareTo method, we have to deal with comparable objects.
		while (parentIndex >= 0 && !isParentValid(element,parent)) {
			hole = parent;
			holeIndex = parentIndex;
			parentIndex = (parentIndex-1)/2;
			parent = heap[parentIndex];
		}
		hole = heap[holeIndex];
		heapsize++;
	}

	private boolean isParentValid(T child, T parent){
		boolean result;

		if(child.compareTo(parent) < 0){
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	public T deleteMin(){
		if(heapsize == 0){
			throw new MyException(); 
		}
		T returnValue = heap[0]; //the root of the tree -> smallest item in heap
		T item; // the item that will be swapped through the holes
		int itemIndex; // the item's index
		int indexLP = heapsize/2 - 1; // LP = largest parent "deepest rightmost parent"
		int leftChild = 2*indexLP+1;
		int rightChild = 2*indexLP+2;
		if(heap[leftChild].compareTo(heap[rightChild]) > 0){ // checking larger child to replace root
			item = heap[leftChild];
			itemIndex = leftChild;
		} else{ // if they are equal we should take the right child??***
			item = heap[rightChild];
			itemIndex = rightChild;
		}
		heapsize--;//decrease size of collection
		int hole = 0; // set hole at root

		// after this point i am having a little trouble/confusion
		int nHole =newHole(hole,itemIndex);		
		while(nHole != -1){
			heap[hole] = heap[nHole]; // specifially with this line of code
			hole = nHole;
			nHole =newHole(hole,itemIndex);
		}

		heap[hole] = item;
		return returnValue;
	}

	private int newHole(int hole, int item){ // both paramaters are indexes
		int returnIndex = -1;
		int smallestChild;
		if(2*hole +1 <= heapsize){ // left child of hole within collection
			if(2*hole +2 > heapsize){// right child of hole NOT within collection
				if(heap[2*hole+1].compareTo(heap[item]) < 0){
					returnIndex = 2*hole+1; //left child is new hole
				}				
			}else{ //the hole has 2 children
				if(heap[2*hole+1].compareTo(heap[2*hole+2]) < 0){ //finding the smallest child
					smallestChild = 2*hole+1; //left
				}else{
					smallestChild = 2*hole+2; //right
				}
				if(heap[smallestChild].compareTo(heap[item]) < 0){ // compare smallest child to item
					returnIndex = smallestChild;
				}
			}
		}
		return returnIndex;
	}

	public boolean isEmpty(){
		if(heapsize == 0){ // checking heapsize and not array size
			return true;
		}else{
			return false;
		}
	}

	public int size(){
		return heapsize; // not size of array but number of elements in array
	}
	
	public String toString(){
		String output = "";
		for(int i = 0; i < heapsize ; i++){
			output += heap[i] + " ";
		}
		return output;
	}
}
