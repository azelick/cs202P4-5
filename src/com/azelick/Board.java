package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
public class Board {
    private Space [][]head;
    private TileBag tBag;
    private int size;

    //Default Constructor
    public Board()
    {
        /**
         * I believe Java should set the above to null by default?
         *
         */

    }
    //arg constructor
    public Board(int newSize)
    {
        if(newSize > 0)
        {
            size = newSize;
            head = new Space[size][size];
        }
        else
        {
            head = null;
        }
        tBag = new TileBag();
    }

    public Board(Board board)
    {
        //copy bag, tiles, size
        board.copyBoard(this.head);
    }

    public void display()
    {
       for(int i = 0; i < size; ++i)
       {
           for (int v = 0; v < size; ++v)
               head[i][v].display();
       }
    }

    public boolean layTileOnBoard(Tile tile, int x, int y)
    {
        if (head[x][y].isOccupied())
            return false;
        else
        {
            head[x][y].setTileInSpace(tile);
            return true;
        }
    }

    public void set_premium()
    {
        //TODO
    }

    public Tile getRandomTile()
    {
        return tBag.getRandomTile();
    }

    public void putTileBack(Tile tile)
    {
        tBag.returnToUnused(tile);
    }

    public void checkWordIsValid(final String word)
    {
        //TODO
    }

    public void display_dictionary()
    {

        //TODO
    }

    //public DictWord findWordsWithLetter(final char letter)
    //{

    //TODO
    //}

    //public Coordinate findPlayableLocation(String word)
    //{

    //TODO
    //}

    protected void copyBoard(Space [][] head)
    {
        //TODO NEED TO LOOK UP HOW TO COPY A 2D ARRAY
    }

    protected boolean isContiguousAvailable(Coordinate location, int length)
    {
       //TODO
        return false;
    }

    //protected Coordinate find_empty_space()
    //{
        //TODO
    //}


}
