package model;

public class QueueSinglyLinkedList {
	SinglyLinkedList l;
	
	public QueueSinglyLinkedList() {
		l = new SinglyLinkedList();
	}
	
	public void enqueue(int key) {
		l.insertTail(new SingleListNode(key));
	}
	
	public int dequeue() throws Error {
		if (this.isEmpty()) {
			throw new Error("Queue underflow");
		}
		SingleListNode x = l.head;
		l.delete(x);
		return x.key;
	}
	
	public boolean isEmpty() {
		return l.head == null;
	}
}
