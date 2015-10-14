public class MyList{
	private Node head;
	private class Node{
		public int element;
		public Node next;
		public Node(int element, Node next){
			this.element = element;
			this.next = next;
		}
	}

	public MyList(){
		head = null;
	}

	public void add(int val){
		Node temp = new Node(val, head);
		head = temp;
	}

	public boolean find(int val){
		return recFind(val, head);
	}


	private boolean recFind(int val, Node head){
		if (head.element == val){
			return true;
		} else {
			return recFind(val, head.next);
		}
	}


	public void print(){
		String answer = recPrint(head);
		System.out.println(answer);
	}

	private String recPrint(Node head){
		String result;

		if (head == null){
			return "";
		} else {
			result = recPrint(head.next) + " " + head.element;
			return result;
		}
	}

	public int sum(){
		return recSum(head);
	}

	private int recSum(Node head){
		if(head == null){
			return 0;
		}else{
			return head.element + recSum(head.next); 
		}
	}
}