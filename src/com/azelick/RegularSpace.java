package com.azelick;

/**
 * Created by azelick on 8/4/16.
 */
public class RegularSpace extends Space {

    /**
     *  Just like Bonus space this is displaying the tile and the bars
     *  unlike it though it is not displaying any thing else
     */
    public void display()
    {
        System.out.print(" | ");
        if (tile != null)
            tile.display();
        else
            System.out.print("  -  ");
        System.out.print(" | ");
    }

    /**
     *
     * This is overridden to return simply the
     * point value of the letter. It's sister class BonusSpace
     * will return double the point value of the tile
     *
     **/
    public int getPoints()
    {
        if (tile != null)
        {
            return tile.getPointValue();
        }
        return 0;
    }
}
