package test;

public class LinkedList {

	LinkedListNode head;
	
	public void insert(int data) {
		LinkedListNode node = new LinkedListNode(data);
		
		if (head == null) {
			head = node;
		} else {
			LinkedListNode n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void insertAtStart(int data) {
		LinkedListNode node = new LinkedListNode(data, head);
		head = node;
	}
	
	/**
	 * @comment Will break if index > linkedlist.size
	 * @param index
	 * @param data
	 */
	public void insertAt(int index, int data) {
		LinkedListNode node = new LinkedListNode(data);

		if (index == 0) {
			insertAtStart(data);
		} else if (index > size()) {
			System.out.println("Insert Failed. List size:" + size() + " < index:" + index);
		} else {
			LinkedListNode n = head;
			for (int i = 0; i < index-1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}
	
	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			LinkedListNode n = head;
			LinkedListNode n1 = null;
			for (int i = 0; i < index-1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			n1 = null;
			//System.out.println("n1 " + n1.data);
		}
	}
	
	public LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		LinkedListNode next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head = prev;
		return head;
	}
	
	public int size() {
		int size = 0;
		if (head == null) {
			return 0;
		} else {
			LinkedListNode n = head;
			while (n.next != null) {
				n = n.next;
				size++;
			}
			size++;
			return size;
		}
	}
	
	public void print() {
		LinkedListNode node = head;
		
		while (node.next != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println(node.data);
	}
}
