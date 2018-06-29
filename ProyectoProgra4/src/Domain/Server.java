/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author jeanp
 */
public class Server extends Thread {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream dataIn;
    static DataOutputStream dataOut;

    public void run(JTextPane jtp_messageArea) {
        String message = "";
        int portNum = 9999;
        try {
            serverSocket = new ServerSocket(portNum);
            System.out.println("El servidor se esta escuchando en el puerto: "
                    + portNum);
            socket = serverSocket.accept();
            System.out.println("El servidor ha aceptado");
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());

            while (!message.equals("exit")) {
                message = dataIn.readUTF();
                //Muestra el mensaje en el area
                jtp_messageArea.setText(jtp_messageArea.getText().trim() + "\nClient:\t" + message);
            }
        } catch (Exception e) {
            System.out.println("Error receiveMessage");
        }
    }
}
