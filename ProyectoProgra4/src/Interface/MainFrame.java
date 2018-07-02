package Interface;

import Domain.Board;
import Domain.ImageManagement;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainFrame extends javax.swing.JFrame {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream dataIn;
    static DataOutputStream dataOut;
    static String name;
    
    public MainFrame() throws IOException {
        Board board = new Board();
        initComponents();
        saveName();
        initImages();
    }
    
    public void saveName() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/name.png"));
        try{
            name = JOptionPane.showInputDialog(icon, null);
            if(name == null || name.equals("")){
                JOptionPane.showMessageDialog(null, "You can't leave this input empty","Invalid Username",JOptionPane.ERROR_MESSAGE);
                saveName();
            }
            jl_playerName.setText("Player Name: "+name);
        }catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Your name can't be a numeric value");
        }
    }
    
    public void initImages() throws IOException{
        ImageManagement imgMng = new ImageManagement();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        oponnentBoard1 = new Domain.OponnentBoard();
        jp_background = new javax.swing.JPanel();
        jp_chatArea = new javax.swing.JPanel();
        jtf_writeMessage = new javax.swing.JTextField();
        jb_sendMessage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtp_messageArea = new javax.swing.JTextPane();
        jp_allyBoardServer = new Domain.Board();
        btn_restart = new javax.swing.JButton();
        jl_playerName = new javax.swing.JLabel();
        oponnentBoardServer = new Domain.OponnentBoard();
        boardClient = new Domain.BoardClient();
        opponentBoardClient = new Domain.OpponentBoardClient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_background.setBackground(new java.awt.Color(255, 255, 255));
        jp_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_chatArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf_writeMessage.setText("Type here...");
        jtf_writeMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtf_writeMessageMouseClicked(evt);
            }
        });
        jp_chatArea.add(jtf_writeMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 222, 320, 38));

        jb_sendMessage.setText("ok");
        jb_sendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sendMessageActionPerformed(evt);
            }
        });
        jp_chatArea.add(jb_sendMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 50, 40));

        jtp_messageArea.setEditable(false);
        jScrollPane2.setViewportView(jtp_messageArea);

        jp_chatArea.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 220));

        jp_background.add(jp_chatArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 293, -1, -1));
        jp_background.add(jp_allyBoardServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 318, 336, -1));

        btn_restart.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        btn_restart.setText("Restart");
        btn_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restartActionPerformed(evt);
            }
        });
        jp_background.add(btn_restart, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jl_playerName.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jl_playerName.setText("Player Name: ");
        jp_background.add(jl_playerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jp_background.add(oponnentBoardServer, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 30, 336, -1));
        jp_background.add(boardClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 340, -1));
        jp_background.add(opponentBoardClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 22, 320, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_sendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sendMessageActionPerformed
        //chatServ.sendMessage(jtf_writeMessage);
        try {
            String messageOut = "";
            messageOut = jtf_writeMessage.getText().trim();
            dataOut.writeUTF(messageOut);
            jtp_messageArea.setText(jtp_messageArea.getText().trim() + "\nServer:\t" + messageOut);
            jtf_writeMessage.setText("Type here...");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jb_sendMessageActionPerformed

    private void jtf_writeMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_writeMessageMouseClicked
        jtf_writeMessage.setText("");
    }//GEN-LAST:event_jtf_writeMessageMouseClicked

    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed
       
    }//GEN-LAST:event_btn_restartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Domain.BoardClient boardClient;
    private javax.swing.JButton btn_restart;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_sendMessage;
    private javax.swing.JLabel jl_playerName;
    private Domain.Board jp_allyBoardServer;
    private javax.swing.JPanel jp_background;
    private javax.swing.JPanel jp_chatArea;
    private javax.swing.JTextField jtf_writeMessage;
    private static javax.swing.JTextPane jtp_messageArea;
    private Domain.OponnentBoard oponnentBoard1;
    private Domain.OponnentBoard oponnentBoardServer;
    private Domain.OpponentBoardClient opponentBoardClient;
    // End of variables declaration//GEN-END:variables
}
