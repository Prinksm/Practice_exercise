package com.argusoft.exercise.implementation.groupChat;

import java.io.IOException;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    public Server(ServerSocket serversoc){
        this.serverSocket = serversoc;
    }

    public void start()throws IOException {
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("client connected");
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread t = new Thread(clientHandler);
            t.start();
        }
    }

    public  void close() throws IOException{
        System.out.println("Connection closing");
        serverSocket.close();
    }

    public static void main(String[]args) throws IOException{
        ServerSocket serverSoc = new ServerSocket(5500);
        Server server = new Server(serverSoc);
        server.start();
    }
}
