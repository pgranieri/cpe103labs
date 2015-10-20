public class MySortedList {
	private class Node {
		public int element;
		public Node next;
	}

	private Node head;

	public MySortedList(){
		head = null;
	}

	public void add(int item){
		if(head == null){
			head = new Node();
			head.element = item;
		}else if (head.element >= item){
			Node temp = new Node();
			temp.element = head.element;
			head.element = item;
			head.next = temp;
		}else{
			Node current = findNode(item);
			Node temp = new Node();
			temp.element = item;
			temp.next = current.next;
			current.next = temp;
		}
	}

	public void delete(int item){
		if(head == null){
			return;
		}else if (head.element == item){
			head = head.next;
		}
		Node current = findNode(item);
		if(current.element == item){
			current.next= current.next.next;
		}else{
			return;
		}

	}

	private Node findNode(int item){
		Node current = head;
		while(current.next.element < item || !(current.next == null)){
			current = head.next;
		}
		return current;
	}

	public int max(){
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		return current.element;
	}

	public int min(){
		return head.element;
	}

	public void print(){
		Node currrent = head;
		String result = "";
		while (current.next !=null){
			result += current.element + " ";	
		}
		System.out.println(result);		
	}

	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
}