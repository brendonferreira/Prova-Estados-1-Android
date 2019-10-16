package com.aula;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int port = 12345;
    private static boolean open = true;


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server socket initializated...");
        while( open ) {
            System.out.println("Waiting for connections in port "+port);
            Socket socket = serverSocket.accept();
            System.out.println("New connection");
            new RoutesHandler(socket).start();
        }

    }
}
