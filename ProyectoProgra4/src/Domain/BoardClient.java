/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Constants.Constants;
import java.awt.Color;
import java.awt.Component;
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
public class BoardClient extends JPanel {

    private JPanel selectedPanel = null;
    private Color originalColor = null;
    private int clickCount = 0;
    int shotHit = 0;
    ImageIcon ClientImages;
    private static int xCoord, yCoord;

    public BoardClient() {
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

            xCoord = i / Constants.BOARD_SIZE;
            yCoord = i % Constants.BOARD_SIZE;

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

                if (Constants.BOARD_SIZE == 5) {

                    if (clickCount > Constants.BOARD_SIZE) {
                        JOptionPane.showMessageDialog(null, "Has gastado tus tropas");
                    } else {
//                        ClientImages = new ImageIcon(getClass().getResource("/Assets/motherShipClientFull.png"));
//                        ClientImages = new ImageIcon(getClass().getResource("/Assets/shipClient.png"));
                        int numPanel;
                        JPanel panel = (JPanel) getComponentAt(e.getPoint());
                        selectedPanel = panel;
                        Component[] com = selectedPanel.getComponents();
                        if (panel == null || panel == BoardClient.this) {
                            return;
                        }

                        if (selectedPanel != null) {
                            selectedPanel.setBackground(originalColor);
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                        }

                        numPanel = Integer.parseInt(selectedPanel.getName());
                        switch (clickCount) {
                            case 1:
                                paintMotherShip(selectedPanel);
                                Constants.motherLocationClient = numPanel;
                                break;

                            case 2:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[0] = numPanel;
                                break;

                            case 3:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[1] = numPanel;
                                break;
                            case 4:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[2] = numPanel;
                                break;
                            case 5:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[3] = numPanel;
                                break;
                        }//END switch             
                    }
                } else if (Constants.BOARD_SIZE == 3) {
                    if (clickCount > Constants.BOARD_SIZE) {
                        JOptionPane.showMessageDialog(null, "Has gastado tus tropas");
                    } else {
                        int numPanel;
                        JPanel panel = (JPanel) getComponentAt(e.getPoint());
                        selectedPanel = panel;
                        Component[] com = selectedPanel.getComponents();

                        if (panel == null || panel == BoardClient.this) {
                            return;
                        }

                        if (selectedPanel != null) {
                            selectedPanel.setBackground(originalColor);
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                        }

                        numPanel = Integer.parseInt(selectedPanel.getName());

                        switch (clickCount) {
                            case 1:
                                paintMotherShip(selectedPanel);
                                Constants.motherLocationClient = numPanel;
                                break;

                            case 2:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[0] = numPanel;
                                break;

                            case 3:
                                paintShip(selectedPanel);
                                Constants.shipsLocationClient[1] = numPanel;
                                break;
                        }//END switch
                    }//END elseQuantityOfShips
                }
            }//END mousepressed
        });
    }//END setShip

    public int[] fillBattlefield(int selecPanel) {
        for (int i = 0; i < Constants.shipsLocationClient.length; i++) {
            Constants.shipsLocationClient[i] = selecPanel;
        }
        return Constants.shipsLocationClient;
    }

    public void paintShip(JPanel selecPanel) {
        ClientImages = new ImageIcon(getClass().getResource("/Assets/shipClient.png"));
        selecPanel.setBackground(Constants.SELECTION_COLOR);
        selecPanel.add(new JLabel(ClientImages));
        selecPanel.revalidate();
        selecPanel.repaint();
    }

    public void paintMotherShip(JPanel selecPanel) {
        ClientImages = new ImageIcon(getClass().getResource("/Assets/motherShipClientFull.png"));
        selectedPanel.setBackground(Constants.SELECTION_COLOR);
        selectedPanel.add(new JLabel(ClientImages));
        selectedPanel.revalidate();
        selectedPanel.repaint();
    }

}
