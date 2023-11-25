package utilities;

public class MyDLLNode<E>{

    private E item; //data stored in the node
    private MyDLLNode<E> next; // reference to the next node in the DLL
    private MyDLLNode<E> prev; //reference to the previous node in the DLL

    //Constructor to initialise the node with specified item, next, and previous references.
    public MyDLLNode(E item, MyDLLNode<E> next, MyDLLNode<E> prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
    //Constructor to initialise the code with only the item, and set next and prev to null
    public MyDLLNode(E item){
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    //Getter method to retrieve the item stored in the node
    public E getItem(){
        return this.item;
    }

    //Setter the method to update the item stored in the node.
    public void setItem(E item){
        this.item = item;
    }

    //Getter method to retrieve the reference to the next node in the DLL
    public MyDLLNode<E> getNext(){
        return next;
    }

    //Setter method to update the reference to the next node in the DLL
    public void setNext(MyDLLNode<E> next){
        this.next = next;
    }

    //Getter method to retrieve the reference to the previous node in the DLL
    public MyDLLNode<E> getPrev(){
        return  prev;
    }

    //Setter method to update the reference to the previous node in DLL
    public void setPrev(MyDLLNode<E> prev){
        this.prev = prev;
    }
}
