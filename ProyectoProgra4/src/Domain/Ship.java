/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.swing.JOptionPane;

/**
 *
 * @author jeanp
 */
public class Ship {
    private String name;
    private int shipSize; //Para ver si es la madre o una nave hija
    private int livesLeft; //la vida de la madre
    private boolean isDestroyed;
    private position shipPosition;

    //Constructors
    public Ship(String name, int shipSize) {
        this.name = name;
        this.shipSize = shipSize;
        this.livesLeft = shipSize;
        this.isDestroyed = false;
    }
    
    public Ship() {
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public boolean isIsDestroyed() {
        return isDestroyed;
    }

    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public position getShipPosition() {
        return shipPosition;
    }

    public void setShipPosition(position shipPosition) {
        this.shipPosition = shipPosition;
    }

    
    
    public void hitShip(){
        if(livesLeft  == 0){
            isDestroyed =true;
            JOptionPane.showMessageDialog(null, "Has destruido una de sus naves");
        }
        livesLeft--;
        System.out.println("Has golpeado a la nave madre");
    }
}
