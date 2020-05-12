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

    public void add(T item) {
        Node<T> newNode = new Node<>();
        newNode.info = item;

        if ( head == null ) {
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
            }
            else {
                newNode.next = pred.next;
                newNode.prev = pred;
                pred.next = newNode;
            }
        }

        length++;
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
}