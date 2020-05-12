package com.adt;

public class Node<T> {
    protected T info;
    protected Node<T> next;
    protected Node<T> prev;

    public Node() {
        info = null;
        next = null;
        prev = null;
    }
}