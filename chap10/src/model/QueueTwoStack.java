package model;

// Exercise 10.1-6: Show how to implement a queue using two stacks
public class QueueTwoStack {
	private Stack A;
	private Stack B;
	
	public QueueTwoStack(int size) {
		A = new Stack(size);
		B = new Stack(size);
	}
	
	public void enqueue(int x) {
		B.push(x);
	}

	public int dequeue() {
		if (A.isEmpty()) {
			while (!B.isEmpty()) {
				int b = B.pop();
				A.push(b);
			}
		}
		return A.pop();
	}
	
	public static void main(String[] args) {
		QueueTwoStack q = new QueueTwoStack(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println(q.dequeue());
		q.enqueue(4);
		System.out.println(q.dequeue());
	}
}
