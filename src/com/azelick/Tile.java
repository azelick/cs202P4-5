package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *  Tile Class, This is a basic building block of the game.
 *  Each tile has a letter and a point value associated with it.
 *  they are 'passed' through cloning to other classes in the app
 *  like hand and board to play the game.
 */
public class Tile implements Cloneable {
    //the letter on the tile
    char letter;
    //the point value of the tile
    int pointValue;

    /**
     * default constructor
     */
    public Tile (){}

    /**
     * the copy constructor
     * @param tile the tile to copy from
     */
    public Tile(Tile tile)
    {
        letter = tile.getLetter();
        pointValue = tile.getPointValue();
    }

    /**
     * The overriden clone method, used in place of the copy constructor
     * many places.
     * @return the newly created, 'cloned' object.
     */
    public Tile clone()
    {
        Tile cloned = null;
        try {
            cloned = (Tile) super.clone();
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }

    /**
     * the argument constructor for the tile
     * @param newLetter the letter to be places in the tile
     * @param newPointValue the given point value for the tile
     */
    public Tile(char newLetter, int newPointValue)
    {
        letter = newLetter;
        pointValue = newPointValue;
    }

    /**
     * Display the tile to the user
     */
    public void display()
    {
        System.out.print(letter + " - " + pointValue);
    }

    /**
     * Setter to set the letter in the tile
     * @param newLetter the letter to use as the new value
     */
    public void set_letter(char newLetter)
    {
        letter = newLetter;
    }

    /**
     * set the point value of the tile
     * @param newValue the new value to use for the tile
     */
    public void setPointValue(int newValue)
    {
        pointValue = newValue;
    }

    /**
     * getter method
     * @return return the letter in the tile
     */
    public char getLetter()
    {
        return letter;
    }

    /**
     * getter method
     * @return return the point value in the tile
     */
    public int getPointValue()
    {
        return pointValue;
    }

    /**
     * copy function to copy the data in the tile
      * @param tile the tile to copy from
     */
    public void copyTile(Tile tile)
    {
        tile.letter = letter;
        tile.pointValue = pointValue;
    }
}
