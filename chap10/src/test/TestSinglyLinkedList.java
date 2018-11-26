package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.LinkedList;
import model.ListNode;
import model.SingleListNode;
import model.SinglyLinkedList;

public class TestSinglyLinkedList {
	private SinglyLinkedList list = new SinglyLinkedList();
	
	@Test
	public void testInsert1() {
		list.insert(new SingleListNode(1));
		list.insert(new SingleListNode(2));
		assertTrue(list.toString().equals("2, 1, "));
	}
	
	@Test
	public void testInsert2() {
		assertTrue(list.toString().equals("Empty"));
		list.insert(new SingleListNode(3));
		assertTrue(list.toString().equals("3, "));
	}
	
	@Test
	public void testDelete() {
		SingleListNode n1 = new SingleListNode(1);
		SingleListNode n2 = new SingleListNode(2);
		SingleListNode n3 = new SingleListNode(3);
		SingleListNode n4 = new SingleListNode(4);
		
		list.insert(n3);
		list.insert(n2);
		list.insert(n1);
		list.delete(n4);
		assertTrue(list.toString().equals("1, 2, 3, "));
		
		list.delete(n2);
		assertTrue(list.toString().equals("1, 3, "));
		
		list.delete(n3);
		assertTrue(list.toString().equals("1, "));
		
		list.delete(n1);
		assertTrue(list.toString().equals("Empty"));
	}
//	
//	@Test
//	public void testSearch() {
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		
//		list.listInsert(n3);
//		list.listInsert(n2);
//		list.listInsert(n1);
//		
//		assertTrue(list.listSearch(3).equals(n3));
//		assertTrue(list.listSearch(4) == null);
//	}
}
