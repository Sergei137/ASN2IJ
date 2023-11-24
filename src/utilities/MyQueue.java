package utilities;

import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueADT<E>{
   // private E[] data;
    private MyDLL<E> QueueList;
    private int capacity;
    private int size;

    // constructor
    @SuppressWarnings("unchecked")
    public MyQueue(int capacity) {
        this.capacity = capacity;
        QueueList = new MyDLL<>();
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
        QueueList.add(toAdd);
        size++;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E dequeued = QueueList.get(0);
        QueueList.remove(0);
        return dequeued;
    }

    @Override
    public void dequeueAll() {
        QueueList.clear();
        size = 0;
    }

    @Override
    public E peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return QueueList.get(0);
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

        MyQueue<?> otherQueue = (MyQueue<?>) that;

        if (this.size != thisQueue.size) {
            return false;
        }

        Iterator<E> thisIterator = this.iterator();
        Iterator<?> otherIterator = otherQueue.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            Object otherElement = otherIterator.next();

            if (!thisElement.equals(otherElement)) {
                return false;
            }
        }



        return true;
    }

    @Override
    public Object[] toArray() {

        return QueueList.toArray();
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

    @Override
    public Iterator<E> iterator() {

        return QueueList.iterator();
    }
}
