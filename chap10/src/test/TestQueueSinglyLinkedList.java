package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Queue;
import model.QueueSinglyLinkedList;

public class TestQueueSinglyLinkedList {
	private QueueSinglyLinkedList Q;
	
	@Before
	public void setup() {
		Q = new QueueSinglyLinkedList();
	}
	
	@Test
	public void testEnqueueAndDequeue() {
		Q.enqueue(4);
		Q.enqueue(1);
		Q.enqueue(3);
		int e1 = Q.dequeue();
		assertTrue(e1 == 4);
		Q.enqueue(8);
		int e2 = Q.dequeue();
		assertTrue(e2 == 1);
	}
	
	@Test (expected = Error.class)
	public void testDequeueUnderflow() {
		Q.enqueue(1);
		Q.enqueue(2);
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
	}
}
