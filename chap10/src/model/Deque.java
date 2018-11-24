package model;

public class Deque {

	private int[] arr;
	private int head;
	private int tail;
	
	// Exercise 10.1-5 Implement Deque with 4 operations to insert and delete at beginning and end of the queue
	public Deque(int size) {
		head = 0;
		tail = 0;
		arr = new int[size + 1];
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public void insertLast(int x) throws Error {
		if (isNotFull()) {
			arr[tail] = x;
			if (tail == arr.length - 1) {
				tail = 0;
			} else {
				tail = tail + 1;
			}
		} else {
			throw new Error("Queue overflow");
		}
	}
	
	public void insertFront(int x) throws Error {
		if (isNotFull()) {
			if (head == 0) {
				head = arr.length - 1;
			} else {
				head = head - 1;
			}
			arr[head] = x;
		} else {
			throw new Error("Queue overflow");
		}
	}
	
	private boolean isNotFull() {
		if (tail != arr.length - 1 && tail + 1 != head) {
			return true;
		} else if (tail == arr.length - 1 && head != 0) {
			return true;
		}
		return false;
	}

	public int getFront() throws Error {
		if (head != tail) {
			int x = arr[head];
			if (head == arr.length - 1) {
				head = 0;
			} else {
				head = head + 1;
			}
			return x;
		} else {
			throw new Error("Queue underflow");
		}
	}
	
	public int getLast() throws Error {
		if (head != tail) {
			int x;
			if (tail != 0) {
				tail = tail - 1;
				x = arr[tail];
			} else {
				tail = arr.length - 1;
				x = arr[tail];
			}
			return x;
		} else {
			throw new Error("Queue underflow");
		}
	}
}
