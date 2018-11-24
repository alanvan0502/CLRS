package test;

import org.junit.Before;
import org.junit.Test;

import model.Queue;

public class TestQueue {
	private Queue Q;
	
	@Before
	public void setup() {
		Q = new Queue(5);
	}
	
	// Exercise 10.1-4
	@Test
	public void testEnqueueAndDequeue() {
		Q.enqueue(4);
		System.out.println(Q);
		Q.enqueue(1);
		Q.toString();
		System.out.println(Q);
		Q.enqueue(3);
		System.out.println(Q);
		Q.dequeue();
		System.out.println(Q);
		Q.enqueue(8);
		System.out.println(Q);
		Q.dequeue();
	}
	
	@Test (expected = Error.class)
	public void testEnqueueQueueOverFlow1() {
		for (int i = 0; i < 5; i++) {
			Q.enqueue(i);
		}
		System.out.println(Q);
		Q.enqueue(6);
	}
	
	@Test (expected = Error.class)
	public void testEnqueueQueueOverFlow2() {
		Q.enqueue(1);
		Q.enqueue(10);
		Q.dequeue();
		Q.enqueue(2);
		for (int i = 0; i < 3; i++) {
			Q.enqueue(i + 1);
		}
		System.out.println(Q);
		Q.enqueue(6);
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
