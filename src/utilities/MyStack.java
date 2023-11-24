package utilities;

import java.util.EmptyStackException;

// MyStack uses methods in MyArrayList to manipulate the stack.
public class MyStack<E> implements StackADT<E> {
    private final MyArrayList<E> data;
    private int capacity;
    private int size;

    // Constructor
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = new MyArrayList<>();
        this.size = data.size();
    }

    // Return capacity of stack
    public int getCapacity() {
        return capacity;
    }

    // Return size of stack
    @Override
    public int getSize() {
        return data.size();
    }

    // Checks size and returns true if stack is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Add element to top of stack
    @Override
    public void push(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Input element cannot be null");
        }
        data.add(toAdd);
        size++;
    }

    // Return top element of stack without removing it
    @Override
    public E peek () throws EmptyStackException {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(size - 1);
    }

    // Remove top element from the stack and return removed element
    @Override
    public E pop () throws EmptyStackException {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        data.remove(size - 1); // remove element from stack
        size--; // decrease size in stack
        return data.get(size - 1);
    }

    // Remove all elements from stack
    @Override
    public void clear() {
        data.clear(); // clear stack
        size = 0; // clear size
        capacity = 0; // cleae capacity
    }

    // Compare two stacks and return true if they are equal
    @Override
    public boolean equals(StackADT<E> thatStack) {
        // If thatStack is null, return false
        if (thatStack == null) {
            return false;
        }

        // If thisStack is not an instance of MyStack, return false
        if (!(thatStack instanceof MyStack<E> thisStack)) {
            return false;
        }

        // If thatStack is not the same size as thisStack, return false
        if (this.size != thisStack.size) {
            return false;
        }

        // If thatStack is the same size as thisStack, compare each element
        for (int i = 0; i < this.size; i++) {
            if (!this.data.get(i).equals(thisStack.data.get(i))) {
                return false;
            }
        }

        return true;
    }

    // Return array of stack elements
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size]; // create new Object array

        // iterate through data and add each element to new array
        for (int i = 0; i < size; i++) {
            result[i] = data.get(i);
        }

        return result;
    }

    // Return array of stack elements
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Input array cannot be null");
        }

        // If toHold is not big enough, allocate a new array of the same runtime type
        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        // Copy elements from data to toHold with same order
        for (int i = 0; i < size; i++) {
            toHold[i] = data.get(i);
        }

        // If toHold has more elements than the stack, set the additional elements to null
        for (int i = size; i < toHold.length; i++) {
            toHold[i] = null;
        }

        return toHold;
    }

    // Return boolean true if stack contains element
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Input cannot be null");
        }

        // Iterate though stack until element is found, return false if element is not found
        for (int i = 0; i < size; i++) {
            if (data.get(i).equals(toFind)) {
                return true;
            }
        }

        return false;
    }

    // Return 1-based element position from top of stack
    @Override
    public int search(E toFind) {
        // size - 1 sets i to top element of stack
        for (int i = size - 1; i >= 0; i--) {
            if (data.get(i).equals(toFind)) {
                return size - i;
            }
        }

        return -1;
    }

    // Return iterator over elements in stack
    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
