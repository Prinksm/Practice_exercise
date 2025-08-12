package com.argusoft.exercise.implementation.socket2;
import com.argusoft.exercise.implementation.socket.ServerSide;

import java.io.*;
import java.net.*;

public class ServerM {
    public static void main(String[]args){
        int port = 5000;
        try (ServerSocket serverSoc = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for a client ...");
            while (true) {
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter write = new PrintWriter(socket.getOutputStream(),true);
            String request;
            while ((request = reader.readLine()) != null) {
                System.out.println("Request: " + request);
                String response = handleRequest(request);
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
    public String handleRequest(String req){
        try {
            String request = req.trim().toUpperCase();
            if (request.startsWith("SUM")) {
                String[] nums = request.substring(3).trim().split("\\+");
                if (nums.length != 2) throw new Exception();
                double a = Double.parseDouble(nums[0]);
                double b = Double.parseDouble(nums[1]);
                return "Result: " + (a + b);
            } else if (request.startsWith("SUB")) {
                String[] nums = request.substring(3).trim().split("-");
                if (nums.length != 2) throw new Exception();
                double a = Double.parseDouble(nums[0]);
                double b = Double.parseDouble(nums[1]);
                return "Result: " + (a - b);
            } else if (request.startsWith("MUL")) {
                String[] nums = request.substring(3).trim().split("\\*");
                if (nums.length != 2) throw new Exception();
                double a = Double.parseDouble(nums[0]);
                double b = Double.parseDouble(nums[1]);
                return "Result: " + (a * b);
            } else if (request.startsWith("DIV")) {
                String[] nums = request.substring(3).trim().split("/");
                if (nums.length != 2) throw new Exception();
                double a = Double.parseDouble(nums[0]);
                double b = Double.parseDouble(nums[1]);
                if (b == 0) return "Error: Division by zero!";
                return "Result: " + (a / b);
            } else {
                return "choose from given option";
            }
        } catch (Exception e) {
            return "Error: Invalid format.";
        }
    }
}


