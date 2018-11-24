package model;

// Exercise 10.1-2 - Implement two stacks in one array A[1..n] in such a way
// that neither stack overflows unless the total number of elements in both stack
// together is n
public class TwoStack {

    private int arr[];
    private int size;
    private int top1;
    private int top2;
    private int start1;
    private int start2;

    public TwoStack(int size) {
        this.size = size;
        arr = new int[size * 2 + 2];
        top1 = 0;
        top2 = size + 1;

        start1 = 0;
        start2 = size + 1;
    }

    private boolean reachedCapacity() {
        return (top1 - start1) + (top2 - start2) >= size;
    }

    public boolean isStack1Empty() {
        return top1 == 0;
    }

    public boolean isStack2Empty() {
        return top2 == size + 1;
    }

    public void push1(int x1) throws StackOverflowError {
        if (reachedCapacity()) {
            throw new StackOverflowError();
        } else {
            top1++;
            arr[top1] = x1;
        }
    }

    public void push2(int x2) throws StackOverflowError {
    	if (reachedCapacity()) {
    		throw new StackOverflowError();
    	} else {
    		top2++;
    		arr[top2] = x2;
    	}
    }

    public int pop1() throws Error {
		if (top1 == 0) {
			throw new Error("StackUnderflow");
		} else {
			top1--;
			return arr[top1 + 1];
		}
    }
    
    public int pop2() throws Error {
		if (top2 == size + 1) {
			throw new Error("StackUnderflow");
		} else {
			top2--;
			return arr[top2 + 1];
		}
    }
    
    public String stack1ToString() {
        StringBuilder result = new StringBuilder();
        result.append(arr[1]);
        for (int i = 2; i <= top1; i++) {
            result.append(" ").append(arr[i]);
        }
        return result.toString();
    }
    
    public String stack2ToString() {
        StringBuilder result = new StringBuilder();
        result.append(arr[size+2]);
        for (int i = size+3; i <= top2; i++) {
            result.append(" ").append(arr[i]);
        }
        return result.toString();
    }
}
