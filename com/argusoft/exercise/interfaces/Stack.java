package com.argusoft.exercise.interfaces;

import java.util.EmptyStackException;

public interface Stack <T> {
    // to push
    void push(T k);
    // to pop last ele
    T pop() throws EmptyStackException;
    //to get last element
    T peek() throws EmptyStackException;
    boolean isEmpty();
    boolean isFull();
}
