/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author jeanp
 */
public class Player {

    private int id;
    private String name;
    private Board gameBoard;

    public Player(int id, String name) {
        System.out.printf("player: ", id, name);
        this.id = id;
        this.gameBoard = new Board();
    }
}
