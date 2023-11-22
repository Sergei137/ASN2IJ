package utilities;

public class MyDLL {
    private int size;
    private MyDLL head, tail;
    
    public void DLinkedList() {
        
    }

    public MyDLL getHead() {
        return head;
    }

    public MyDLL getNext() { return null; }

    public int getSize() {
        return size;
    }

    public void add(MyDLL node) {
        if (isEmpty()) {
            head = tail = node;
        } else if (size == 1) {

            // tail.next = node;
            // node.prev = tail;
            // tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    private void setNext(MyDLL node) {
    }

    private void setPrev(MyDLL tail) {
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String info = "";
        MyDLL node = head;
        for (int i = 0; i < size; i++) {
            info += node.toString() + "\n";
            node = node.getNext();
        }
        return info;
    }


}
