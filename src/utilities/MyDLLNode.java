public class MyDLLNode {
    int value;
    MyDLLNode next, prev;



    public MyDLLNode(int value) {
        this.value = value;
        prev = next = null;
    }

    public int getValue() {
        return value;
    }

    public MyDLLNode getNext() {
        return next;
    }

    public MyDLLNode getPrev() {
        return prev;
    }

    public void setValue(int value) {
        this.value = value;
    }







}
