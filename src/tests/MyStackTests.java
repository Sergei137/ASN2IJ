package tests;

import utilities.MyStack;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class MyStackTests {
    @Test
    public void testConstructor1() {
        MyStack stack = new MyStack();
        assertEquals(10000, stack.getCapacity());
    }

    @Test
    public void testConstructor2() {
        MyStack stack = new MyStack(5);
        assertEquals(5, stack.getCapacity());
    }

    @Test
    public void testGetCapacity() {
        MyStack stack = new MyStack();
        assertEquals(10000, stack.getCapacity());
    }

    @Test
    public void testGetSize() {
        MyStack stack = new MyStack();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testIsEmpty() {
        MyStack stack = new MyStack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void testPush() {
        MyStack stack = new MyStack();
        stack.push(1);
        assertEquals(1, stack.peek());
    }

    @Test
    public void testPeek() {
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
    public void testSize() {
        MyStack stack = new MyStack();
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    public void testClear() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.clear();
        assertEquals(0, stack.getSize());
    }

    @Test
    public void testEquals() {
        MyStack stack = new MyStack();
        MyStack stack2 = new MyStack();
        assertEquals(true, stack.equals(stack2));
    }

    @Test
    public void testToArray1() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Object[] array = stack.toArray();
        assertEquals(3, array.length);
    }

    @Test
    public void testToArray2() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Object[] array = stack.toArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test
    public void testContains() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(true, stack.contains(1));
    }

    @Test
    public void testSearch() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        assertEquals(4, stack.search(2));
    }

    @Test
    public void testIterator() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.iterator().next());
    }
}

