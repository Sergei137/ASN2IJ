package utilities;

import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {
    private E[] data; // should this be final instead of private?
    private int capacity; // should this be final instead of private?
    private int size;

    // constructor 1
    public MyStack() {
        this.capacity = 10000;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // constructor 2
    public MyStack(int capacity) {
        this.capacity = capacity;
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

    // compare two stacks and return true if they are equal
    public boolean equals(StackADT<E> comparedStack) {
        // if comparedStack is null, return false
        if (comparedStack == null) {
            return false;
        }

        // if comparedStack is not an instance of MyStack, return false
        if (!(comparedStack instanceof MyStack<E> thatStack)) {
            return false;
        }

        // if comparedStack is not the same size as this stack, return false
        if (this.size != thatStack.size) {
            return false;
        }

        // if comparedStack is the same size as this stack, compare each element
        for (int i = 0; i < this.size; i++) {
            if (!this.data[i].equals(thatStack.data[i])) {
                return false;
            }
        }
        return true;
    }

    // return array of stack elements
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    // return array of stack elements
    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Input array cannot be null");
        }

        // If toHold is not big enough, allocate a new array of the same runtime type
        if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        // Copy elements from data to toHold with same order
        if (size >= 0) System.arraycopy(data, 0, toHold, 0, size);

        // If toHold has more elements than the stack, set the additional elements to null
        for (int i = size; i < toHold.length; i++) {
            toHold[i] = null;
        }

        return toHold;
    }

    // return true if stack contains element
    public boolean contains(E toFind) throws NullPointerException {
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

    // return 1-based element position from top of stack
    public int search(E toFind) {
        // size - 1 sets i to top element of stack
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(toFind)) {
                return size - i;
            }
        }
        return -1;
    }

    // return iterator over elements in stack
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index;

            // checks if there is another element in stack
            @Override
            public boolean hasNext() {
                return index < size;
            }

            // moves index to next element in stack
            @Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                return data[index++];
            }
        };
    }
}
