package com.argusoft.exercise.implementation.groupChat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandler = new ArrayList<>();
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String userName;

    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.userName = reader.readLine();
            clientHandler.add(this);
            broadcastMessage("Server : "+userName+"has entered the chat");
        }catch (IOException e){
            close(socket , reader , writer);
        }
    }

    @Override
    public void run() {
      String message;
      while(socket.isConnected()){
          try {
              message = reader.readLine();
              broadcastMessage(message);
          }catch (IOException e){
              close(socket , reader , writer);
          }
      }
    }

    public void broadcastMessage(String messageSent){
        for(ClientHandler clientHandler1 :clientHandler){
            try{
                if(!clientHandler1.userName.equals(userName)){
                    clientHandler1.writer.write(messageSent);
                    clientHandler1.writer.newLine();
                    clientHandler1.writer.flush();
                }
            }
        }
    }

}
