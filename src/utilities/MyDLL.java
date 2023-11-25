package utilities;

import java.util.NoSuchElementException;

/**
 * Implementation of a doubly linked list (DLL) as a generic class.
 * @param <E> The type of elements stored in the list.
 */
public class MyDLL<E> implements ListADT<E> {

    // Head and tail pointers for the doubly linked list.
    public MyDLLNode<E> head;
    public MyDLLNode<E> tail;
    private int size; // Size of the doubly linked list.

    /**
     * Constructor to initialize an empty doubly linked list.
     */
    public MyDLL() {
        this.head = this.tail = null;
        this.size = 0;
    }

    /**
     * Get the size of the doubly linked list.
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Clear the doubly linked list by resetting head,
     * tail, and size.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add an element at a specific index in the doubly linked list.
     * @param index The index at which the element should be added.
     * @param toAdd The element to be added.
     * @return True if the addition is successful, false otherwise.
     * @throws NullPointerException if the element to be added is null.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null element");
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // Create a new node with the given element.
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        // Insert the new node at the specified index.
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

        // Increment the size of the list and return true to indicate success.
        size++;
        return true;
    }

    /**
     * Add an element to the end of the doubly linked list.
     * @param toAdd The element to be added.
     * @return True if the addition is successful, false otherwise.
     * @throws NullPointerException if the element to be added is null.
     *
     */
    @Override
    public boolean add(E toAdd) throws NullPointerException {
        return add(size, toAdd);
    }

    /**
     * Add all elements from another list to the end of the doubly linked list.
     * @param toAdd The list containing elements to be added.
     * @return True if the addition is successful, false otherwise.
     * @throws NullPointerException if any element in the list to be added is null.
     */
    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    /**
     * Get the element at a specific index in the doubly linked list.
     * @param index The index of the element to be retrieved.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
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


    /**
     * Remove the element at a specific index from the doubly linked list.
     * @param index The index of the element to be removed.
     * @return The removed element.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        MyDLLNode<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        // Adjust the pointers to remove the node at the specified index.
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

        // Decrement the size of the list and return the removed element.
        size--;
        return curr.getItem();
    }

    /**
     * Remove the first occurrence of a specific element from the doubly linked list.
     * @param toRemove The element to be removed.
     * @return The removed element, or null if the element is not found.
     * @throws NullPointerException if the element to be removed is null.
     */
    @Override
    public E remove(E toRemove) throws NullPointerException {
        MyDLLNode<E> curr = head;

        // Find the node containing the element to be removed.
        while (curr != null && !curr.getItem().equals(toRemove)) {
            curr = curr.getNext();
        }

        // If the element is found, adjust pointers to remove the node
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

            // Decrement the size of the list and return the removed element.
            size--;
            return curr.getItem();
        } else {
            // Element not found, return null.
            return null;
        }
    }

    /**
     * Set the element at a specific index in the doubly linked list.
     * @param index The index at which the element should be set.
     * @param toChange The new element to be set.
     * @return The previous element at the specified index.
     * @throws NullPointerException if the new element is null.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) {
            throw new NullPointerException("Cannot set null element");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        // Find the node at the specified index and update its element.
        MyDLLNode<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        // Store the previous element, set the new element, and return the previous element.
        E previousData = curr.getItem();
        curr.setItem(toChange);

        return previousData;
    }


    /**
     * Check if the doubly linked list is empty.
     * @return True if the list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if the doubly linked list contains a specific element.
     * @param toFind The element to be searched for.
     * @return True if the element is found, false otherwise.
     * @throws NullPointerException if the element to be searched for is null.
     */
    @Override
    public boolean contains(E toFind) throws NullPointerException {
        MyDLLNode<E> curr = head;

        // Iterate through the list to find the specified element.
        while (curr != null) {
            if (curr.getItem().equals(toFind)) {
                return true;
            }
            curr = curr.getNext();
        }

        // Element not found, return false.
        return false;
    }

    /**
     * Convert the doubly linked list to an array.
     * @param toHold The array to hold the elements.
     * @return The array containing the elements of the list.
     * @throws NullPointerException if the array is null.
     */
    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold.length < size) {
            // If the provided array is too small, create a new array of the same type.
            toHold = (E[]) java.lang.reflect.Array.newInstance(
                    toHold.getClass().getComponentType(), size);
        }

        // Copy elements from the list to the array.
        MyDLLNode<E> curr = head;
        for (int i = 0; i < size; i++) {
            toHold[i] = curr.getItem();
            curr = curr.getNext();
        }

        return toHold;
    }

    /**
     * Convert the doubly linked list to an array of Objects.
     * @return The array containing the elements of the list as Objects.
     */
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


    /**
     * Provide an iterator for the doubly linked list.
     * @return An iterator for the list.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyIterator(head);
    }


    /**
     * Iterator implementation for the doubly linked list.
     */
    private class MyIterator implements Iterator<E> {

        private MyDLLNode<E> current;

        /**
         * Constructor to initialize the iterator with a starting node.
         * @param node The starting node for the iterator.
         */
        public MyIterator(MyDLLNode<E> node) {

            this.current = node;
        }

        /**
         * Check if there is a next element in the iteration.
         * @return True if there is a next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Get the next element in the iteration.
         * @return The next element in the iteration.
         * @throws NoSuchElementException if there is no next element.
         */
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
