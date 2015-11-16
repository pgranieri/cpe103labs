public class L8MyList{
	private Node head;

	private class Node{
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
		// Node currentNode = head;
		// boolean answer = false; 
		// while(currentNode.next != null){ 
		// 	currentNode = currentNode.next; 
		// 	if(item == currentNode.element){ 
		// 		answer = true; 
		// 	}else if (item == currentNode.next.element ){
		// 		answer = true;
		// 	}
		// }
		// return answer; iterative and sloppy

		if(head == null){
			return false;
		}else if(head.element == item){
			return true;
		}else if(head.next == null){
			return false;
		}else{
			return find(item,head.next);
		}
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