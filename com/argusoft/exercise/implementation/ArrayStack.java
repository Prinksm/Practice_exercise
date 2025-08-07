//package com.argusoft.exercise.implementation;
//import com.argusoft.exercise.interfaces.Common;
//import com.argusoft.exercise.customException.*;
//import com.argusoft.exercise.interfaces.Stack;
//
//import java.util.ArrayList;
//import java.util.EmptyStackException;
//
//public class ArrayStack<T>  implements Stack<T> {
//    private ArrayList<T> stack;
//    //initialise
//    ArrayStack(){
//        stack = new ArrayList<>();
//    }
//
//    public void push(T ele) {
//        stack.add(ele);
//    }
//
//    public T pop() {
//        if (isEmpty()) {
//            throw new EmptyStackException ();
//        }
//        return stack.remove(stack.size() - 1);
//    }
//
//    public T peek() throws  EmptyStackException  {
//        if (isEmpty()) {
//            throw new  EmptyStackException ("Stack is empty");
//        }
//        return stack.get(stack.size() - 1);
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return stack.isEmpty();
//    }
//
//    @Override
//    public boolean isFull() {
//        return false;
//    }
//
//    public static void main(String[]args) throws EmptyStackException {
//        ArrayStack<Integer> obj = new ArrayStack<>();
//
//        System.out.println("Is stack empty " + obj.isEmpty());
//        obj.push(10);
//        obj.push(20);
//        obj.push(30);
//        System.out.println("Top element is: " + obj.peek());
//        obj.pop();
//        System.out.println("Top element is: " + obj.peek());
//        System.out.println("Is stack empty " + obj.isEmpty());
//        obj.pop();
//        obj.pop();
//        obj.pop();
//    }
//}
