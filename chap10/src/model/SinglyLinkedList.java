package model;

public class SinglyLinkedList {
	private SingleListNode head;
	
	public SinglyLinkedList() {
		
	}
	
	public void insert(SingleListNode x) {
		x.next = head;
		head = x;
	}
	
	public void delete(SingleListNode x) {
		SingleListNode p = head;
		if (p == null) {
			return;
		}
		if (p.equals(x)) {
			head = null;
			return;
		}
		while (p.next != null) {
			if (p.next.equals(x)) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
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
