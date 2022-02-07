/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author angelo
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int serverPort = 6789;
        ServerSocket serverSocket = new ServerSocket(serverPort);

        while(true)
        {
            System.out.println("Server in attesa...");
            Socket newClient = serverSocket.accept();
            System.out.println("Client connesso...");
            ServerThread clientConnection = new ServerThread(newClient);
            clientConnection.start();

        }
    }
    
}
