package tests;

import utilities.MyStack;

import org.junit.Test;
import static org.junit.Assert.*;

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
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPeek() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek());
    }

    @Test
    public void testPop() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        assertEquals(2, stack.getSize());
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
        assertTrue(stack.equals(stack2));
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
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Integer[] toHold = new Integer[5]; // Set the initial size to the expected size
        Integer[] returnedArray = stack.toArray(toHold);

        assertEquals(5, returnedArray.length);
        assertEquals(Integer.valueOf(1), returnedArray[0]);
        assertEquals(Integer.valueOf(2), returnedArray[1]);
        assertEquals(Integer.valueOf(3), returnedArray[2]);
        assertEquals(Integer.valueOf(4), returnedArray[3]);
        assertEquals(Integer.valueOf(5), returnedArray[4]);
    }

    @Test
    public void testContains() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(stack.contains(1));
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

