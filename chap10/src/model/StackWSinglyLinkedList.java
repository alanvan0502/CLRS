package model;

// Exercise 10.2-2: Implement a stack using a singly linked list L
public class StackWSinglyLinkedList {
	private SinglyLinkedList l = new SinglyLinkedList();
	private SingleListNode top = null;
	
	public StackWSinglyLinkedList() {
		
	}
	
	public void push(int key) {
		SingleListNode x = new SingleListNode(key);
		top = x;
		l.insert(x);
	}
	
	public int pop() throws Error {
		if (top == null) {
			throw new Error("Stack underflow");
		} else {
			int key = top.key;
			l.delete(top);
			top = l.head;
			return key;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
