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
public class OponnentBoard extends JPanel {

    private JPanel selectedPanel = null;
    private Color originalColor = Color.BLACK;
    private int clickCount = 0;
    private int board[][] = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    private int attempts = 0, shotHit = 0;
    ImageIcon serverImages;
    private static int xCoord, yCoord;

    public OponnentBoard() {
        setShipPhase();
    }

    /**
     * Metodo encargado de dibujar las naves y ponerlas en la matriz cuando se
     * clickea y poner la madre y los hijos en el grid
     */
    public void setShipPhase() {
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
                clickCount++;
                int numPanel;
                if (clickCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE+1) {
                    JOptionPane.showMessageDialog(null, "WOW, Has destruido todas las naves hasta el ultimo tiro");
                } else {
                    /*----------------------------------------*/
                    JPanel panel = (JPanel) getComponentAt(e.getPoint());
                    selectedPanel = panel;

                    if (panel == null || panel == OponnentBoard.this) {
                        return;
                    }

                    if (selectedPanel != null) {
                        selectedPanel.setBackground(originalColor);
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    }
                    numPanel = Integer.parseInt(selectedPanel.getName());
                    if (isShipHit(numPanel) == true) {
                        serverImages = new ImageIcon(getClass().getResource("/Assets/shipHit.png"));
                        selectedPanel.setBackground(Constants.SELECTION_COLOR);
                        selectedPanel.add(new JLabel(serverImages));
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    } else {
                        serverImages = new ImageIcon(getClass().getResource("/Assets/shipMissed.png"));
                        selectedPanel.setBackground(Constants.SELECTION_COLOR);
                        selectedPanel.add(new JLabel(serverImages));
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    } 
                    for (int i = 0; i < Board.shipsLocation.length; i++) {
                        System.out.println("ARRAY " + Board.shipsLocation[i]);
                    }
                }
            }
        });
    }//END setShip

    public boolean isShipHit(int selecPanel) {
        for (int i = 0; i < Board.shipsLocation.length; i++) {
            if (Board.shipsLocation[i] == selecPanel) {
                return true;
            }
        }
        return false;

    }

}
