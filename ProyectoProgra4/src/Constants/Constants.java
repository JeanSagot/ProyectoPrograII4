/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author jeanp
 */
public class Constants {

    public final int board[][] = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    public static final int MOTHERSHIP_SIZE = 2;
    public static int BOARD_SIZE = 3;
    public static final int SHIP_SIZE = 2;
    public static final int W = 60;
    public static final int H = W;
    public static final Dimension PREF_SIZE = new Dimension(W, H);
    public static final Color SELECTION_COLOR = Color.blue;
    public static int turn;
    
    public static int[] shipsLocationServer = new int[Constants.BOARD_SIZE-1];
    public static int[] shipsLocationClient = new int[Constants.BOARD_SIZE-1];
    public static int motherLocationServer;
    public static int motherLocationClient;
    public static int attemptsServer = 0;
    public static int attemptsClient = 0;
    public static int shotsHitServer = 0;
    public static int shotsHitClient = 0;
}
