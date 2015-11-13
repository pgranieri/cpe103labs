public class L8MyList{
	private Node head;

	private class Node(){
		public int element;
		public Node next;

		public Node(int item, Node next){
			this.element = item;
			this.next = next;
		}
	}

	public L8MyList(){
		head = null;
	}

	public void add(int item){
		Node temp = head;
		head = new Node(item,temp);
	}

	public boolean find(int item){
		return find(item,head);
	}

	private boolean find(int item, Node head){
		Node currentNode = head;
		boolean answer = false; //assume its not there

		while(currentNode.next != null){ // while there is a next
			if(item == currentNode.element){ // if i found it
				answer = true; // return true
			}
			currentNode = currentNode.next; // go to next node
		}
		return answer;
	}

	public void print(){
		System.out.println(print(head));
	} 

	private String print(Node head){
		
		if(head == null){
			return "";
		}else if(head.next == null){
			return "" + head.element;
		}else{
			return head.element + " " + print(head.next);
		}
					
	}

	public int sum(){
		return sum(head);
	}

	private int sum(Node head){
		if(head == null){
			return 0;
		}else{
			return sum(head.next) + head.element;
		}
	}

}