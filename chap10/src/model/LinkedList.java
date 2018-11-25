package model;

public class LinkedList {
	private ListNode head;
	
	public LinkedList() {
	}
	
	public ListNode listSearch(int k) {
		ListNode x = head;
		while (x != null && x.key != k) {
			x = x.next;
		}
		return x;
	}
	
	public void listInsert(ListNode x) {
		x.next = head;
		if (head != null)
			head.prev = x;
		head = x;
		x.prev = null;
	}
	
	public void listDelete(ListNode x) {
		if (x.prev != null)
			x.prev.next = x.next;
		else
			head = x.next;
		if (x.next != null) {
			x.next.prev = x.prev;
		}
	}
	
	@Override
	public String toString() {
		ListNode x = head;
		if (x == null) return "Empty";
		
		StringBuilder sb = new StringBuilder();
		while (x != null) {
			sb.append(x.key).append(", ");
			x = x.next;
		}
		
		return sb.toString();
	}
}
