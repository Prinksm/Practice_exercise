package com.argusoft.exercise.implementation.socket;
import java.io.*;
import java.net.*;

public class ServerSide {
    private Socket s = null;
    private ServerSocket server_soc = null;
    private DataInputStream in = null;
    private DataOutputStream op = null;

    public ServerSide(int port) throws IOException{
        server_soc = new ServerSocket(port);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        s = server_soc.accept();
        System.out.println("ClientSide accepted");
        in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
        op = new DataOutputStream(s.getOutputStream());

    }

    public void start() throws IOException{
        PrintWriter writer = new PrintWriter("/home/prinkalm@id.argusoft.com/prinks/client.txt");
        String mess = " ";
        while(true){
            mess = in.readUTF();
            if(mess.equalsIgnoreCase("over")){
                break;
            }
            System.out.println("client message : "+mess);
            op.writeUTF("ECHO : "+mess);
            writer.println(mess);
            writer.flush();
        }
        writer.close();
    }

    public  void close() throws IOException{
        System.out.println("Connection closing");
        in.close();
        op.close();
        s.close();
    }

    public static void main(String[]args)throws IOException{
        ServerSide obj1 = new ServerSide(5000);
        obj1.start();
        obj1.close();
    }
}
