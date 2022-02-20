package servertcp;
import Game.GameLogic;
import Game.GameWords;

import java.io.*;
import java.net.*;
import java.util.*;



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


            serverMessage.writeBytes("Benvenuti nel Gioco dell'Impiccato!!\n");
            serverMessage.writeBytes("Premere 1 per leggere le regole.\n");
            serverMessage.writeBytes("Premere 2 per giocare\n");
            serverMessage.writeBytes("! pre uscire\n");
            clientResponse = clientMessage.readLine();

            if (clientResponse.equals("1")) {
                serverMessage.writeBytes("Tradizionale gioco dell'Impicato, con la differenza che all'inzio vengono subito fornite la prima e l'ultima lettera della " +
                        "parola da indovinare. Quindi si deve indovinare una parola fornita dal programma avendo 9 tentativi. Buon divertimento!\n");

                serverMessage.writeBytes("Premere 2 per giocare\n");
                serverMessage.writeBytes("! pre uscire\n");
                String newClientResponse = clientMessage.readLine();
                if (newClientResponse.equals("2"))
                    gamePlay();
                else
                    endGame();
            }
            else if(clientResponse.equals("2"))
                gamePlay();
            else
                endGame();
    }


    public void gamePlay() throws Exception{
        System.out.println("Esecuzione partita!");
        serverMessage.writeBytes(gameLogic.getGameStringEncoded() +'\n');

        do
        {

            clientResponse = clientMessage.readLine();
            System.out.println("Stringa letta: " + clientResponse);
            if (!clientResponse.startsWith("!") && !clientResponse.startsWith(".")) {
                if (clientResponse != null) {
                    String guessResult = gameLogic.getGameStringEncoded(clientResponse.charAt(0)) + '\n';

                    if(!guessResult.contains("_")) {
                        endGameWin();
                    }

                    else {
                        if (gameLogic.stillInGame())
                            serverMessage.writeBytes(guessResult);
                        else {
                            endGameLost();
                        }
                    }

                }
            }
            else {
                if (clientResponse.startsWith("."))
                    resetGame();

                else
                    {
                        endGame();
                        break;
                    }

            }


        }while(true);

        System.out.println("FINE DEL GIOCO!");




    }



    private void resetGame() throws IOException {
        gameLogic.resetAll();
        serverMessage.writeBytes("Gioco Riavviato. Nuova parola generata: " + gameLogic.getGameStringEncoded() +'\n');
    }
    private void endGameLost() throws IOException {
        serverMessage.writeBytes("HAI PERSO! La parola da indovinare era: " + gameLogic.getGameString() + '\n');
        resetGame();
    }
    private void endGameWin() throws IOException {
        serverMessage.writeBytes("HAI VINTO!! La parola indovinata: " + gameLogic.getGameString() + '\n');
        resetGame();
    }

    public void endGame() throws IOException {
        System.out.println("Client Disconesso!");
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
