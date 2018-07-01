package Domain;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Constants.Constants;

/**
 *
 * @author jeanp
 */
public class Board extends JPanel {

    private JPanel selectedPanel = null;
    private Color originalColor = null;
    private int clickCount = 0;
    private int board[][] = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    public static int[] shipsLocation = new int[Constants.BOARD_SIZE];
    public static int[] locationTest = {00, 43, 22, 33};
    private int attempts = 0;
    int shotHit = 0;
    ImageIcon serverImages;
    private static int xCoord, yCoord;

    public Board() {
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

            int xCoord = i / Constants.BOARD_SIZE;
            int yCoord = i % Constants.BOARD_SIZE;

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
                
                if(Constants.BOARD_SIZE==5){
                    
                if (clickCount > Constants.BOARD_SIZE) {
                    JOptionPane.showMessageDialog(null, "Has gastado tus tropas");
                } else {
//                        serverImages = new ImageIcon(getClass().getResource("/Assets/motherShipServerFull.png"));
//                        serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                    int numPanel;
                    JPanel panel = (JPanel) getComponentAt(e.getPoint());
                    selectedPanel = panel;

                    if (panel == null || panel == Board.this) {
                        return;
                    }

                    if (selectedPanel != null) {
                        selectedPanel.setBackground(originalColor);
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    }

                    numPanel = Integer.parseInt(selectedPanel.getName());
                    switch(clickCount){
                        case 1: 
                            serverImages = new ImageIcon(getClass().getResource("/Assets/motherShipServerFull.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[0]=numPanel;
                            break;
                        
                        case 2:
                            serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[1]=numPanel;
                            break;
                            
                        case 3:
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[2]=numPanel;
                            break;
                        case 4:
                            serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[3]=numPanel;
                            break;
                        case 5:
                            serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[4]=numPanel;
                            break;
                    }//END switch             
                }
                }else if(Constants.BOARD_SIZE==3){
                    if (clickCount > Constants.BOARD_SIZE) {
                    JOptionPane.showMessageDialog(null, "Has gastado tus tropas");
                } else {
                    int numPanel;
                    JPanel panel = (JPanel) getComponentAt(e.getPoint());
                    selectedPanel = panel;

                    if (panel == null || panel == Board.this) {
                        return;
                    }

                    if (selectedPanel != null) {
                        selectedPanel.setBackground(originalColor);
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    }

                    numPanel = Integer.parseInt(selectedPanel.getName());
                    switch(clickCount){
                        case 1: 
                            serverImages = new ImageIcon(getClass().getResource("/Assets/motherShipServerFull.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[0]=numPanel;
                            break;
                        
                        case 2:
                            serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[1]=numPanel;
                            break;
                            
                        case 3:
                            serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));
                            selectedPanel.setBackground(Constants.SELECTION_COLOR);
                            selectedPanel.add(new JLabel(serverImages));
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                            shipsLocation[2]=numPanel;
                            break;
                    }//END switch
                }//END elseQuantityOfShips
                }
            }//END mousepressed
        });
    }//END setShip

    public int[] fillBattlefield(int selecPanel) {
        for (int i = 0; i < shipsLocation.length; i++) {
            shipsLocation[i] = selecPanel;
        }
        return shipsLocation;
    }
}
