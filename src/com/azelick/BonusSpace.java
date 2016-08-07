package com.azelick;

/**
 * Created by azelick on 8/4/16.
 */
public class BonusSpace extends Space {
    //TODO dynamic methods: display and return points

    public BonusSpace()
    {}

    /**
     * This will display the tile and bars, but unlike Regular space
     * it contains an * to show it's a bonus space.
     */
    public void display()
    {
        System.out.print(" | ");
        if(tile != null)
            tile.display();
        else
            System.out.print("  -  ");
        System.out.print("*| ");
        }

    /**
     * This is overridden to return the
     * point value of the letter multiplies by two.
     * It's sister class RegularSpace
     * will return 1x the point value of the tile
     **/
    public int getPoints()
    {
        if (tile != null)
        {
            return tile.getPointValue() * 2;
        }
        return 0;
    }
}
