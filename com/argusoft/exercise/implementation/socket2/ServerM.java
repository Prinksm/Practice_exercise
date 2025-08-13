package com.argusoft.exercise.implementation.socket2;
import com.argusoft.exercise.implementation.socket.ServerSide;

import java.io.*;
import java.net.*;

public class ServerM {
    public static void main(String[]args){
        int port = 5000;
        // Listening for Connections
        try (ServerSocket serverSoc = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for a client ...");
            while (true) {
                //when connection is established, it returns a new Socket object
                Socket socket = serverSoc.accept();
                System.out.println("Client connected: " + socket.getInetAddress());
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            //used to read data and write response
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter write = new PrintWriter(socket.getOutputStream(),true);
            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Request: " + request.toUpperCase());
                String response = handleRequest(request, reader ,write);
                write.println(response);
                write.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
        }
    }
    public String handleRequest(String req , BufferedReader read , PrintWriter write){
        String request;
        double num1 , num2;
        try{
            request = req.trim().toUpperCase();
            switch (request){
                case "SUM" :
                    write.println("Enter First number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num1 = Double.parseDouble(input.trim());
                            System.out.println("First NUmber: " + num1);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    write.println("Enter Second number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num2 = Double.parseDouble(input.trim());
                            System.out.println("Second NUmber: " + num2);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    System.out.println("Result: " + (num1+num2));
                    return "Result :"+ (num1 + num2);

                case "SUB":
                    write.println("Enter First number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num1 = Double.parseDouble(input.trim());
                            System.out.println("First NUmber: " + num1);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    write.println("Enter Second number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num2 = Double.parseDouble(input.trim());
                            System.out.println("Second NUmber: " + num2);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    System.out.println("Result: " + (num1-num2));
                    return "Result :"+ (num1 - num2);

                case "MUL":
                    write.println("Enter First number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num1 = Double.parseDouble(input.trim());
                            System.out.println("First NUmber: " + num1);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    write.println("Enter Second number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num2 = Double.parseDouble(input.trim());
                            System.out.println("Second NUmber: " + num2);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    System.out.println("Result: " + (num1*num2));
                    return "Result :"+ (num1 * num2);

                case "DIV":
                    write.println("Enter First number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num1 = Double.parseDouble(input.trim());
                            System.out.println("First NUmber: " + num1);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }
                    write.println("Enter Second number");
                    while(true){
                        String input = read.readLine();
                        try{
                            num2 = Double.parseDouble(input.trim());
                            System.out.println("Second NUmber: " + num2);
                            break;
                        } catch (NumberFormatException e) {
                            write.println("Enter a valid number");
                        }
                    }  System.out.println("Result: " + (num1/num2));
                    return "Result :"+ (num1 / num2);

                default:
                    write.println("Choose from SUM, Sub, Mul, Div");
                    System.out.println("Invalid request");

            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return "This is your result";
    }
}


