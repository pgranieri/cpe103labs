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
		heap = (T[]) new Comparable[100];
		heapsize = 0;
	}

	public BinHeap(int size){
		heap = (T[]) new  Comparable[size];
		heapsize = 0;
	}

	public void insert(T element){
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
		int itemIndex = heapsize-1; // the item's index
		T item = heap[itemIndex]; // the item that will be swapped through the holes
		heapsize--;//decrease size of collection
		int hole = 0; // set hole at root

		// after this point i am having a little trouble/confusion
		int nHole =newHole(hole,item);		
		while(nHole != -1){
			heap[hole] = heap[nHole]; // specifially with this line of code
			hole = nHole;
			nHole =newHole(hole,item);
			//System.out.println(newHole(hole,item) + "   new hole ------");
		}
		//System.out.println(hole + "   holes index");

		heap[hole] = item;
		return returnValue;
	}

	private int newHole(int hole, T item){ // both paramaters are indexes
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
