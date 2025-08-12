package com.argusoft.exercise.interfaces;

import com.argusoft.exercise.customException.*;

import java.util.EmptyStackException;

public interface Common <T>{
    // to push
    void adds(T k);
    // to pop last ele
    T removes() throws EmptyStackException;
    //to get last element
    T peek() throws EmptyStackException;
    boolean isEmpty();
    boolean isFull();
}
