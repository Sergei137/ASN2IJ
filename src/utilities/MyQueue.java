package utilities;

import java.util.NoSuchElementException;

// MyQueue uses methods in MyArrayList to manipulate the queue
public class MyQueue<E> implements QueueADT<E>{
    private final MyDLL<E> QueueList;
    private final int capacity;
    private int size;

    // Constructor
    public MyQueue(int capacity) {
        this.capacity = capacity;
        QueueList = new MyDLL<>();
        size = 0;
    }

    // Return capacity of queue
    public int getCapacity() {
        return capacity;
    }

    // Return size of queue
    @Override
    public int getSize() {
        return size;
    }

    // Add element to queue
    @Override
    public void enqueue(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException("Input cannot be null");
        }
        QueueList.add(toAdd);
        size++;
    }

    // Removes first element from queue and return the removed element
    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        // Remove first element from queue
        E dequeued = QueueList.get(0);
        QueueList.remove(0);
        return dequeued;
    }

    // Remove all elements from queue
    @Override
    public void dequeueAll() {
        QueueList.clear();
        size = 0;
    }

    // Return first element of queue without removing it
    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return QueueList.get(0);
    }

    // Checks size and returns true if queue is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if size is at max capacity and returns boolean
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    // Compare two stacks and return true if they are equal
    @Override
    public boolean equals( QueueADT<E> thatQueue ) {
        // If thatQueue is null, return false
        if (thatQueue == null) {
            return false;
        }

        // If thatQueue is not an instance of MyQueue, return false
        if (!(thatQueue instanceof MyQueue<E> thisQueue)) {
            return false;
        }

        // otherQueue is a MyQueue instance
        MyQueue<?> otherQueue = (MyQueue<?>) thatQueue;

        // If thatQueue is not the same as thisQueue, return false
        if (this.size != thisQueue.size) {
            return false;
        }

        // Iterate through each element and compare
        Iterator<E> thisIterator = this.iterator();
        Iterator<?> otherIterator = otherQueue.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            Object otherElement = otherIterator.next();

            // If elements are not equal, return false
            if (!thisElement.equals(otherElement)) {
                return false;
            }
        }

        return true;
    }

    // Return array of queue elements
    @Override
    public Object[] toArray() {
        return QueueList.toArray();
    }

    // Return array of queue elements
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

        // Iterate
        Iterator<E> iterator = iterator();
        for (int i = 0; i < size; i++) {
            toHold[i] = iterator.next();
        }

        // If toHold has more elements than the queue, set the additional elements to null
        for (int i = size; i < toHold.length; i++) {
            toHold[i] = null;
        }

        return toHold;
    }

    // Return iterator over queue elements
    @Override
    public Iterator<E> iterator() {

        return QueueList.iterator();
    }
}
