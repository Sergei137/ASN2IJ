package tests;

import utilities.MyQueue;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyQueueTests {

    @Test // MyQueue constructor for new MyQueue instances
    public void testConstructor() {
        MyQueue queue = new MyQueue<>(10); // New MyQueue instance with capacity of 10
        assertEquals(10, queue.getCapacity()); // Test if capacity is 10
        assertTrue(queue.isEmpty()); // Test returns true if queue is empty
    }

    @Test // getCapacity()
    public void testGetCapacity() {
        MyQueue queue = new MyQueue<>(10000); // New MyQueue instance with capacity of 10000
        assertEquals(10000, queue.getCapacity()); // Test if capacity is 10000
    }

    @Test // getSize()
    public void testGetSize() {
        //MyQueue queue = new MyQueue<>(1);
        MyQueue<Integer> queue = new MyQueue<>(1); // New MyQueue instance with capacity of 1
        queue.enqueue(1); // Add element 1 to queue
        assertEquals(1, queue.getSize()); // Test if returned element is 1
    }

    @Test // enqueue() for adding new elements to queue
    public void testEnqueue() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        assertEquals(3, queue.getSize()); // Test if queue size is 3
    }

    @Test // dequeue() should return first element of queue
    public void testDequeue() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        assertEquals(1, queue.dequeue()); // Test if dequeued element is 1
        assertEquals(2, queue.dequeue()); // Test if dequeued element is 2
        assertEquals(3, queue.dequeue()); // Test if dequeued element is 3
    }

    @Test // dequeueAll()
    public void testDequeueAll() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        queue.dequeueAll(); // Dequeue all elements
        assertTrue(queue.isEmpty()); // Test returns true if queue is empty
    }

    @Test // peek() should return first element of queue
    public void testPeek() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        assertEquals(1, queue.peek()); // Test if first element is 1
        assertEquals(2, queue.peek()); // Test if first element is 2
        assertEquals(3, queue.peek()); // Test if first element is 2
    }

    @Test //  isEmpty()
    public void testIsEmpty() {
        MyQueue queue = new MyQueue<>(0); // New MyQueue instance with capacity of 0
        assertTrue(queue.isEmpty()); // Test if queue is empty
    }

    @Test // isFull()
    public void testIsFull() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        assertTrue(queue.isFull()); // Test returns true if queue is full
    }

    @Test // equals()
    public void testEquals() {
        MyQueue queue1 = new MyQueue<>(3); // New MyQueue instance (1) with capacity of 3
        queue1.enqueue(1); // Enqueue element 1
        queue1.enqueue(2); // Enqueue element 2
        queue1.enqueue(3); // Enqueue element 3
        MyQueue queue2 = new MyQueue<>(3); // New MyQueue instance (2) with capacity of 3
        queue2.enqueue(1); // Enqueue element 1
        queue2.enqueue(2); // Enqueue element 2
        queue2.enqueue(3); // Enqueue element 3
        assertTrue(queue1.equals(queue2)); // Test returns true if queue1 equals queue2
    }

    @Test // equals() should return false if queue1 does not equal queue2
    public void testToArray1() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3

        Object[] array = queue.toArray(); // Create new array and assign it to queue.toArray()

        assertEquals(1, array[0]); // Test if first element is 1
        assertEquals(2, array[1]); // Test if second element is 2
        assertEquals(3, array[2]); // Test if third element is 3
    }

    @Test // toArray()
    public void testToArray2() {
        MyQueue<Integer> queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3

        Integer[] toHold = new Integer[5]; // Create new array with capacity of 5
        Integer[] returnedArray = queue.toArray(toHold); // Create new array and assign it to queue.toArray()

        assertEquals(5, returnedArray.length); // Test if returned array length is 5
        assertEquals(Integer.valueOf(1), returnedArray[0]); // Test if first element is 1
        assertEquals(Integer.valueOf(2), returnedArray[1]); // Test if second element is 2
        assertEquals(Integer.valueOf(3), returnedArray[2]); // Test if third element is 3
        assertNull(returnedArray[3]); // Test if fourth element is null
        assertNull(returnedArray[4]); // Test if fifth element is null
    }

    @Test // toArray()
    public void testIterator() {
        MyQueue queue = new MyQueue<>(3); // New MyQueue instance with capacity of 3
        queue.enqueue(1); // Enqueue element 1
        queue.enqueue(2); // Enqueue element 2
        queue.enqueue(3); // Enqueue element 3
        assertEquals(1, queue.iterator().next()); // Test if first element is 1
        assertTrue(queue.iterator().hasNext()); // Test returns true if queue has next element
    }
}