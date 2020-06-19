package com.adt;

public class CDLList<T extends Comparable<T>> {
    //instance variables
    private Node<T> head;
    private int length;

    public CDLList() {
        head = new Node<>();
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.info = item;

        if ( isEmpty() ) {
            head = newNode;
            head.next = head;
            head.prev = head;
        }
        else {
            Node<T> pred = findItem(item);

            if ( pred == null ) {
                newNode.next = head;
                newNode.prev = head.prev;
                newNode.next.prev = newNode;
                newNode.prev.next = newNode;
                head = newNode;
            }
            else {
                newNode.next = pred.next;
                newNode.next.prev = newNode;
                newNode.prev = pred;
                pred.next = newNode;
            }
        }

        length++;
    }

    public void delete(T item) {
        if ( isEmpty() ) {
            //do some spicy exception handling
            throw new UnsupportedOperationException();
        }

        Node<T> loc = findItem(item);
        if ( loc == null || loc.info.compareTo(item) != 0 ) {
            //do some spicy exception handling
            throw new UnsupportedOperationException();
        }

        loc.prev.next = loc.next;
        loc.next.prev = loc.prev;

        //if head is deleted, move pointer to new head
        if ( head == loc ) {
            head = head.next;
        }

        length--;
    }

    public T getAt(int index) {
        Node<T> copy = head;
        if ( index < (length-1)/2 ) {
            for ( int i = 0; i < index; i++ ) {
                copy = copy.next;
            }
        }
        else {
            for ( int i = 0; i < length-index; i++ ) {
                copy = copy.prev;
            }
        }
        return copy.info;
    }

    private Node<T> findItem(T item) {
        Node<T> pred = null;
        Node<T> copy = head;

        int numIters = 0;
        while ( numIters < length ) {
            if ( (copy.info).compareTo(item) <= 0 ) {
                pred = copy;
            }
            else {
                break;
            }

            numIters++;
            copy = copy.next;
        }

        return pred;
    }

    public void fastForward(int n) {
        for ( int i = 0; i < n; i++ ) {
            head = head.next;
        }
    }

    public void rewind(int n) {
        for ( int i = 0; i < n; i++ ) {
            head = head.prev;
        }
    }

    public void printList() {
        System.out.print("LIST: ");
        for ( int i = 0; i < length; i++ ) {
            System.out.print(head.info.toString() + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}