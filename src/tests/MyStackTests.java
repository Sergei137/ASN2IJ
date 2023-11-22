package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utilities.MyStack;

public class MyStackTests {
    @Test
    public void testPush() {
        MyStack stack = new MyStack();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.pop();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testIsEmpty() {
        MyStack stack = new MyStack();
        assertEquals(true, stack.isEmpty());
    }
}

