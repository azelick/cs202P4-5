package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
public class Tile {
    char letter;
    int pointValue;

    public Tile() {}

    public Tile(Tile tile)
    {
        letter = tile.getLetter();
        pointValue = tile.getPointValue();
    }

    public Tile(char newLetter, int newPointValue)
    {
        letter = newLetter;
        pointValue = newPointValue;
    }

    public void display()
    {
        System.out.print(letter + " - " + pointValue);
    }

    public void set_letter(char newLetter)
    {
        letter = newLetter;
    }

    public void setPointValue(int newValue)
    {
        pointValue = newValue;
    }

    public char getLetter()
    {
        return letter;
    }

    public int getPointValue()
    {
        return pointValue;
    }

    public void copyTile(Tile tile)
    {
        tile.letter = letter;
        tile.pointValue = pointValue;
    }
}
