package model;

public class LinkedListWSentinel {
	private ListNode nil;
	
	public LinkedListWSentinel() {
		nil = new ListNode(-1);
		nil.next = nil;
		nil.prev = nil;
	}
	
	public ListNode listSearch(int k) {
		ListNode x = nil.next;
		while (!x.equals(nil) && x.key != k) {
			x = x.next;
		}
		return x;
	}
	
	// Exercise 10.2-4: implement list search without checking for x equals nil
	public ListNode listSearch2(int k) {
		ListNode x = nil.next;
		while (x.key != k && x.key != -1) {
			x = x.next;
		}
		return x;
	}
	
	public void listInsert(ListNode x) {
		x.next = nil.next;
		nil.next.prev = x;
		nil.next = x;
		x.prev = nil;
	}
	
	public void listDelete(ListNode x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
	}
	
	@Override
	public String toString() {
		ListNode x = nil.next;
		if (x.equals(nil)) return "Empty";
		
		StringBuilder sb = new StringBuilder();
		while (!x.equals(nil)) {
			sb.append(x.key).append(", ");
			x = x.next;
		}
		
		return sb.toString();
	}
}
