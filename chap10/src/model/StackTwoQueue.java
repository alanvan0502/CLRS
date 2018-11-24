package model;

// Exercise 10.1-7: Implement a stack using two Queues
// Push operation takes O(1) while pop operation takes O(n) as the activeQ
// has to pop all element from it

public class StackTwoQueue {
	private Queue q1;
	private Queue q2;

	public StackTwoQueue(int size) {
		q1 = new Queue(size);
		q2 = new Queue(size);
	}

	public void push(int x) {
		try {
			if (!q1.isEmpty())
				q1.enqueue(x);
			else
				q2.enqueue(x);
		} catch (Error e) {
			throw new Error("Stack overflow");
		}

	}

	public int pop() {
		try {
			Queue activeQ;
			Queue emptyQ;
			if (q1.isEmpty()) {
				activeQ = q2;
				emptyQ = q1;
			} else {
				activeQ = q1;
				emptyQ = q2;
			}

			while (activeQ.numElement() > 1) {
				int e = activeQ.dequeue();
				emptyQ.enqueue(e);
			}
			return activeQ.dequeue();
		} catch (Error e) {
			throw new Error("Stack underflow");
		}

	}

	public static void main(String[] args) {
		StackTwoQueue stack = new StackTwoQueue(5);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
	}
}
