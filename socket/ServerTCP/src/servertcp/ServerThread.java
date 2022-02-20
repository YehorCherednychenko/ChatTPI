/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertcp;
import Game.GameLogic;
import Game.GameWords;

import java.io.*;
import java.net.*;
import java.util.*;


/**
 *
 * @author angelo
 */
public class ServerThread extends Thread{

    Socket client = null;
    String clientResponse = null;
    BufferedReader clientMessage;
    DataOutputStream serverMessage;
    GameLogic gameLogic = new GameLogic();



    public ServerThread (Socket client) throws IOException {
        this.client = client;
        clientMessage = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        serverMessage = new DataOutputStream (this.client.getOutputStream());
    }


    public void gameStart() throws Exception {
        gamePlay();
    }


    public void gamePlay() throws Exception{
        System.out.println("Esecuzione partita!");
        clientResponse = clientMessage.readLine();

        while(!clientResponse.equals("!") && gameLogic.stillInGame())
        {
            if (clientResponse != null) {
                serverMessage.writeBytes(gameLogic.getGameStringEncoded(clientResponse.charAt(0)));
            }
            
        }

        endGame();

    }


    public void endGame() throws IOException {

        serverMessage.writeBytes("Server in chiusura...");
        serverMessage.close();
        clientMessage.close();
        client.close();
    }

    public  void run()
    {
        try {
            gameStart();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
