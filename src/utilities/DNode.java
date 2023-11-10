public class DNode {
    int value;
    DNode next, prev;



    public DNode(int value) {
        this.value = value;
        prev = next = null;
    }

    public int getValue() {
        return value;
    }

    public DNode getNext() {
        return next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setValue(int value) {
        this.value = value;
    }







}
