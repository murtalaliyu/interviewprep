package test;

public class Queue {
	int capacity = 10;
	int queue[] = new int[capacity];
	int size;
	int front;
	int rear;
	
	public void enQueue(int data) {
		if (size() == capacity) {
			expand();
		}
		queue[rear] = data;
		rear = (rear+1) % 5;
		size++;
	}

	public int deQeueu() {
		if (!isEmpty()) {
			int data = queue[front];
			front = (front+1) % 5;
			size--;
			
			return data;
		}
		System.out.println("Queue is empty.");
		return 0;
	}
	
	private void expand() {
		int length = size();
		int[] newQueue = new int[capacity*2];
		System.arraycopy(queue, 0, newQueue, 0, length);
		queue = newQueue;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void show() {
		System.out.print("Elements: ");
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(front+i)%5] + " ");
		}
		System.out.println();
	}
}
