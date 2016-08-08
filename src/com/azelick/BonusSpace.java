package com.azelick;

/**
 * Created by azelick on 8/4/16.
 *
 * This class extends Space class. The playing board is made of a doubly
 * dimensioned array of Spaces. The board is made up of BonusSpaces and RegularSpaces
 *
 */
public class BonusSpace extends Space {
    //TODO dynamic methods: display and return points

    /**
     * the currently unused default constructor
     */
    public BonusSpace()
    {}

    /**
     * This will display the tile and bars, but unlike Regular space
     * it contains an * to show it's a bonus space.
     * this is an overriden method
     */
    public void display()
    {
        System.out.print(" | ");
        if(tile != null)
            tile.display();
        else
            System.out.print("  -  ");
        //this '*' is what differentiates the two overriden display methods
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
