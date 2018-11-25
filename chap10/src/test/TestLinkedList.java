package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.LinkedList;
import model.ListNode;

public class TestLinkedList {
	private LinkedList list = new LinkedList();
	
	@Test
	public void testInsert() {
		list.listInsert(new ListNode(1));
		list.listInsert(new ListNode(2));
		assertTrue(list.toString().equals("2, 1, "));
	}
	
	@Test
	public void testDelete() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		list.listInsert(n3);
		list.listInsert(n2);
		list.listInsert(n1);
		assertTrue(list.toString().equals("1, 2, 3, "));
		
		list.listDelete(n2);
		assertTrue(list.toString().equals("1, 3, "));
	}
	
	@Test
	public void testSearch() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		list.listInsert(n3);
		list.listInsert(n2);
		list.listInsert(n1);
		
		assertTrue(list.listSearch(3).equals(n3));
		assertTrue(list.listSearch(4) == null);
	}
}
