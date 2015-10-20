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
		heap = new (T[]) Object[100];
		heapsize = 0;
	}

	public BinHeap(int size){
		heap = new (T[]) Object[size];
		heapsize = 0;
	}

	public void insert(T element){
		if(heapsize == heap.length() - 1){
			T[] temp = new (T[]) Object[heap.length()*2];
			for(i = 0; i < heap.length(); i++){
				temp[i] = heap[i];
			}
			heap = temp;
		}

		int holeIndex = heapsize;
		T hole = heap[holeIndex];
		int parentIndex = (heapsize-1)/2;
		T parent = heap[parentIndex];

		while (parentIndex=>0 && !isParentValid(element,parent)) {
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
	
}