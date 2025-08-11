package com.argusoft.exercise.implementation.socket;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    private Socket s = null;
    private DataInputStream in = null;
    private DataInputStream serverIN = null;
    private DataOutputStream op = null;

    public ClientSide(String address , int port){
        try{
            s = new Socket(address , port);
            System.out.println("Connection Established");
            in = new DataInputStream(System.in);
            serverIN = new DataInputStream(s.getInputStream());
            op = new DataOutputStream(s.getOutputStream());

        } catch (IOException i) {
            System.out.println(i);
            return;
        }
    }

    public void start() throws IOException{
        String mess = " ";
        while(true){
            mess = in.readLine();
            op.writeUTF(mess);
            if(mess.equalsIgnoreCase("over")){
                break;
            }
            String res = serverIN.readUTF();
            System.out.println(res);
        }
    }

    public  void close() throws IOException{
        in.close();
        op.close();
        s.close();
    }
    public static void main(String[] args) throws IOException {
        ClientSide obj = new ClientSide("127.0.0.1", 5000);
        obj.start();
        obj.close();
    }
}
