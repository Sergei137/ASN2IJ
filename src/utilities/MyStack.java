package utilities;

import java.util.NoSuchElementException;
import java.util.Arrays; // might not need this

public class MyStack<E> implements StackADT<E> {
    private E[] data; // should this be final instead of private?
    private int capacity; // should this be final instead of private?
    private int size;

    // constructor
    public MyStack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // constructor
    public MyStack() {
        this.capacity = 10000;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // return capacity of stack
    public int getCapacity() {
        return capacity;
    }

    // return size of stack
    public int getSize() {
        return size;
    }

    // return true if stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // compare two stacks and return
    public boolean equals( StackADT<E> that ) {
        return false;
    }

    // add element to top of stack
    public void push(E toAdd) throws NullPointerException {
        data[size] = toAdd;
        size++;
    }

    // return top element of stack without removing it
    public E peek () {
        return data[size - 1];
    }

    // remove top element of stack and return it
    public E pop () {
        size--;
        return data[size];
    }

    // return size of stack
    public int size() {
        return size;
    }

    // remove all elements from stack
    public void clear() {
        size = 0;
    }

    // return array of stack elements
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    // NOT SURE IF THIS IS CORRECT
    public E[] toArray( E[] toHold ) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Input array cannot be null");
        }

        if (toHold.length < size) {
            // If toHold is not big enough, allocate a new array of the same runtime type
            toHold = Arrays.copyOf(toHold, size);
        }
        System.arraycopy(data, 0, toHold, 0, size);
        if (toHold.length > size) {
            toHold[size] = null;  // If toHold has more elements than the stack, set the element following the stack elements to null
        }
        return toHold;
    }

    //
    public boolean contains( E toFind ) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Input cannot be null");
        }

        for (int i = 0; i < size; i++) {
            if (data[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    //
    public int search( E toFind ) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(toFind)) {
                return size - i;
            }
        }
        return -1;
    }

    //
    public Iterator<E> iterator() {
        return new MyStackIterator(data, size);
    }

    private class MyStackIterator implements Iterator<E> {
        private int index;
        private E[] data;
        private int size;

        public MyStackIterator(E[] data, int size) {
            this.data = data;
            this.size = size;
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            return data[index++];
        }
    }
}
