/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;


/**
 *
 * @author angelo
 */
public class ClientTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientStr cliente = new ClientStr();
        cliente.connetti();

        while(true) {
            cliente.comunica();
        }

        
    }
    
}
