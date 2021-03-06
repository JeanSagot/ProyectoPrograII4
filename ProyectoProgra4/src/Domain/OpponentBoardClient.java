/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Constants.Constants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jeanp
 */
public class OpponentBoardClient extends JPanel {

    private JPanel selectedPanel = null;
    private Color originalColor = Color.BLACK;
    private int clickCount = 0;
    ImageIcon ClientImages;
    private static int xCoord, yCoord;

    public OpponentBoardClient() {
            attackRival();
    }

    /**
     * Metodo encargado de dibujar las naves y ponerlas en la matriz cuando se
     * clickea y poner la madre y los hijos en el grid
     */
    public void attackRival() {
        setLayout(new GridLayout(Constants.BOARD_SIZE, Constants.BOARD_SIZE, 1, 1));
        setBackground(Color.black);
        for (int i = 0; i < Constants.BOARD_SIZE * Constants.BOARD_SIZE; i++) {
            JPanel panel = new JPanel();
            String name = String.format("%d%d",
                    i / Constants.BOARD_SIZE, i % Constants.BOARD_SIZE);
            panel.setName(name);

            if (i == 0) {
                originalColor = panel.getBackground();
            }
            panel.setPreferredSize(Constants.PREF_SIZE);
            add(panel);
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int numPanel;
                 if(Board.clickCount<=3){
                }else{
                if (Constants.turn % 2 == 1) {
                    Constants.turn++;
                    /*----------------------------------------*/
                    if (Constants.shotsHitClient != Constants.BOARD_SIZE) {
                        JPanel panel = (JPanel) getComponentAt(e.getPoint());
                        selectedPanel = panel;

                        if (panel == null || panel == OpponentBoardClient.this) {
                            return;
                        }

                        if (selectedPanel != null) {

                            selectedPanel.setBackground(originalColor);
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                        }
                        numPanel = Integer.parseInt(selectedPanel.getName());
                        if (isShipHit(numPanel) == true || isMotherHit(numPanel) == true) {
                            Constants.shotsHitClient++;
                            paintHit(selectedPanel);
                        } else {
                            Constants.attemptsClient++;
                            paintMissed(selectedPanel);
                        }
                        for (int i = 0; i < Constants.shipsLocationClient.length; i++) {
                            System.out.println("ARRAY " + Constants.shipsLocationClient[i]);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Felicidades has ganado la batalla");
                    }
                }
            }
            }
        });
    }//END setShip

    public boolean isShipHit(int selecPanel) {
        for (int i = 0; i < Constants.shipsLocationClient.length; i++) {
            if (Constants.shipsLocationClient[i] == selecPanel) {
                return true;
            }
        }
        return false;
    }

    public boolean isMotherHit(int selecPanel) {
        if (Constants.motherLocationClient == selecPanel) {
            return true;
        }
        return false;
    }

    public void paintHit(JPanel selecPanel) {
        ClientImages = new ImageIcon(getClass().getResource("/Assets/shipHit.png"));
        selectedPanel.setBackground(Constants.SELECTION_COLOR);
        selectedPanel.add(new JLabel(ClientImages));
        selectedPanel.revalidate();
        selectedPanel.repaint();
    }

    public void paintMissed(JPanel selecPanel) {
        ClientImages = new ImageIcon(getClass().getResource("/Assets/shipMissed.png"));
        selectedPanel.setBackground(Constants.SELECTION_COLOR);
        selectedPanel.add(new JLabel(ClientImages));
        selectedPanel.revalidate();
        selectedPanel.repaint();
    }

}
