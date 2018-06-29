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
    ImageIcon serverImages;
    
    public Board() {
        setShipPhase();
    }
    
    
    /**
     * Metodo encargado de dibujar las naves y ponerlas en la matriz cuando se clickea
     * y poner la madre y los hijos en el grid
     */
    public void setShipPhase(){
        setLayout(new GridLayout(Constants.BOARD_SIZE, Constants.BOARD_SIZE, 1, 1));
        setBackground(Color.black);
        for (int i = 0; i < Constants.BOARD_SIZE* Constants.BOARD_SIZE; i++) {
            JPanel panel = new JPanel();
            String name = String.format("[%d, %d]",
                    i / Constants.BOARD_SIZE, i % Constants.BOARD_SIZE);
            panel.setName(name);
            
            int xCoord =  i / Constants.BOARD_SIZE;
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
                if (clickCount > Constants.BOARD_SIZE) {
                    JOptionPane.showMessageDialog(null, "Has gastado tus tropas");
                } else {
                    if (clickCount == 1) {
                        serverImages = new ImageIcon(getClass().getResource("/Assets/motherShipServerFull.png"));

                        JPanel panel = (JPanel) getComponentAt(e.getPoint());
                        if (panel == null || panel == Board.this) {
                            return;
                        }
                        if (selectedPanel != null) {

                            //selectedPanel.removeAll();
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                        }
                        // selectedPanel.setBackground(originalColor);
                        selectedPanel = panel;
                        selectedPanel.setBackground(Constants.SELECTION_COLOR);
                        selectedPanel.add(new JLabel(serverImages));
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    }else{
                        serverImages = new ImageIcon(getClass().getResource("/Assets/shipServer.png"));

                        JPanel panel = (JPanel) getComponentAt(e.getPoint());
                        if (panel == null || panel == Board.this) {
                            return;
                        }
                        if (selectedPanel != null) {

                            //selectedPanel.removeAll();
                            selectedPanel.revalidate();
                            selectedPanel.repaint();
                        }
                        // selectedPanel.setBackground(originalColor);
                        selectedPanel = panel;
                        selectedPanel.setBackground(Constants.SELECTION_COLOR);
                        selectedPanel.add(new JLabel(serverImages));
                        selectedPanel.revalidate();
                        selectedPanel.repaint();
                    }

                }
            }
        });
    }//END setShip

}
