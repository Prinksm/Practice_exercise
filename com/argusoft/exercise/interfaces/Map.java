package com.argusoft.exercise.interfaces;

public interface Map <K,V>{
    //TO ADD ELE
    void put(K key, V value);
    //TO get ele
    V get(K key) ;
    V remove(K Key) ;
    boolean containKey(K Key) ;
    boolean isEmpty();
}
