package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
abstract public class Hand {
    //The tiles this player has in their hand
    private Tile [] tilesInHand;
    //the score of the player
    private int score;
    //hame of player
    private String playerName;
    //character array of letters in hand tiles
    private char [] hand;
    //begining of hand LLL
    private DictWord head;


    public Hand()
    {

    }

    public void display()
    {

    }

    public void drawNewHand(Board board)
    {

    }

    public  int replaceTile(Board board, char letter)
    {

    }

    public void placeTileOnBoard(Board board, char letter, int x, int y)
    {

    }

    public void setDictMatchList(DictWord newHead)
    {

    }

    public void displayPossiblesList()
    {

    }

    public void groomForPlayableWords()
    {

    }

    public boolean playableFromHand(String word)
    {

    }

    public String getHand()
    {

    }

    abstract public void makePlay(Board baord);


    public int getScore()
    {

    }

    public boolean containsLetter(final char letter)
    {

    }

    public void displayScore()
    {

    }

    protected Tile getTileFromBag(Board board)
    {

    }

    protected void putTileBack(Board board, Tile tile)
    {

    }

   protected void copyList(DictWord head, DictWord current)
   {

   }

   protected void removeNonMatches(DictWord previous, DictWord current)
   {

   }
}
