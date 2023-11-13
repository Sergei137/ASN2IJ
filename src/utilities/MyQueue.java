package utilities;

public class MyQueue {
    int[] data;
    private int size;
    private int capacity;

    // constructor
    public MyQueue(int[] data, int size, int capacity) {
        this.data = data;
        this.size = size;
        this.capacity = capacity;
    }

    // getter setters
    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // logic
    public MyQueue() {
        this.capacity = 100;
        data = new int[capacity];
        size = 0;
    }

    public MyQueue(int capacity) {
        this.capacity = capacity;
        data = new int[size];
        size = 0;
    }

    public void enqueue(int element) {
        data[++size] = element;
    }

    public void dequeue() {
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
    }

    public int peek() {
        return data[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
