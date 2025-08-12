package com.argusoft.exercise.implementation.multiThreading;

import java.util.Scanner;

class Mythread extends Thread{
    private int orderId;
    public String status = "pending";
    Mythread(int orderId){
        this.orderId = orderId;
    }
    public String getStatus(){
        return status;
    }
    public void run(){
        status = "processing";
        System.out.println("For order " +orderId + " status is : "+ status);
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        status = "completed";
        System.out.println("For" +orderId + "status is : "+ status);
    }
}
public class MultiExc {
    public  static  void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        for (int i = 0; i <n ; i++) {
            Mythread t = new Mythread(i);
            t.start();
        }
    }
}
