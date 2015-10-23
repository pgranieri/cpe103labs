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
			head.next = null;
			//System.out.println("This run? 1");
		}else if (head.element >= item){
			Node temp = new Node();
			temp.element = head.element;
			temp.next = head.next;
			head.element = item;
			head.next = temp;
			//System.out.println("This run? 2");
		}else{
			Node current = head;

			while(!(current.next == null) && (current.next.element < item)){
				current = current.next;
			}

			Node temp = new Node();
			temp.element = item;
			temp.next = current.next;
			current.next = temp;
			//System.out.println("This run? 3");
		}
	}

	public void delete(int item){
		if(head == null){
			return;
		}else if (head.element == item){
			head = head.next;
			return;
		}

		if(head.next == null && head.element == item){
			head = null;
			return;
		}
		Node current = head;

		//System.out.println(!(current.next == null));
		while(!(current.next == null) && (current.next.element < item)){
			current = current.next;
		}

		if(current.next == null){
			return;
		}else if (current.next.element == item){
			current.next = current.next.next;
		} else {
			return;
		
		}

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
		Node current = head;
		if(isEmpty()){
			System.out.println("");
			return;
		}
		String result = "";
		while (current != null){
			result += current.element + " ";
			current = current.next;	
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
