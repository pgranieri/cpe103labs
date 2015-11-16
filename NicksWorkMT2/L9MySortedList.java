public class L9MySortedList{
	
	private class Node{
		public int element;
		public Node next;

		public Node(int item,Node next){
			this.element = item;
			this.next = next;
		}
	}

	private Node head;

	public L9MySortedList(){
		head = null;
	}

	public void add(int item){
		if(head == null){
			head = new Node(item,null);

		}else if(item <= head.element){
			Node temp = head;
			head = new Node(item,temp);

		}else{

		
		Node current = head;

		while(current.next != null){
			if(current.next.element >= item){
				current = current.next;
			}
			
		}// after this, current should be smaller than item
		Node temp = current;
		current = new Node(item,temp);
		}
	}

	public void delete(int item){
		if(head == null){
			return;
		}else if(head.element == item){
			Node temp = head;
			head = new Node(item,temp);
		}else{
			Node current = head;

			while(current.next != null && current.next.element >= item){
				current = current.next;
			}
			if(current.next.next == null && current.next.element == item){
				current.next = null; // if your at the end of the list
			}else if(current.next.element == item){
				current.next = current.next.next;
			}else{
				return;
			}
		}
	}

	public int max(){
		Node current = head;
		while (current.next != null){
			current = current.next;
		}
		return current.element;
	}

	public int min(){
		return head;
	}

	public void print(){
		Node current = head;
		String output = "";
		while(current.next != null){
			output += current.element + " ";
			current = current.next;
		}
		System.out.println(output);
	}

	public boolean isEmpty(){
		return head == null;
	}
}