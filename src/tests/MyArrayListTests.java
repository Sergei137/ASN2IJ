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
        assertEquals(0, myList.size());
        myList.add("Element 1");
        assertEquals(1, myList.size());
        myList.add("Element 2");
        assertEquals(2, myList.size());
    }

    @Test
    public void testClear(){
        myList.add("Element 1");
        myList.add("Element 2");
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testAddAtIndex(){

        myList.add("Element1");
        myList.add("Element2");
        myList.add(1, "New Element");
        assertEquals("Element1", myList.get(0));
        assertEquals("New Element", myList.get(1));
        assertEquals("Element2", myList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAtIndexOutOfBounds(){
        myList.add(1, "New Element");
    }

    @Test
    public void testAdd(){
        assertTrue(myList.add("Element 1"));
        assertEquals(1, myList.size());
        assertEquals("Element 1", myList.get(0));
    }

    @Test
    public void testAddAll(){
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
        myList.add("Elem 1");
        myList.add("Elem 2");
        assertEquals("Elem 1", myList.get(0));
        assertEquals("Elem 2", myList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBounds(){
        myList.get(0);
    }

    @Test
    public void testRemoveAtIndex(){
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertEquals("Elem 1", myList.remove(0));
        assertEquals(1, myList.size());
        assertEquals("Elem 2", myList.remove(0));
        assertEquals(0, myList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds(){
        myList.get(0);
    }

    @Test
    public void testRemoveByValue(){
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
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertNull(myList.remove("Not Found "));
        assertEquals(2, myList.size());
    }

    @Test
    public void testSet(){
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertEquals("Elem 1", myList.set(0, "New Element"));
        assertEquals("New Element", myList.get(0));
        assertEquals("Elem 2", myList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutOfBounds() {
        myList.set(0, "New Element");
    }

    @Test
    public void testIsEmpty(){
        assertTrue(myList.isEmpty());

        myList.add("Elem 1");

        assertFalse(myList.isEmpty());
    }

    @Test
    public void testContains(){
        myList.add("Elem 1");
        myList.add("Elem 2");

        assertTrue(myList.contains("Elem 1"));
        assertFalse(myList.contains("New Element"));
    }

    @Test
    public void testToArray(){
        myList.add("Elem 1");
        myList.add("Elem 2");

        String[] array = myList.toArray(new String[myList.size()]);
        assertArrayEquals(new String[]{"Elem 1", "Elem 2"}, array);
    }

    @Test
    public void testToArrayEmptyList(){
        String[] array = myList.toArray(new String[0]);
        assertArrayEquals(new String[]{}, array);
    }

    @Test
    public void testIterator(){
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