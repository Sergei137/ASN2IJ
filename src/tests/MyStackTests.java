package tests;

import utilities.MyStack;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyStackTests {

    // MyStack constructor test for new MyStack instances
    @Test
    public void testConstructor() {
        MyStack stack = new MyStack(5); // New MyStack instance with capacity of 5
        assertEquals(5, stack.getCapacity()); // Test if capacity is 5
        assertTrue(stack.isEmpty()); // test if stack is empty
    }

    // getCapacity() test
    @Test
    public void testGetCapacity() {
        MyStack stack = new MyStack(10000); // New MyStack instance with capacity of 10000
        assertEquals(10000, stack.getCapacity()); // Test if capacity is 10000
    }

    // getSize() test
    @Test
    public void testGetSize() {
        MyStack stack = new MyStack(1); // New MyStack instance with capacity of 1
        stack.push(1); // Add element 1 to stack
        assertEquals(1, stack.getSize()); // Test if returned element is 1
    }

    // isEmpty() test
    @Test
    public void testIsEmpty() {
        MyStack stack = new MyStack(0); // New MyStack instance with capacity of 0
        assertTrue(stack.isEmpty()); // Test if stack is empty
    }

    // push() test for adding new elements to stack
    @Test
    public void testPush() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 3
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        assertEquals(3, stack.peek()); // Test if top element is 3
        assertEquals(3, stack.getSize()); // Test if stack size is 3
    }

    // peek() test should return top element of stack
    @Test
    public void testPeek() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 3
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        assertEquals(3, stack.peek()); // Test if top element is 3
    }

    // pop() test
    @Test
    public void testPop() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 3
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        assertEquals(3, stack.getSize()); // Test if stack size is 3 before pop
        stack.pop(); // Remove top element
        assertEquals(2, stack.getSize()); // Test if stack size is 2 after pop
        stack.pop(); // Remove top element
        assertEquals(1, stack.getSize()); // Test if stack size is 1 after pop
    }

    // clear() test should clear the whole stack
    @Test
    public void testClear() {
        MyStack stack = new MyStack(1); // New MyStack instance with capacity of 1
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        stack.clear(); // Clear the stack
        assertEquals(0, stack.getSize()); // Check stack size by checking the size after clear()
    }

    // equals() test
    @Test
    public void testEquals() {
        MyStack stack1 = new MyStack(1); // New MyStack instance with capacity of 1
        stack1.push(1); // Push element 1 to stack 1
        MyStack stack2 = new MyStack(1); // Another New MyStack instance with capacity of 1
        stack2.push(1); // Push element 1 to stack 2
        assertTrue(stack1.equals(stack2)); // Test if stack 1 is equal to stack 2
    }

    // toArray() test should have a length of 3
    @Test
    public void testToArray1() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 3
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        Object[] array = stack.toArray(); // Cast stack to array
        assertEquals(3, array.length); // Test if array length is 3
    }

    // toArray(arg) test
    @Test
    public void testToArray2() {
        MyStack<Integer> stack = new MyStack<>(5); // New MyStack instance with capacity of 1
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        stack.push(4); // Push element 4
        stack.push(5); // Push element 5

        Integer[] toHold = new Integer[5]; // Set the initial size to the expected size
        Integer[] returnedArray = stack.toArray(toHold); // Cast stack to array

        assertEquals(5, returnedArray.length); // Test if new array length is 5
        assertEquals(Integer.valueOf(1), returnedArray[0]); // Test if element 1 is at index 0
        assertEquals(Integer.valueOf(2), returnedArray[1]); // Test if element 2 is at index 1
        assertEquals(Integer.valueOf(3), returnedArray[2]); // Test if element 3 is at index 2
        assertEquals(Integer.valueOf(4), returnedArray[3]); // Test if element 4 is at index 3
        assertEquals(Integer.valueOf(5), returnedArray[4]); // Test if element 5 is at index 4
    }

    // Constains() test
    @Test
    public void testContains() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 1
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        assertTrue(stack.contains(1)); // Test if stack has element 1
    }

    // search() test should return the position of element from top of stack
    @Test
    public void testSearch() {
        MyStack stack = new MyStack(5); // New MyStack instance with capacity of 1
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        stack.push(4); // Push element 4
        stack.push(5); // Push element 5
        assertEquals(4, stack.search(2)); // Test the position of element 2 is form the top
    }

    // Iterator() tests next() and hasNext()
    @Test
    public void testIterator() {
        MyStack stack = new MyStack(3); // New MyStack instance with capacity of 1
        stack.push(1); // Push element 1
        stack.push(2); // Push element 2
        stack.push(3); // Push element 3
        assertEquals(1, stack.iterator().next()); // test next() should return element 1
        assertTrue(stack.iterator().hasNext()); // test hasNext should return boolean true
    }
}

