package utilities;

public class Queue {
    int[] data;
    private int size;
    private int capacity;
    private int start;
    private int end;

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
    public Queue() {

    }

    public Queue (int capacity) {
        this.capacity = 10;
        data = new int[size];
        end = -1;
        start = -1;
    }

    public void enqueue(int element) {
        data[++end] = element;

    }


}
