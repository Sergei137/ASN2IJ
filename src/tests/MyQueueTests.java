package tests;

import utilities.MyQueue;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyQueueTests {

    @Test //
    public void testConstructor() {
        MyQueue queue = new MyQueue<>(10);
        assertEquals(10, queue.getCapacity());
        assertTrue(queue.isEmpty());
    }

    @Test //
    public void testGetCapacity() {
        MyQueue queue = new MyQueue<>(10000);
        assertEquals(10000, queue.getCapacity());
    }

    @Test //
    public void testGetSize() {
        //MyQueue queue = new MyQueue<>(1);
        MyQueue<Integer> queue = new MyQueue<>(1);
        queue.enqueue(1);
        assertEquals(1, queue.getSize());
    }

    @Test //
    public void testEnqueue() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.getSize());
    }

    @Test //
    public void testDequeue() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test //
    public void testDequeueAll() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeueAll();
        assertTrue(queue.isEmpty());
    }

    @Test //
    public void testPeek() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.peek());
    }

    @Test //
    public void testIsEmpty() {
        MyQueue queue = new MyQueue<>(0);
        assertTrue(queue.isEmpty());
    }

    @Test //
    public void testIsFull() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertTrue(queue.isFull());
    }

    @Test //
    public void testEquals() {
        MyQueue queue1 = new MyQueue<>(3);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        MyQueue queue2 = new MyQueue<>(3);
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        assertTrue(queue1.equals(queue2));
    }

    @Test //
    public void testToArray1() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Object[] array = queue.toArray();

        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
    }

    @Test //
    public void testToArray2() {
        MyQueue<Integer> queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Integer[] toHold = new Integer[5];
        Integer[] returnedArray = queue.toArray(toHold);

        assertEquals(5, returnedArray.length);
        assertEquals(Integer.valueOf(1), returnedArray[0]);
        assertEquals(Integer.valueOf(2), returnedArray[1]);
        assertEquals(Integer.valueOf(3), returnedArray[2]);
        assertNull(returnedArray[3]);
        assertNull(returnedArray[4]);
    }

    @Test //
    public void testIterator() {
        MyQueue queue = new MyQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.iterator().next());
        assertTrue(queue.iterator().hasNext());
    }
}