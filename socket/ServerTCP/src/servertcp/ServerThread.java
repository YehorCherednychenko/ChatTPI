package servertcp;
import Game.GameLogic;

import java.io.*;
import java.net.*;


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
            serverMessage.writeBytes("Premere 1 per leggere le regole con il manuale.\n");
            serverMessage.writeBytes("Premere 2 per giocare\n");
            serverMessage.writeBytes("! pre uscire\n");
            clientResponse = clientMessage.readLine();

            if (clientResponse.equals("1")) {
                serverMessage.writeBytes("Tradizionale gioco dell'Impicato, con la differenza che all'inzio vengono subito fornite la prima e l'ultima lettera della " +
                        "parola da indovinare. Quindi si deve indovinare una parola fornita dal programma avendo 9 tentativi. Si deve inserire una lettera alla volta, '!' per uscire dal gioco oppure '.' per cambiare la parola" +
                        " recuperando così anche tutta la vita. Buon divertimento!\n");

                serverMessage.writeBytes("Premere 2 per giocare\n");
                serverMessage.writeBytes("! pre uscire\n");
                String newClientResponse = clientMessage.readLine();
                if (newClientResponse.equals("2")) {
                    categoryChoice();
                    if (gameLogic.getGameString() != null)
                        gamePlay();
                }

                else
                    endGame();
            }
            else if(clientResponse.equals("2")) {
                if(categoryChoice())
                    gamePlay();
            }

            else
                endGame();
    }

    private boolean categoryChoice() throws IOException {
        System.out.println("Scelta categoria");
        serverMessage.writeBytes("Scegliere la categoria:\n");
        serverMessage.writeBytes("1. Piante e la natura\n");
        serverMessage.writeBytes("2. Sport\n");
        serverMessage.writeBytes("3. Cibo\n");
        serverMessage.writeBytes("4. Bevande\n");
        serverMessage.writeBytes("'!' Per uscire\n");

        clientResponse = clientMessage.readLine();


        if (clientResponse.equals("1")) {
            System.out.println("Natura");
            gameLogic.setGameStringNature();
            return true;
        }

        if (clientResponse.equals("2")) {
            System.out.println("Sport");
            gameLogic.setGameStringSport();
            return true;
        }

        if (clientResponse.equals("3")) {
            System.out.println("Cibo");
            gameLogic.setGameStringMeals();
            return true;
        }

        if (clientResponse.equals("4")) {
            System.out.println("Bevande");
            gameLogic.setGameStringDrinks();
            return true;
        }
        endGame();
        return false;
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
                        if(!endGameWin())
                            break;
                    }

                    else {
                        if (gameLogic.stillInGame())
                            serverMessage.writeBytes(guessResult);
                        else {
                            if (!endGameLost())
                                break;
                        }
                    }

                }
            }
            else {
                if (clientResponse.startsWith(".")) {
                    if(!resetGame())
                        break;
                }


                else
                    {
                        endGame();
                        break;
                    }

            }


        }while(true);

        System.out.println("FINE DEL GIOCO!");




    }



    private boolean resetGame() throws IOException {
        boolean inGame = categoryChoice();
        if (inGame)
            serverMessage.writeBytes("Gioco Riavviato. Nuova parola generata: " + gameLogic.getGameStringEncoded() +'\n');
        return inGame;
    }
    private boolean endGameLost() throws IOException {
        serverMessage.writeBytes("HAI PERSO! La parola da indovinare era: " + gameLogic.getGameString() + '\n');
        return resetGame();
    }
    private boolean endGameWin() throws IOException {
        serverMessage.writeBytes("HAI VINTO!! La parola indovinata: " + gameLogic.getGameString() + '\n');
        return resetGame();
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
