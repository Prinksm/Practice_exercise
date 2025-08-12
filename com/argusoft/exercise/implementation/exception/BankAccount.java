package com.argusoft.exercise.implementation.exception;
import com.argusoft.exercise.customException.InsufficientFundsException;
import java.util.Scanner;

class Account{
    private double balance ;
    public Account(double balance){
        this.balance = balance;
    }
    public void deposit(double amt){
        if(amt>0){
            balance += balance;
            System.out.println("balance updated");
        }else{
            System.out.println("Add positive value");
        }
    }

    public void withdrawl(double amt)throws InsufficientFundsException {
        if(amt>balance){
            throw new InsufficientFundsException("Insufficient funds");
        }else{
            balance -= amt;
            System.out.println("Withdrawl amount: " + amt);
        }
    }
    public double getBalance() {
        return balance;
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account acc = new Account(1000);
        while (true) {
            System.out.println("Choose any option");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depAmt = sc.nextDouble();
                    acc.deposit(depAmt);
                    System.out.println("Balance after transaction: " + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withAmt = sc.nextDouble();
                    try {
                        acc.withdrawl(withAmt);
                    } catch (InsufficientFundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Current Balance: " + acc.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println(":x: Invalid choice! Try again.");
            }

        }
    }
}
