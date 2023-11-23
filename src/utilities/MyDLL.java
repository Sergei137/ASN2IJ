package utilities;

import java.util.NoSuchElementException;

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

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        return curr.getItem();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        if (curr.getPrev() != null) {
            curr.getPrev().setNext(curr.getNext());
        } else {
            head = curr.getNext();
        }

        if (curr.getNext() != null) {
            curr.getNext().setPrev(curr.getPrev());
        } else {
            tail = curr.getPrev();
        }

        size--;
        return curr.getItem();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        MyDLLNode<E> curr = head;

        while (curr != null && !curr.getItem().equals(toRemove)) {
            curr = curr.getNext();
        }

        if (curr != null) {
            if (curr.getPrev() != null) {
                curr.getPrev().setNext(curr.getNext());
            } else {
                head = curr.getNext();
            }

            if (curr.getNext() != null) {
                curr.getNext().setPrev(curr.getPrev());
            } else {
                tail = curr.getPrev();
            }

            size--;
            return curr.getItem();
        } else {
            return null;
        }
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null element");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        E previousData = curr.getItem();
        curr.setItem(toChange);

        return previousData;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        MyDLLNode<E> curr = head;

        while (curr != null) {
            if (curr.getItem().equals(toFind)) {
                return true;
            }
            curr = curr.getNext();
        }

        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(
                    toHold.getClass().getComponentType(), size);
        }

        MyDLLNode<E> curr = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = curr.getItem();
            curr = curr.getNext();
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyDLLNode<E> curr = head;
        for (int i = 0; i < size; i++) {
            array[i] = curr.getItem();
            curr = curr.getNext();
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator(head);
    }

    private class MyIterator implements Iterator<E> {

        private MyDLLNode<E> current;

        public MyIterator(MyDLLNode<E> node) {
            this.current = node;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.getItem();
            current = current.getNext();
            return item;
        }
    }
}
