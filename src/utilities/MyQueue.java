package utilities;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E>{
    private E[] data;
    private int capacity;
    private int size;

    // constructor
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Input cannot be null");
        }
        data[size++] = toAdd;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E dequeued = data[0];
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return dequeued;
    }

    @Override
    public void dequeueAll() {
        size = 0;
        //data = null; // is this correct?
    }

    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return data[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean equals( QueueADT<E> that ) {
        if (that == null) {
            return false;
        }

        if (!(that instanceof MyQueue<E> thisQueue)) {
            return false;
        }

        if (this.size != thisQueue.size) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (!this.data[i].equals(thisQueue.data[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray( E[] toHold ) throws NullPointerException {
        if (toHold == null) {
            throw new NullPointerException("Input cannot be null");
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
