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
                head.prev = newNode;
                head = newNode;
            }
            else {
                newNode.next = pred.next;
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
        if ( loc == null || loc.info != item ) {
            //do some spicy exception handling
            throw new UnsupportedOperationException();
        }

        loc.prev.next = loc.next;
        loc.next.prev = loc.prev;

        length--;
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
        Node<T> copy = head;
        System.out.print("LIST: ");
        for ( int i = 0; i < length; i++ ) {
            System.out.print(copy.info.toString() + " -> ");
            copy = copy.next;
        }
        System.out.println();
    }
}