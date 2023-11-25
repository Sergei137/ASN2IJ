package tests;

import utilities.MyDLL;
import utilities.Iterator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MyDLLTests {

	// Integer list for testing
	private MyDLL<Integer> list;

	// Set up the list before each test
	@Before
	public void setUp() throws Exception {
		// Initialize the list before each test
		list = new MyDLL<Integer>();
	}

	// Tests for all DLL functions:
	@Test // size()
	public void testSize() {
		assertEquals(0, list.size()); // Test if size is 0
		list.add(1); // Add element 1 to list
		assertEquals(1, list.size()); // Test if size is 1
		list.add(2); // Add element 2 to list
		assertEquals(2, list.size()); // Test if size is 2
	}

	@Test
	public void testClear() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		assertNotNull(list.head); // Test if head is not null
		assertNotNull(list.tail); // Test if tail is not null
		list.clear(); // Clear list
		assertNull(list.head); // Test if head is null
		assertNull(list.tail); // Test if tail is null
	}

	@Test
	public void testAddAtIndex() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		list.add(1, 3); // Add element 3 at index 1
		assertEquals(3, list.size()); // Test if size is 3
		assertEquals(1, (int) list.get(0)); // Test if element at index 0 is 1
		assertEquals(3, (int) list.get(1)); // Test if element at index 1 is 3
		assertEquals(2, (int) list.get(2)); // Test if element at index 2 is 2
	}

	// Test adding an element at an out-of-bounds index, expecting an exception
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAtIndexOutOfBounds() {
		list.add(1, 3); // Add element 3 at index 1
	}

	@Test
	public void testAdd() {
		assertTrue(list.add(1)); // Add element 1 to list
		assertEquals(1, list.size()); // Test if size is 1
		assertEquals(1, (int) list.get(0)); // Test if element at index 0 is 1
	}

	@Test // addAll()
	public void testAddAll() {
		MyDLL<Integer> list2 = new MyDLL<Integer>(); // New MyDLL instance
		list2.add(1); // Add element 1 to list2
		list2.add(2); // Add element 2 to list2
		list.addAll(list2); // Add all elements from list2 to list
		assertEquals(2, list.size()); // Test if size is 2
		assertEquals(1, (int) list.get(0)); // Test if element at index 0 is 1
		assertEquals(2, (int) list.get(1)); // Test if element at index 1 is 2
	}

	@Test // get()
	public void testGet() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		assertEquals(1, (int) list.get(0)); // Test if element at index 0 is 1
		assertEquals(2, (int) list.get(1)); // Test if element at index 1 is 2
	}

	@Test // removeAtIndex()
	public void testRemoveAtIndex() {
	    list.add(1); // Add element 1 to list
	    list.add(2); // Add element 2 to list
	    list.add(3); // Add element 3 to list
	    assertEquals(3, list.size()); // Test if size is 3
	    int expected = list.remove(0); // Remove element at index 0
	    assertEquals(1, expected); // Test if removed element is 1
	    assertEquals(2, list.size()); // Test if size is 2
	    expected = list.remove(1); // Remove element at index 1
	    assertEquals(3, expected); // Test if removed element is 3
	}

	// Test removing an element at an out-of-bounds index, expecting an exception
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveAtIndexOutOfBounds() {
	    list.remove(0); // Remove element at index 0
	}

	@Test // removeByValue()
	public void testRemoveByValue() {
	    list.add(1); // Add element 1 to list
	    list.add(2); // Add element 2 to list
	    list.add(3); // Add element 3 to list
	    assertEquals(3, list.size()); // Test if size is 3
	    assertEquals(1, (int) list.remove((Integer) 1)); // Remove element 1
	    assertEquals(2, list.size()); // Test if size is 2
	    assertEquals(3, (int) list.remove((Integer) 3)); // Remove element 3
	    assertEquals(1, list.size()); // Test if size is 1
	}

	@Test // removeByValue() for removing a value that is not in the list
	public void testRemoveByValueNotFound() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		list.add(3); // Add element 3 to list
		assertEquals(3, list.size()); // Test if size is 3
		assertNull(list.remove((Integer) 4)); // Test returns null if value is not in list
		assertEquals(3, list.size()); // Test if size is 3
	}

	@Test // set()
	public void testSet() {
	    list.add(1); // Add element 1 to list
	    list.add(2); // Add element 2 to list
	    list.add(3); // Add element 3 to list
	    assertEquals(3, list.size()); // Test if size is 3
	    int expected = list.set(0, 4); // Set element at index 0 to 4
	    assertEquals(1, expected); // Test if set element is 1
	    assertEquals(4, (int) list.get(0)); // Test if element at index 0 is 4
	    assertEquals(3, list.size()); // Test if size is 3
	}

	// Test setting an element at an out-of-bounds index, expecting an exception
	@Test(expected = IndexOutOfBoundsException.class)
	public void testSetOutOfBounds() {
		list.set(0, 1);
	} // Set element at index 0 to 1

	@Test // isEmpty()
	public void testIsEmpty() {
		assertTrue(list.isEmpty()); // Test if list is empty
		list.add(1); // Add element 1 to list
		assertFalse(list.isEmpty()); // Test if list is not empty
	}

	@Test // contains()
	public void testContains() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		assertTrue(list.contains(1)); // Test if list contains element 1
		assertTrue(list.contains(2)); // Test if list contains element 2
		assertFalse(list.contains(3)); // Test if list does not contain element 3
	}

	@Test // indexOf()
	public void testToArrayWithInput() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		Integer[] array = new Integer[2]; // New array with size 2
		array = list.toArray(array); // Cast list to array
		Integer[] expected = { 1, 2 }; // New array with elements 1 and 2
		assertEquals(2, array.length); // Test if array length is 2
		assertEquals(1, (int) array[0]); // Test if element at index 0 is 1
		assertEquals(2, (int) array[1]); // Test if element at index 1 is 2
		assertArrayEquals(expected, array); // Test if array equals expected array
	}

	@Test // toArray()
	public void testToArray() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list
		Object[] array = list.toArray(); // Cast list to array
		Object[] expected = { 1, 2 }; // New array with elements 1 and 2
		assertEquals(2, array.length); // Test if array length is 2
		assertEquals(1, array[0]); // Test if element at index 0 is 1
		assertEquals(2, array[1]); // Test if element at index 1 is 2
		assertArrayEquals(expected, array); // Test if array equals expected array
	}

	@Test // toArrayEmptyList()
	public void testToArrayEmptyList() {
		Object[] array = list.toArray(); // Cast list to array
		Object[] expected = {}; // New empty array
		assertEquals(0, array.length); // Test if array length is 0
		assertArrayEquals(expected, array); // Test if array equals expected array
	}

	@Test // iterator()
	public void testIterator() {
		list.add(1); // Add element 1 to list
		list.add(2); // Add element 2 to list

		Iterator<Integer> iterator = list.iterator(); // New iterator

		assertTrue(iterator.hasNext()); // Test if iterator has next element
		assertEquals(1, (int) iterator.next()); // Test if next element is 1

		assertTrue(iterator.hasNext()); // Test if iterator has next element
		assertEquals(2, (int) iterator.next()); // Test if next element is 2

		assertFalse(iterator.hasNext()); // Test if iterator has no next element
	}
}