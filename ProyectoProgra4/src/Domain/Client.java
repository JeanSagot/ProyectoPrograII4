/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author jeanp
 */
public class Client extends Thread {
    
    static Socket socket;
    static DataInputStream dataIn;
    static DataOutputStream dataOut;
    
    public void run(JTextPane jtp_messageArea){
         try {
            socket = new Socket("192.168.100.6",9999);
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());

            String message = "";
            while (!message.equals("exit")) {
                message = dataIn.readUTF();
                //Muestra el mensaje en el area
                jtp_messageArea.setText(jtp_messageArea.getText().trim() + "\nServer:\t" + message);
            }
        } catch (Exception e) {
            System.out.println("Error receiveMessage");
        }
    }
}
