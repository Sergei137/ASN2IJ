package utilities;

public class Stack {
    int[] data;
    private int capacity;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        //this.size = 0;
    }

    public Stack() {
        this.capacity = 10;
        data = new int[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push (int element) {
        data[size] = element;
        size++;
    }

    public int peek () {
        return data[size - 1];
    }

    public void pop () {
        size--;
    }




}
