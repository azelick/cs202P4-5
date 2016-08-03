package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *
 * this might be an abstract base class
 * I can have two childred for single space and bonus space
 */
public class Space {
    //fields
    Tile tile;
    boolean is_bonus = false;

    public Space()
    {
        tile = null;
    }
    public void setTileInSpace(Tile)
    {
        this.tile.copyTile(tile);
    }

    public void display()
    {
        tile.display();
        if (is_bonus)
            System.out.println("It is a bonus space");
    }

    public void setAsBonus()
    {
    //TODO this isn't needed if I extend the space class
    }

    public boolean isOccupied() {
        if(tile != null)
            return true;
        return false;
    }
}
