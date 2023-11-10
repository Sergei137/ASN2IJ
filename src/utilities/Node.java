package utilities;

public class Node<E> {

    private E data;
    private Node<E> next;

    // constructors
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
        this.data = null;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    // logic to check if next node is null
    public boolean hasNext() {
        return next != null;
    }

    // toString method
    @Override
    public String toString() {
        // return "Node{" + "data=" + data + '}';
        return String.format("Node {data = %s}", data);
    }
}
