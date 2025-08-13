package com.argusoft.exercise.implementation.socket2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientM {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;
        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to Server");
            System.out.println("Enter commands like: SUM | SUB  | MUL  | DIV ");
            System.out.println("Type EXIT to quit.");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("EXIT")) {
                    break;
                }
                writer.println(input); // send request to server
                String response = reader.readLine(); // read response
                System.out.println(response);
            }
        } catch (IOException e) {
            System.out.println(" Could not connect to server: " + e.getMessage());
        }
    }
}
