package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *
 * This is the board class, it is responsible for holding the spaces of the board
 * and also the tileBag that generates the random list of tiles to play with
 *
 */
public class Board implements Cloneable {
    // head is the reference to the doubly dimensioned array of spaces
    private Space [][]head;
    //this is the tile bag that generates tiles for the players and board to use
    private TileBag tBag;
    //this is a n dimension of the board. Since the board is a perfect square, it is size * size dimensioned
    private int size;

    //Default Constructor
    public Board() {}

    //arg constructor
    public Board(int newSize)
    {
        if(newSize > 0)
        {
            size = newSize;
            //since a square board
            head = new Space[size][size];
            for (int i = 0; i < size; ++i)
            {
                for(int v = 0; v < size; ++v)
                {
                    //here we are creating bonus spaces, along the diagonal
                   if(i == v)
                       head[i][v] = new BonusSpace();
                   else if((size - i - 1) == v)
                       head[i][v] = new BonusSpace();
                   //and regular spaces everywhere else
                   else
                        head[i][v] = new RegularSpace();
                }
            }
        }
        else
        {
            head = null;
        }
        tBag = new TileBag();
    }

    /**
     * The overridden clone method, used in place of
     * the copy constructor
     * @return the newly created, 'cloned' object
     */
    public Board clone()
    {
        Board cloned = null;
        try {
            cloned = (Board) super.clone();
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }

    /**
     * this displays the entire board
     */
    public void display()
    {
       for(int i = 0; i < size; ++i)
       {
           for (int v = 0; v < size; ++v)
           {
               System.out.print("row: ");
               head[i][v].display();
           }
           System.out.println("");
       }
    }

    /**
     * check if occupied,
     * if not call head's(that's a Space reference) setTileInSpace method
     * @param tile the tile we're placing into a space
     * @param x the x coordinate
     * @param y the y coordinate
     * @return returns the point value of placing the tile in that spot
     */
    public int layTileOnBoard(Tile tile, int x, int y)
    {
        if (head[x][y].isOccupied())
            return 0;
        else
        {
            return head[x][y].setTileInSpace(tile);
        }
    }

    /**
     * @return a random tile from the TileBag object
     */
    public Tile getRandomTile()
    {
        return tBag.getRandomTile();
    }

    /**
     * put a tile back in the bag
     * @param tile the tile to put back
     */
    public void putTileBack(Tile tile)
    {
        tBag.returnToUnused(tile);
    }
}
