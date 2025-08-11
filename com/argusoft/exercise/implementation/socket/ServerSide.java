package com.argusoft.exercise.implementation.socket;
import java.io.*;
import java.net.*;

public class ServerSide {
    private Socket s = null;
    private ServerSocket server_soc = null;
    //for reading data
    private DataInputStream in = null;
    //for sending data
    private DataOutputStream op = null;

    public ServerSide(int port) throws IOException{
        //creates server socket
        server_soc = new ServerSocket(port);
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
        //wait for client to accept call
        s = server_soc.accept();
        System.out.println("ClientSide accepted");
        //buffered used so that data s read in chunks
        in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
        op = new DataOutputStream(s.getOutputStream());

    }

    public void start() throws IOException{
        //print writer is used to write data in client file
        PrintWriter writer = new PrintWriter("/home/prinkalm@id.argusoft.com/prinks/client.txt");
        String mess = " ";
        while(true){
            //reads client mess
            mess = in.readUTF();
            if(mess.equalsIgnoreCase("over")){
                break;
            }
            System.out.println("client message : "+mess);
            //echo the client message
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
