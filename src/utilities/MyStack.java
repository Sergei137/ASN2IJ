package utilities;

import java.util.NoSuchElementException;

import utilities.MyArrayList;

public class MyStack<E> implements StackADT<E> {
    private final MyArrayList<E> data;
    private int capacity;
    private int size;

    // constructor
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.data = new MyArrayList<>();
        this.size = data.size();
    }

    // return capacity of stack
    public int getCapacity() {
        return capacity;
    }

    // return size of stack
    public int getSize() {
        return data.size();
    }

    // return true if stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // add element to top of stack
    public void push(E toAdd) throws NullPointerException {
        data.add(toAdd);
        size++;
    }

    // return top element of stack without removing it
    public E peek () {
        return data.get(size - 1);
    }

    // remove top element of stack and return it
    public E pop () {
        data.remove(size - 1);
        size--;
        return data.get(size - 1);
    }

    // remove all elements from stack
    public void clear() {
        data.clear();
        size = 0;
        capacity = 0;
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
            if (!this.data.get(i).equals(thatStack.data.get(i))) {
                return false;
            }
        }
        return true;
    }

    // return array of stack elements
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    // return array of stack elements
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

    // return true if stack contains element
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new NullPointerException("Input cannot be null");
        }

        for (int i = 0; i < size; i++) {
            if (data.get(i).equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    // return 1-based element position from top of stack
    public int search(E toFind) {
        // size - 1 sets i to top element of stack
        for (int i = size - 1; i >= 0; i--) {
            if (data.get(i).equals(toFind)) {
                return size - i;
            }
        }
        return -1;
    }

    // return iterator over elements in stack
    @Override
    public Iterator<E> iterator() {

        return data.iterator();
    }
}
