package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *
 * this might be an abstract base class
 * I can have two childred for single space and bonus space
 */
abstract public class Space implements Cloneable {
    //fields
    // The reference to a tile. This will be 'filled' when it's given a tile object
    Tile tile;

    //constructor setting tile to null
    public Space()
    {
        tile = null;
    }

    public Space clone()
    {
        Space cloned = null;
        try {
            cloned = (Space) super.clone();
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }
    /**
     * abstract method to be overridden to display the space
     */
    abstract public void display();

    /**
     * abstract base class method to be overridden. derived classes return different
     * multipliers
     * @return returns the number of points the tile in the space is worth.
     */
    abstract public int getPoints();

    /**
     * puts a tile argument in the tile reference through a copy
     * @param tile the tile to copy
     * @return the point value associated with placing a tile there
     */
    public int setTileInSpace(Tile tile)
    {
        this.tile = new Tile(tile);
        return getPoints();
    }

    /**
     * checks to see if the tile reference is null or not
     * @return if it's non null return true, is occupied
     */
    public boolean isOccupied() {
        if(tile != null)
            return true;
        return false;
    }
}
