package test;

/*
 * Linked List Questions
 */

public class linked_list_q {

	/**
	 * FUNTIONAL
	 * 
	 * Given a singly linked list, find the middle of the linked list. 
	 * If there are even nodes, then there would be two middle nodes, we need to print the second middle element.
	 * 
	 * This solution returns the middle of a linked list by using 2 pointers.
	 * 
	 * - Alternatively, we could first traverse the entire linked list to get the size, 
	 * 		then traverse again up to size/2 and get the last node (less efficient).
	 */
	public static LinkedListNode getMiddle(LinkedListNode head) {
		if (head == null) {
			return null;
		}
		LinkedListNode slowPointer = head, fastPointer = head;
		
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer;
	}
	
	/**
	 * FUNCTIONAL
	 * Loop in a linked list means the last node does not point to the null, instead it points to some node in the list. 

		Approach 1: Using Fast and Slow pointers. This is a very efficient approach to detect a loop in a linked list.
		Step 1: Let’s take two pointers slow and fast.
		Step 2: Initialize both pointers slow = head and fast = head.next.next.
		Step 3: Navigate both pointers, slow pointer moves one node at a time but fast pointer moves two nodes a time.
		Step 4: If both pointers meet at some point, we have found the loop.
		Step 5: Now find the loop length
		Step 6: At the point where both pointers have met, stop one pointer and keep moving the another one
		Step 7: When another pointer meets the first pointer, stop.
		Step 8: Keep counting number of hops, that will your loop length
		
		Approach 2: Using Hashing
		Navigate the linked list and put each node to the HashSet if the node is not present in the HashSet if node is present in the HashSet that means the given singly linked list has a loop.		
	 */
	static int loopLength = 0;
	static int nodeAtRemoval = 0;
	public static boolean detectLoop(LinkedListNode head, boolean remove) {
		if (head == null) {
			return false;
		}
		LinkedListNode slowPointer = head, fastPointer = head.next.next;
		
		while (fastPointer != null && fastPointer.next != null) {
			if (slowPointer == fastPointer) {
				loopLength = loopLength(slowPointer, fastPointer);
				if (remove) nodeAtRemoval = removeLoop(head, fastPointer).data;
				return true;
			} else {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
		}
		
		return false;
	}
	/**
	 * FUNCTIONAL - Helper method: find length of the loop in detectLoop function
	 */
	private static int loopLength(LinkedListNode slowPointer, LinkedListNode fastPointer) {
		fastPointer = fastPointer.next;
		int length = 1;
		
		while (slowPointer != fastPointer) {
			length++;
			fastPointer = fastPointer.next;
		}
		
		return length;
	}
	/**
	 * FUNCTIONAL - Helper method: remove loop in a linked list
	 */
	public static LinkedListNode removeLoop(LinkedListNode head, LinkedListNode meetingNode) {
		LinkedListNode prev = null;
		LinkedListNode junction = meetingNode;
		
		// get prev (node whose next will point to null)
		while (meetingNode != head) {
			prev = meetingNode;
			meetingNode = meetingNode.next;
			
			if (meetingNode == junction) {
				head = head.next;
			}
		}
		return prev;
	}
	
	/**
	 * In Progress
	 * 
	 * Given a linked list where every node represents a linked list and contains two pointers of its type:
	 * (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
	 * (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
	 * All linked lists are sorted. 
	 * e.g.,
	 * 5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45
     *  
	 * Write a function flatten() to flatten the lists into a single linked list. 
	 * The flattened linked list should also be sorted. For example, 
	 * for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
	 */
	public static LinkedListNode flatten(LinkedListNode head) {
		
	}

}
