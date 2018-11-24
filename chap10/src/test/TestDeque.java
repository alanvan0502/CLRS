package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Deque;

public class TestDeque {
	private Deque D;
	
	@Before
	public void setup() {
		D = new Deque(5);
	}
	
	// Exercise 10.1-4
//	@Test
//	public void testInsertLastGetFront() {
//		D.insertLast(4);
//		System.out.println(D);
//		D.insertLast(1);
//		System.out.println(D);
//		D.insertLast(3);
//		System.out.println(D);
//		int d1 = D.getFront();
//		System.out.println(d1);
//		System.out.println(D);
//		D.insertLast(8);
//		System.out.println(D);
//		D.getFront();
//	}
	
	@Test
	public void testInsertGet() {
		D.insertFront(4);
		D.insertFront(1);
		D.insertFront(3);
		int d1 = D.getLast();
		assertTrue(d1 == 4);
		D.insertFront(8);
		int d2 = D.getLast();
		assertTrue(d2 == 1);
		D.insertLast(7);
		int d3 = D.getLast();
		assertTrue(d3 == 7);
		int d4 = D.getLast();
		assertTrue(d4 == 3);
	}
	
	@Test (expected = Error.class)
	public void testEnqueueQueueOverFlow1() {
		for (int i = 0; i < 5; i++) {
			D.insertFront(i);
		}
		D.insertFront(1);
	}
	
	@Test (expected = Error.class)
	public void testEnqueueQueueOverFlow2() {
		for (int i = 0; i < 5; i++) {
			D.insertFront(i);
		}
		D.insertLast(1);
	}

	@Test (expected = Error.class)
	public void testEnqueueQueueOverFlow3() {
		D.insertFront(1);
		D.insertLast(10);
		D.getFront();
		D.insertLast(2);
		for (int i = 0; i < 3; i++) {
			D.insertFront(i + 1);
		}
		D.insertFront(6);
	}

	@Test (expected = Error.class)
	public void testDequeueUnderflow() {
		D.insertFront(1);
		D.insertFront(2);
		D.getLast();
		D.getLast();
		D.getLast();
	}
}