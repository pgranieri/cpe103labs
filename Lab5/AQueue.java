public class AQueue<T>{
	private T[] arr;
	private int front;
	private int end;
	private int count; // check count for "fullness"

	public static class MyException extends RuntimeException{
        public MyException(){
        	super();
        }
        public MyException(String message){
        	super(message);
        }
	}

	public AQueue(int size){
		arr = (T[]) new Object[size];
		front = 0;
		end = -1;
		count = 0;
	}

	public boolean isEmpty(){
		if(count == 0){
			return true;
		}else{
			return false;
		}
	}

	public void enqueue(T value){
		if (count == arr.size()){
			T[] temp = (T[]) new Object[arr.size()*2];
			for (int i = 0; i < arr.size(); i++) {
				if (front + i < arr.size()){
					temp[i] = arr[front + i];
				} else {
					temp[i] = arr[front + i - arr.size()];
				}
			}

			arr = temp;
			front = 0;
			end = count-1;
		}

		if (end == arr.size() - 1){
			end = 0;
		} else {
			end ++;
		}
		arr[end] = value;
		count++;
	}

	public T dequeue(){
		if(arr.isEmpty()){
			throw new MyException();
		}
		T temp = arr[front];
		if(front == arr.size()-1){
			front = 0;
		}else{
			arr[front] = null;
			front++;
		}
		count--;
		return temp;		
	}

	public void printArray(){
		for (int i = 0; i < arr.size(); i++){
			System.out.print(arr[i] + " ");
		}
	}
}