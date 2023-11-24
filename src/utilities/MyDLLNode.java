package utilities;

public class MyDLLNode<E>{

    private E item;
    private MyDLLNode<E> next;
    private MyDLLNode<E> prev;

    public MyDLLNode(E item, MyDLLNode<E> next, MyDLLNode<E> prev){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
    public MyDLLNode(E item){
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    public E getItem(){
        return this.item;
    }

    public void setItem(E item){
        this.item = item;
    }

    public MyDLLNode<E> getNext(){
        return next;
    }

    public void setNext(MyDLLNode<E> next){
        this.next = next;
    }
    public MyDLLNode<E> getPrev(){
        return  prev;
    }

    public void setPrev(MyDLLNode<E> prev){
        this.prev = prev;
    }
}
