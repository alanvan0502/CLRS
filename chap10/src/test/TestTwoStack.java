package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.TwoStack;

public class TestTwoStack {
    private TwoStack twoIntStack;

    @Before
    public void setup() {
        twoIntStack = new TwoStack(10);
    }

    @Test
    public void testStackIsEmpty() {
        assertTrue(twoIntStack.isStack1Empty());
        twoIntStack.push1(10);
        assertFalse(twoIntStack.isStack1Empty());
        
        assertTrue(twoIntStack.isStack2Empty());
        twoIntStack.push2(5);
        assertFalse(twoIntStack.isStack2Empty());
    }
    
    @Test
    public void testPushAndPop() {
    	for (int i = 0; i < 6; i++) {
            twoIntStack.push1(i);
        }
    	twoIntStack.pop1();
    	twoIntStack.push2(7);
    	twoIntStack.push2(8);
    	twoIntStack.pop2();
    	twoIntStack.push2(9);
    	assertTrue(twoIntStack.stack1ToString().equals("0 1 2 3 4"));
    	assertTrue(twoIntStack.stack2ToString().equals("7 9"));
    }

    @Test (expected = StackOverflowError.class)
    public void testPushOverflow() {
        for (int i = 0; i < 6; i++) {
            twoIntStack.push1(i);
        }
        for (int i = 0; i < 5; i++) {
        	twoIntStack.push2(i);
        }
    }

    @Test (expected = Error.class)
    public void testPop1Underflow() {
        twoIntStack.pop1();
    }
    
    @Test (expected = Error.class)
    public void testPop2Underflow() {
        twoIntStack.pop2();
    }
}
