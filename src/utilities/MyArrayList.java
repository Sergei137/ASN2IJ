package utilities;


import java.util.NoSuchElementException;





// Represents a dynamic array-based implementation of ListADT interface

public class MyArrayList<E> implements ListADT<E>{

    // Default capacity of the array
    private static final int DEFAULT_CAPACITY = 10;

    // Internal array to store elements
    private Object[] array;

    // Current size of the list
    private int size;

    // Default constructor initializes the array with the default capacity and sets size to 0
    public MyArrayList(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Returns the current size of the list
    @Override
    public int size(){
        return size;
    }

    // Clears the list by setting the size to 0
    @Override
    public void clear(){
        size = 0;
    }

    // Adds an element at the specified index, shifting subsequent elements to the right
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException{
        // Check for null element
        if(toAdd == null){
            throw new NullPointerException("Element to add cannot be null");
        }

        // Check for valid index range
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Chosen index is out of range");
        }

        // Ensure capacity for the new element
        ensureCapacity(size + 1);

        // Shift elements to the right to make space for the new element
        for(int i = size - 1; i >= index; i--){
            array[i + 1] = array[i];
        }

        // Insert the new element at the specified index
        array[index] = toAdd;
        size++;
        return true;

    }


    // Adds an element to the end of the list
    @Override
    public boolean add(E toAdd) throws NullPointerException{
        // Check for null element
        if(toAdd == null){
            throw new NullPointerException("The element you want to add can't be null");
        }

        // Ensure capacity for the new element
        ensureCapacity(size + 1);

        // Add the new element at the end of the list
        array[size] = toAdd;
        size++;
        return true;
    }

    // Adds all elements from the specified list to the end of this list
    @Override
    public boolean addAll(ListADT <? extends E> toAdd) throws NullPointerException{
        // Check for null list
        if (toAdd == null){
            throw new NullPointerException("The list can't be null");
        }

        // Ensure capacity for the new elements
        ensureCapacity(size + toAdd.size());

        // Iterate through the elements of the specified list and add them to this list
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }

        return true;
    }


    // Returns the element at the specified index
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException{
        // Check for valid index range
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Entered index out of range");
        }

        // Return the element at the specified index
        return (E) array[index];
    }

    // Removes the element at the specified index, shifting subsequent elements to the left
    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) throws IndexOutOfBoundsException{
        // Check for valid index range
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Entered index is out of range");
        }

        // Retrieve the element to be removed
        E removedElement = (E) array[index];

        // Shift elements to the left to fill the gap
        System.arraycopy(array, index+1, array, index, size - index - 1);

        // Set the last element to null and decrement the size
        array[size - 1] = null;
        size --;

        return removedElement;
    }

    // Removes the first occurrence of the specified element from the list
    @Override
    public E remove (E toRemove) throws NullPointerException{
        // Check for null element
        if(toRemove == null){
            throw new NullPointerException("The element can't be null");
        }

        // Iterate through the list to find and remove the specified element
        for(int i = 0; i < size; i++){
            if(toRemove.equals(array[i])){
                return remove(i);
            }
        }

        // Return null if the element was not found
        return null;
    }

    // Replaces the element at the specified index with the specified element
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException{
        // Check for null element
        if(toChange == null){
            throw new NullPointerException("The element can't be null");
        }

        // Check for valid index range
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // Retrieve the previous element, replace it, and return the previous element
        E previousElement = get(index);
        array[index] = toChange;
        return previousElement;
    }

    // Checks if the list is empty
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    // Checks if the list contains the specified element
    @Override
    public boolean contains (E toFind) throws NullPointerException{
        // Check for null element
        if(toFind == null){
            throw new NullPointerException("Element to find cannot be null");
        }

        // Iterate through the list to find the specified element
        for(int i = 0; i < size; i++){
            if(toFind.equals(array[i])){
                return true;
            }
        }

        // Return false if the element was not found
        return false;
    }


    // Copies the elements of the list to the specified array
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] toHold) throws NullPointerException{

        // Check for null array
        if(toHold == null){
            throw new NullPointerException("The array to hold elements can't be null");
        }

        // Resize the array if needed or clear its contents
        if(toHold.length < size){
            toHold = (E[]) new Object[size];
        }
        else{
            clearArray(toHold);
        }

        // Copy elements from the list to the array
        System.arraycopy(array, 0, toHold, 0, size);

        return toHold;
    }


    // Copies the elements of the list to a new array
    @Override
    public Object[] toArray(){
        // Create a new array and copy elements from the list to it
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    // Returns an iterator over the elements in the list
    @Override
    public Iterator<E> iterator(){
        return new MyIterator();
    }

    // Ensures that the internal array has sufficient capacity for the specified minimum capacity
    private void ensureCapacity(int minCapacity){
        int currentCapacity = array.length;

        // If the current capacity is not enough, double it or use the specified minimum capacity
        if (minCapacity > currentCapacity){
            int newCapacity = Math.max(currentCapacity * 2, minCapacity);
            Object[] newArray = new Object[newCapacity];
            copyArray(array, newArray, size);
            array = newArray;
        }
    }

    // Copies the elements from the source array to the destination array up to the specified length
    private static void copyArray(Object[] src, Object[] dest, int length){
        for(int i = 0; i < length; i++){
            dest[i] = src[i];
        }
    }

    // Clears the elements of the array by setting each element to null
    private static void clearArray(Object[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    // Inner class representing an iterator over the elements in the list
    private class MyIterator implements Iterator<E>{

        // Index of the current element in the iteration
        private int currentIndex = 0;

        // Flag indicating whether there is a next element
        private boolean hasNext = true;

        // Checks if there is a next element in the iteration
        @Override
        public boolean hasNext(){
            return hasNext;
        }

        // Returns the next element in the iteration
        @Override
        @SuppressWarnings("unchecked")
        public E next(){
            // Throw an exception if there is no next element
            if(!hasNext()){
                throw new NoSuchElementException("No elements in the list");
            }

            // Retrieve the next element, increment the index, and update the hasNext flag
            E nextElement = (E) array[currentIndex];

            currentIndex ++;
            if(currentIndex == size){
                hasNext = false;
            }

            return nextElement;
        }

    }
}
