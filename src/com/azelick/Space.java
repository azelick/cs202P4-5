package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *
 * this might be an abstract base class
 * I can have two childred for single space and bonus space
 */
abstract public class Space {
    //fields
    Tile tile;
    boolean is_bonus = false;

    public Space()
    {
        tile = null;
    }

    abstract public void display();
    abstract public int getPoints();

    public int setTileInSpace(Tile tile)
    {
        this.tile = new Tile(tile);
        return getPoints();
    }

    public boolean isOccupied() {
        if(tile != null)
            return true;
        return false;
    }
}
