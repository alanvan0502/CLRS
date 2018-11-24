package model;

public class Queue {
	private int[] arr;
	private int head;
	private int tail;
	
	// Exercise 10.1-3 (See TestQueue) and 10.1-4: Rewrite ENQUEUE and DEQUEUE to detect underflow and overflow of a queue
	public Queue(int size) {
		head = 0;
		tail = 0;
		arr = new int[size + 1];
	}
	
	public void enqueue(int x) throws Error {
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
	
	private boolean isNotFull() {
		if (tail != arr.length - 1 && tail + 1 != head) {
			return true;
		} else if (tail == arr.length - 1 && head != 0) {
			return true;
		}
		return false;
	}

	public int dequeue() throws Error {
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
	
	@Override
	public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(arr[head]);
        for (int i = head + 1; i < tail; i++) {
            result.append(" ").append(arr[i]);
        }
        return result.toString();
	}
}
