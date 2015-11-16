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

		}else if(head.element >= item){
			
			Node temp1 = new Node(head.element,head.next);
			//System.out.println("insert 1 " + head.element);
			head.element = item;
			head.next = temp1;
			//System.out.println("insert 1 after reassignment  " + head.element);

		}else{

		
		Node current = head;

		while(current.next != null && current.next.element < item){ // why is it less than right here? specs. say ">=".... once the next is greater than item we want to stop.. i think i got it
			current = current.next;		
		}// after this, current should be smaller than item

		
		Node temp2 = new Node(item,current.next);
		System.out.println("insert 2 " + current.element);
		current.next = temp2;
		System.out.println("insert 2 after assignment" + current.element);

		}
	}

	public void delete(int item){
		if(head == null){
			return;
		}else if(head.element == item){
			head = head.next;
			// Node temp = head;
			// head = new Node(item,temp);
		}else if(head.element == item && head.next == null){
			head = null;
		}else{
			Node current = head;

			while(current.next != null && current.next.element < item){ // why is it less than right here..?
				current = current.next;
			}
			if(current.next.next == null && current.next.element == item){
				current.next = null; // if your at the end of the list
			}else if(current.next == null){
				return;
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
		return head.element;
	}

	public void print(){

		Node current = head;
		String output = "";
		if(isEmpty()){
			System.out.println(" ");
			return;
		}else{
			while(current != null){
				//System.out.println("print here 1");
				output += current.element + " ";
				current = current.next;
			}
			System.out.println(output);
		}
	}

	public boolean isEmpty(){
		return head == null;
	}
}