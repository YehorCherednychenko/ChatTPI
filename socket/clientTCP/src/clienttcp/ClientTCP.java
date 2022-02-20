package clienttcp;


public class ClientTCP {

    public static boolean connectionVerify = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client cliente = new Client();
        cliente.connection();


        while(connectionVerify) {
            cliente.communication();
        }

        
    }
    
}
