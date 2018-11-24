package test;

import model.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStack {

    private Stack intStack;

    @Before
    public void setup() {
        intStack = new Stack(10);
    }

    @Test
    public void testStackIsEmpty() {
        assertTrue(intStack.isEmpty());
        intStack.push(10);
        assertFalse(intStack.isEmpty());
    }

    @Test (expected = StackOverflowError.class)
    public void testPushOverflow() {
        for (int i = 0; i < 10; i++) {
            intStack.push(i);
        }
        intStack.push(10);
    }

    @Test (expected = Error.class)
    public void testPopUnderflow() {
        intStack.pop();
    }

    @Test
    public void testPop() {
        intStack.push(10);
        intStack.push(12);
        assertEquals(12, intStack.pop());
    }
}
