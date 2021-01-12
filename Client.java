package Zad2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            String serverName = "127.0.0.1";
            int port = 3000;
            System.out.println("Connecting " + serverName + " port: " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Działa " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
