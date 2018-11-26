package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import model.StackWSinglyLinkedList;

public class TestStackWSinglyLinkedList {
    private StackWSinglyLinkedList intStack;

    @Before
    public void setup() {
        intStack = new StackWSinglyLinkedList();
    }

    @Test
    public void testStackIsEmpty() {
        assertTrue(intStack.isEmpty());
        intStack.push(10);
        assertFalse(intStack.isEmpty());
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
        assertEquals(10, intStack.pop());
    }
}
