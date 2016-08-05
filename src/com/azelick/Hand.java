package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
abstract public class Hand {
    //The tiles this player has in their hand
    private Tile[] tilesInHand;
    //the score of the player
    private int score;
    //hame of player
    private String playerName;
    //character array of letters in hand tiles
    private char[] handArr;
    private final static int numOfTiles = 7;

    public Hand() {
        generateEmptyHand();
        playerName = "";
    }

    public Hand(String name)
    {
        generateEmptyHand();
        playerName = new String(name);
    }

    //copy constructor
    public Hand(Hand hand)
    {
        //TODO
        this.tilesInHand = hand.tilesInHand.clone();
    }

    private void generateEmptyHand()
    {
         tilesInHand = new Tile[numOfTiles];
        for(int i = 0; i < numOfTiles; ++i)
            tilesInHand[i] = null;
    }
    public void display() {

        for(int i = 0; i < numOfTiles; ++i)
        {
            if (tilesInHand[i] == null)
                return;
            tilesInHand[i].display();
        }
    }

    public void drawNewHand(Board board) {
        for(int i = 0; i < numOfTiles; ++i)
            tilesInHand[i] = board.getRandomTile();
    }

    public int replaceTile(Board board, char letter) {
        boolean wasRemoved = false;
        int pointValue = 0;
        for(int i = 0; i < 7 && wasRemoved == false; ++i)
        {
            if(tilesInHand[i] != null)
            {
                if(tilesInHand[i] != null)
                {
                    pointValue += tilesInHand[i].getPointValue();
                    tilesInHand[i] = null;
                    tilesInHand[i] = board.getRandomTile();
                    wasRemoved = true;
                }
            }
        }
        return pointValue;
    }

    public void placeTileOnBoard(Board board, char letter, int x, int y) {
        int i = 0;
        while((tilesInHand[i] != null) && (tilesInHand[i].getLetter() != letter))
            ++i;
        board.layTileOnBoard(tilesInHand[i], x, y);
    }

    public String getHand() {
        //TODO Should this be done in a different way? I feel probably? Maybe with the string class?
        handArr = new char[numOfTiles];
        for(int i = 0; i < numOfTiles; ++i)
            handArr = new char[tilesInHand[i].getLetter()];
        //TODO If this works that's awesome
        return new String(handArr);
    }

    abstract public void makePlay(Board baord);


    public int getScore() {
        return score;
    }

    public boolean containsLetter(final char letter) {
        boolean doesContain = false;
        for(int i = 0; tilesInHand[i] != null && i < numOfTiles && doesContain == false ; ++i)
        {
            if(tilesInHand[i].getLetter() == letter)
                doesContain = true;
        }
        return doesContain;
    }

    public void displayScore() {
        System.out.println("The player's score is: " + score);
    }

    protected Tile getTileFromBag(Board board) {
        return board.getRandomTile();
    }

    protected void putTileBack(Board board, Tile tile) {
        board.putTileBack(tile);
    }
}
