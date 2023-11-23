package utilities;

// import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
    int[] data;
    private int capacity; // should this be final instead of private?
    private int size;
    private int testVar1;

    //
    public MyStack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        //data = (E[]) (new Object[capacity]); // what does this do?
        size = 0;
    }

    // what does this do?
    public MyStack() {
        this.capacity = 10;
        data = new int[capacity];
    }

    //
    public int getCapacity() {
        return capacity;
    }

    //
    public int getSize() {
        return size;
    }

    //
    public void push (int element) {
        data[size] = element;
        size++;
    }

    //
    public int peek () {
        return data[size - 1];
    }

    //
    public void pop () {
        size--;
    }

    //
    public int size() {
        return 0;
    }

    //
    public void clear() {
        size = 0;
    }

    //
    public boolean isEmpty() {
        return size == 0;
    }

    //
    public boolean equals( StackADT<E> that ) {
        return false;
    }

    //
    public Object[] toArray() {
        return null;
    }

    public E[] toArray( E[] toHold ) throws NullPointerException {
        return null;
    }

    public boolean contains( E toFind ) throws NullPointerException {
        return false;
    }

    public int search( E toFind ) {
        return 0;
    }

    public Iterator<E> iterator() {
        return null;
    }



}
