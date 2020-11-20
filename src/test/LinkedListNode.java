package test;

public class LinkedListNode {
	int data;
	LinkedListNode next;
	
	public LinkedListNode() {};
	
	public LinkedListNode(int d) {
		data = d;
		next = null;
	}
	
	public LinkedListNode(int d, LinkedListNode n) {
		data = d;
		next = n;
	}
}
