package tests;

import utilities.Iterator;
import utilities.MyArrayList;
import utilities.ListADT;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public class MyArrayListTests{

    private ListADT<String> myList;

    @Before
    public void setUp(){
        //Initialise the list before each test
        myList = new MyArrayList<>();
    }

    @Test
    public void testSize(){

        // Test the size method after adding elements to the list
        assertEquals(0, myList.size());
        myList.add("Element 1");
        assertEquals(1, myList.size());
        myList.add("Element 2");
        assertEquals(2, myList.size());
    }

    @Test
    public void testClear(){

        // Test the clear method
        myList.add("Element 1");
        myList.add("Element 2");
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testAddAtIndex(){

        // Test adding an element at a specific index
        myList.add("Element1");
        myList.add("Element2");
        myList.add(1, "New Element");
        assertEquals("Element1", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("Element2", myList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds(){
        // Test adding an element at an out-of-bounds index, expecting an exception
        myList.add(1, "New Element");
    }

    @Test
    public void testAdd(){

        // Test the add method
        assertTrue(myList.add("Element 1"));
        assertEquals(1, myList.size());
        assertEquals("Element 1", myList.get(0));
    }

    @Test
    public void testAddAll(){

        // Test adding all elements from another list
        ListADT<String> toAdd = new MyArrayList<>();
        toAdd.add("Elem 1");
        toAdd.add("Elem 2");

        assertTrue(myList.addAll(toAdd));
        assertEquals(2, myList.size());
        assertEquals("Elem 1", myList.get(0));
        assertEquals("Elem 2", myList.get(1));
    }

    @Test
    public void testGet(){

        // Test the get method
        myList.add("Elem 1");
        myList.add("Elem 2");
        assertEquals("Elem 1", myList.get(0));
        assertEquals("Elem 2", myList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounds(){
        // Test getting an element from an empty list, expecting an exception
        myList.get(0);
    }

    @Test
    public void testRemoveAtIndex(){

        // Test removing an element at a specific index
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertEquals("Elem 1", myList.remove(0));
        assertEquals(1, myList.size());
        assertEquals("Elem 2", myList.remove(0));
        assertEquals(0, myList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds(){
        // Test getting an element at an out-of-bounds index, expecting an exception
        myList.get(0);
    }

    @Test
    public void testRemoveByValue(){

        // Test removing an element by its value
        myList.add("Elem 1");
        myList.add("Elem 2");

        String remove = myList.remove("Elem 1");

        assertNotNull(remove);
        assertEquals("Elem 1", remove);
        assertEquals(1, myList.size());
        assertEquals("Elem 2", myList.get(0));
    }

    @Test
    public void testRemoveByValueNotFound(){
        // Test removing a value that is not present in the list
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertNull(myList.remove("Not Found "));
        assertEquals(2, myList.size());
    }

    @Test
    public void testSet(){
        // Test setting an element at a specific index
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertEquals("Elem 1", myList.set(0, "New Element"));
        assertEquals("New Element", myList.get(0));
        assertEquals("Elem 2", myList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounds() {
        // Test setting an element at an out-of-bounds index, expecting an exception
        myList.set(0, "New Element");
    }

    @Test
    public void testIsEmpty(){
        // Test the isEmpty method
        assertTrue(myList.isEmpty());

        myList.add("Elem 1");

        assertFalse(myList.isEmpty());
    }

    @Test
    public void testContains(){
        // Test the contains method
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertTrue(myList.contains("Elem 1"));
        assertFalse(myList.contains("New Element"));
    }

    @Test
    public void testToArray(){
        // Test converting the list to an array
        myList.add("Elem 1");
        myList.add("Elem 2");

        String[] array = myList.toArray(new String[myList.size()]);
        assertArrayEquals(new String[]{"Elem 1", "Elem 2"}, array);
    }

    @Test
    public void testToArrayEmptyList(){
        // Test converting an empty list to an array
        String[] array = myList.toArray(new String[0]);
        assertArrayEquals(new String[]{}, array);
    }

    @Test
    public void testIterator(){
        // Test the iterator method
        myList.add("Elem 1");
        myList.add("Elem 2");

        Iterator<String> iterator = myList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Elem 1", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Elem 2", iterator.next());

        assertFalse(iterator.hasNext());
    }
}