package org.example;

import org.example.controller.ClientHandlerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerInitializer {

    private static ArrayList<ClientHandlerController> clients = new ArrayList<>();
    private static Socket socket;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            while (true){
                System.out.println("Server Start");
                socket=serverSocket.accept();
                System.out.println("Connected");

                ClientHandlerController clientHandlerController = new ClientHandlerController(socket,clients);
                Thread clientThread = new Thread(clientHandlerController);
                clients.add(clientHandlerController);
                System.out.println(clients);
                clientThread.start();
            }
        } catch (IOException e) {
           // throw new RuntimeException(e);
            e.printStackTrace();
        }

    }
}
