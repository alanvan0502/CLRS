package model;

// Exercise 10.1-1 - Illustrate the result of stack push and pop operations
public class Stack {
    // Rep: arr, inner array representation of stack
    //      top, pointer for top element (index of top element)
    private int[] arr;
    private int top;

    /**
     * Construct a new stack object
     * @param size, capacity of the new size
     */
    public Stack(int size) {
        arr = new int[size + 1];
        top = 0;
    }

    /**
     * Check if stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Push an element on the stack if there is space
     * @param x, element to be pushed to stack
     * @return none if element is pushed to the stack
     * @throws StackOverflowError if stack is full
     */
    public void push(int x) throws StackOverflowError {
        if (top == arr.length - 1)
            throw new StackOverflowError();
        else {
            top += 1;
            arr[top] = x;
        }
    }

    /**
     * Pop an element from the stack, modifies the stack
     * @return x, element at the top of the stack
     * @throws Error if stack is empty
     */
    public int pop() throws Error {
        if (this.isEmpty())
            throw new Error("StackUnderflow");
        else {
            top -= 1;
            return arr[top + 1];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(arr[1]);
        for (int i = 2; i <= top; i++) {
            result.append(" ").append(arr[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack(6);
        stack1.push(4);
        stack1.push(1);
        stack1.push(3);
        System.out.println(stack1);

        System.out.println(stack1.pop());
        stack1.push(8);
        System.out.println(stack1);

        System.out.println(stack1.pop());
    }
}
