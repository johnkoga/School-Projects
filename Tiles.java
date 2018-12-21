/**
 * Name: John Koga
 * Pennkey: johnkoga
 * Recitation: 205
 * 
 * File name: Tiles.java
 * Execution: java Tiles
 * Descrpition: Creates an object Tiles
 * that is a Tile on our 2048 board
 * and has a value and x and y position.
 * 
 */

public class Tiles {
    
    private int value;
    private int posX;
    private int posY;
    
    //constructor
    public Tiles(int val, int positionX, int positionY) {
        value = val;
        posX = positionX;
        posY = positionY;
    }
    
    
    //getter for value
    public int getValue() {
        return value;
    }
    
    //setter for value
    public void setValue(int val) {
        value = val;
    }
    
    //getter for posX
    public int getPosX() {
        return posX;
    }
    
    //setter for posX
    public void setPosX(int positionX) {
        posX = positionX;
    }
    
    //getter for posY
    public int getPosY() {
        return posY;
    }
    
    //setter for posY
    public void setPosY(int positionY) {
        posY = positionY;
    }
    
    //moves tile up one space
    public void up() {
        if (posY == 0) {
            return;
        } else {
            posY = posY - 1;
        }
        
    }
    
    //moves tile down one space
    public void down() {
        if (posY == 3) {
            return;
        } else {
            posY = posY + 1;
        }
        
    }
    
    //moves tile right one space
    public void right() {
        if (posX == 3) {
            return;
        } else {
            posX = posX + 1;
        }
    }
    
    //moves tile left one space
    public void left() {
        if (posX == 0) {
            return;
        } else {
            posX = posX - 1;
        }
    }
    
    
    // draws tile  
    public void draw() {
        double coordX = 0;
        double coordY = 0;
        if (posX == 3) {
            coordX = .875;
        } else if (posX == 2) {
            coordX = .625;
        } else if (posX == 1) {
            coordX = .375;
        } else {
            coordX = .125;
        }
        if (posY == 0) {
            coordY = .875;
        } else if (posY == 1) {
            coordY = .625;
        } else if (posY == 2) {
            coordY = .375;
        } else {
            coordY = .125;
        }
        PennDraw.setPenColor(PennDraw.ORANGE);
        PennDraw.filledSquare(coordX, coordY, .12);
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.text(coordX, coordY, "" + value);
        
    }
}


