package com.argusoft.exercise.implementation;

import java.security.Key;
import java.util.Scanner;

class Node{
    String Key;
    String value;
    Node next;

    public Node(String Key , String val){
        this.Key = Key;
        this.value = val;
        this.next = null;
    }
}
class PrinkalMap {
   private int size = 10;
   private Node[] arr;

   PrinkalMap(int size){
       arr = new Node[size];
   }

   public int getIndex(String Key){
       return Math.abs(Key.hashCode())%size;
   }

   public void put(String Key , String value){
       int index = getIndex(Key);
       Node head = arr[index];
       while(head!=null){
           if(head.Key.equals(Key)){
               head.value = value;
               return;
           }
           head = head.next;
       }
       Node newNode = new Node(Key,value);
       newNode.next = arr[index];
       arr[index] = newNode;
   }
    public String get(String key) {
        int index = getIndex(key);
        Node head = arr[index];
        while (head != null) {
            if (head.Key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

}

public class MyMap{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrinkalMap obj= new PrinkalMap(12);
        System.out.print("Enter number of key-value pairs to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear newline
        for (int i = 0; i < n; i++) {
            System.out.print("Enter key: ");
            String key = sc.nextLine();
            System.out.print("Enter value: ");
            String value = sc.nextLine();
            obj.put(key, value);
        }

        System.out.print("\nEnter a key to get its value: ");
        String searchKey = sc.nextLine();
        String result = obj.get(searchKey);
        if (result != null) {
            System.out.println("Value for key '" + searchKey + "': " + result);
        } else {
            System.out.println("Key not found.");
        }
        sc.close();
    }
}