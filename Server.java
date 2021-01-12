package Zad2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        System.out.println("Dawaj klienta, port: " + serverSocket.getLocalPort());
        while (true) {
            try {
                Socket server = serverSocket.accept();
                System.out.println("Adres połączonego klienta " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                server.setSoTimeout(10 * 1000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Thread thread = new Server(3000);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

