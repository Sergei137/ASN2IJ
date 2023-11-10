

public class DLinkedList {
    private int size;
    private DNode head, tail;

    
    
    public void DLinkedList() {
        
    }

    public DNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void add(DNode node) {
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

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String info = "";
        DNode node = head;
        for (int i = 0; i < size; i++) {
            info += node.toString() + "\n";
            node = node.getNext();
        }
        return info;
    }
}
