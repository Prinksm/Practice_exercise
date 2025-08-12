package com.argusoft.exercise.interfaces;

public interface Queue <T>{
    // to add ele
    void enqueue(T k);
    // to remove ele
    T dequeue();
    // to get first ele of queue
    T peek();
    boolean isEmpty();
    boolean isFull();
}
