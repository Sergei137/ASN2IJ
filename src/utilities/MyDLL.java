package utilities;

public class MyDLL<E> implements ListADT<E> {

    public MyDLLNode<E> head;
    public MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        this.head = this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        if (index == 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            } else {
                tail = newNode;
            }
            head = newNode;
        } else {
            MyDLLNode<E> curr = head;

            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }

            newNode.setPrev(curr);
            newNode.setNext(curr.getNext());

            if (curr.getNext() != null) {
                curr.getNext().setPrev(newNode);
            } else {
                tail = newNode; // If adding at the end
            }

            curr.setNext(newNode);
        }

        size++;
        return true;
    }
}
