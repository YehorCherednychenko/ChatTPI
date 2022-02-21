package clienttcp;

import java.io.*;
import java.net.*;

public class Client {

    String ipServer = "localhost";
    int portaServer = 6789;

    Socket clientSocket;
    BufferedReader inputKeyboard;
    String playerGuess;
    String serverResponseMessage;
    DataOutputStream clientMessage;
    BufferedReader serverResponse;
   
    
    protected Socket connection() {
      try{  
        System.out.println("Client partito in esecuzione");
        inputKeyboard = new BufferedReader (new InputStreamReader(System.in));
        clientSocket = new Socket (ipServer, portaServer);
        clientMessage = new DataOutputStream (clientSocket.getOutputStream());
        serverResponse = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));


        serverResponseMessage = serverResponse.readLine();
        System.out.println(serverResponseMessage);
        serverResponseMessage = serverResponse.readLine();
        System.out.println(serverResponseMessage);
        serverResponseMessage = serverResponse.readLine();
        System.out.println(serverResponseMessage);
        serverResponseMessage = serverResponse.readLine();
        System.out.println(serverResponseMessage);

        boolean choice;
        do {
            choice = true;
            System.out.println("Cosa si desidera fare? ");
            playerGuess = inputKeyboard.readLine();

            if(playerGuess.equals("1") || playerGuess.equals("2") || playerGuess.equals("!"))
                choice = false;

        }while (choice);


        if (playerGuess.equals("1")) {
            clientMessage.writeBytes(playerGuess + "\n");
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);

            do {
                choice = true;
                System.out.println("Cosa si desidera fare? ");
                playerGuess = inputKeyboard.readLine();

                if(playerGuess.equals("2") || playerGuess.equals("!"))
                    choice = false;

            }while (choice);

            if (playerGuess.equals("!"))
            {
                ClientTCP.connectionVerify = false;
                clientMessage.writeBytes(playerGuess + "\n");
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                clientSocket.close();
                System.exit(2);
            }
            else {
                clientMessage.writeBytes(playerGuess + "\n");
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);
                serverResponseMessage = serverResponse.readLine();
                System.out.println(serverResponseMessage);


                do {
                    choice = true;
                    System.out.println("Scegli la categoria o esci: ");
                    playerGuess = inputKeyboard.readLine();

                    if(playerGuess.equals("1") || playerGuess.equals("2") || playerGuess.equals("3") || playerGuess.equals("4") || playerGuess.equals("!"))
                        choice = false;

                }while (choice);

                clientMessage.writeBytes(playerGuess + '\n');

                serverResponseMessage = serverResponse.readLine();
                if(serverResponseMessage.equals("Server in chiusura...")) {
                    System.out.println(serverResponseMessage);
                    System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                    clientSocket.close();
                    System.exit(2);
                }
                System.out.println("Indovina: " + serverResponseMessage);
            }
        }

        else if (playerGuess.equals("!"))
        {
            ClientTCP.connectionVerify = false;
            clientMessage.writeBytes(playerGuess + "\n");
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
            clientSocket.close();
            System.exit(2);
        }
        else {
            clientMessage.writeBytes(playerGuess + "\n");
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);
            serverResponseMessage = serverResponse.readLine();
            System.out.println(serverResponseMessage);


            do {
                choice = true;
                System.out.println("Scegli la categoria o esci: ");
                playerGuess = inputKeyboard.readLine();

                if (playerGuess.equals("1") || playerGuess.equals("2") || playerGuess.equals("3") || playerGuess.equals("4") || playerGuess.equals("!"))
                    choice = false;

            }while (choice);


            clientMessage.writeBytes(playerGuess + "\n");


            serverResponseMessage = serverResponse.readLine();
            if(serverResponseMessage.equals("Server in chiusura...")) {
                System.out.println(serverResponseMessage);
                System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                clientSocket.close();
                System.exit(2);
            }
            System.out.println("Indovina: " + serverResponseMessage);
        }



      }
      catch (UnknownHostException e){
          System.err.println("Host sconosciuto");
      }
      catch (Exception e){
          System.err.println("Errore durante la connessione");
          System.exit(1);
      }
      return clientSocket;
      
    }
    
    public void communication(){
        try{

            System.out.println("Inserisci il tuo tentativo: ");
            playerGuess = inputKeyboard.readLine();
            if(playerGuess.length() == 1)
            {
                if (playerGuess.matches("[a-zA-Z]*") || playerGuess.equals("!") || playerGuess.equals("."))
                {

                    //System.out.println( ".. invio la stringa al server e attendo...");
                    //System.out.println( "Stringa mandata: " + playerGuess);
                    playerGuess = playerGuess.toUpperCase();



                    if (playerGuess.equals(".")) {
                        clientMessage.writeBytes(playerGuess + "\n");
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);

                        boolean choice;
                        do {
                            choice = true;
                            System.out.println("Scegli la categoria o esci: ");
                            playerGuess = inputKeyboard.readLine();

                            if (playerGuess.equals("1") || playerGuess.equals("2") || playerGuess.equals("3") || playerGuess.equals("4") || playerGuess.equals("!"))
                                choice = false;

                        }while (choice);

                        clientMessage.writeBytes(playerGuess + '\n');
                        serverResponseMessage = serverResponse.readLine();

                        if(serverResponseMessage.equals("Server in chiusura...")) {
                            System.out.println(serverResponseMessage);
                            System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                            clientSocket.close();
                            System.exit(2);
                        }
                        System.out.println(serverResponseMessage);
                    }
                    else {
                        clientMessage.writeBytes(playerGuess + "\n");
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                    }


                    if(serverResponseMessage.equals("Server in chiusura...")) {
                        System.out.println(serverResponseMessage);
                        System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                        clientSocket.close();
                        System.exit(2);
                    }
                    if(serverResponseMessage.contains("PERSO") || serverResponseMessage.contains("VINTO")) {
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);
                        serverResponseMessage = serverResponse.readLine();
                        System.out.println(serverResponseMessage);

                        boolean choice;
                        do {
                            choice = true;
                            System.out.println("Scegli la categoria o esci: ");
                            playerGuess = inputKeyboard.readLine();

                            if(playerGuess.equals("1") || playerGuess.equals("2") || playerGuess.equals("3") || playerGuess.equals("4") || playerGuess.equals("!"))
                                choice = false;

                        }while (choice);


                        clientMessage.writeBytes(playerGuess + '\n');
                        serverResponseMessage = serverResponse.readLine();

                        if(serverResponseMessage.equals("Server in chiusura...")) {
                            System.out.println(serverResponseMessage);
                            System.out.println( "CLIENT: termina elaborazione e chiudi connessione");
                            clientSocket.close();
                            System.exit(2);
                        }
                        System.out.println(serverResponseMessage);
                    }

                }
                else
                    System.err.println("INSERISCI UNA LETTERA, '!' SE VUOI FINIRE DI GIOCARE OPPURE '.' PER RICOMINCIARE");
            }
           else
               System.err.println("INSERISCI UNA LETTERA, '!' SE VUOI FINIRE DI GIOCARE OPPURE '.' PER RICOMINCIARE");






        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.err.println("Errore durante la comunicazione con il server");
            System.exit(1);
        }
    }
    
}
