package Interface;

import ChatClient.LoginForm;
import Constants.Constants;
import Domain.Board;
import Domain.ImageManagement;
import com.vdurmont.emoji.EmojiParser;
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
        // showBoard
        saveName();
        this.setLocationRelativeTo(null);
    }

    public void saveName() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Assets/name.png"));
        try {
            name = JOptionPane.showInputDialog(icon, null);
            if (name == null || name.equals("")) {
                JOptionPane.showMessageDialog(null, "You can't leave this input empty", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                saveName();
            }
            jl_playerName.setText("Player Name: " + name);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Your name can't be a numeric value");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_background = new javax.swing.JPanel();
        btn_restart = new javax.swing.JButton();
        jl_playerName = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jb_ClientPass = new javax.swing.JButton();
        jb_enterChat = new javax.swing.JButton();
        board1 = new Domain.Board();
        oponnentBoard1 = new Domain.OponnentBoard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_background.setBackground(new java.awt.Color(255, 255, 255));
        jp_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jButton1.setText("ServerPass");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jp_background.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jb_ClientPass.setText("ClientPass");
        jb_ClientPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_ClientPassActionPerformed(evt);
            }
        });
        jp_background.add(jb_ClientPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jb_enterChat.setText("Chat");
        jb_enterChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_enterChatActionPerformed(evt);
            }
        });
        jp_background.add(jb_enterChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));
        jp_background.add(board1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, -1, -1));
        jp_background.add(oponnentBoard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, -1, -1));

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

    private void btn_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restartActionPerformed

    }//GEN-LAST:event_btn_restartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Constants.turn++;
        System.out.println(Constants.turn%2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jb_ClientPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_ClientPassActionPerformed
        Constants.turn++;
    }//GEN-LAST:event_jb_ClientPassActionPerformed

    private void jb_enterChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_enterChatActionPerformed
        LoginForm loginChat = new LoginForm();
        loginChat.setVisible(true);
    }//GEN-LAST:event_jb_enterChatActionPerformed

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Domain.Board board1;
    private javax.swing.JButton btn_restart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jb_ClientPass;
    private javax.swing.JButton jb_enterChat;
    private javax.swing.JLabel jl_playerName;
    private javax.swing.JPanel jp_background;
    private Domain.OponnentBoard oponnentBoard1;
    // End of variables declaration//GEN-END:variables
}
