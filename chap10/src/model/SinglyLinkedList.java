package model;

// Exercise 10.2-1 Implement a Singly Linked List
public class SinglyLinkedList {
	SingleListNode head;
	SingleListNode tail;
	
	public SinglyLinkedList() {
		
	}
	
	public void insert(SingleListNode x) {
		x.next = head;
		head = x;
		if (head.next == null) {
			tail = head;
		}
	}
	
	public void insertTail(SingleListNode x) {
		if (tail != null) {
			tail.next = x;
			tail = x;
		} else {
			head = x;
			tail = x;
		}
	}
	
	public void delete(SingleListNode x) {
		SingleListNode p = head;
		if (p == null) {
			return;
		}
		if (p.equals(x)) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
			return;
		}
		while (p.next != null) {
			if (p.next.equals(x)) {
				if (p.next.next == null) {
					tail = p;
				}
				p.next = p.next.next;
				return;
			} else {
				p = p.next;
			}
		}
	}
	

	public SingleListNode search(int key) {
		SingleListNode x = head;
		while (x != null && x.key != key) {
			x = x.next;
		}
		return x;
	}
	
	@Override
	public String toString() {
		SingleListNode x = head;
		if (x == null) return "Empty";
		
		StringBuilder sb = new StringBuilder();
		while (x != null) {
			sb.append(x.key).append(", ");
			x = x.next;
		}
		
		return sb.toString();
	}
}
