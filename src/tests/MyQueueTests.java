package tests;

import utilities.MyQueue;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyQueueTests {

    @Test
    public void testConstructor() {
        MyQueue queue = new MyQueue<>(10);
        assertEquals(10, queue.getCapacity());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testGetCapacity() {
        MyQueue queue = new MyQueue<>(10000);
        assertEquals(10000, queue.getCapacity());
    }

    @Test
    public void testGetSize() {
        MyQueue queue = new MyQueue<>(1);
        queue.enqueue(1);
        assertEquals(1, queue.getSize());
    }




}