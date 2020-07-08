package com.adt;

@SuppressWarnings("serial")
public class NotInListException extends Exception {
    public NotInListException(String s) {
        super(s);
    }
}