package com.azelick;

/**
 * Created by azelick on 8/1/16.
 */
abstract public class Hand {
    //The tiles this player has in their hand
    //is a CLL
    //This is a tail pointer
    private ListTile tailOfTiles;
    //the score of the player
    private int score;
    //hame of player
    private String playerName;
    //character array of letters in hand tiles
    private String displayHand;
    private final static int numOfTiles = 7;

    public Hand() {
        playerName = "";
    }

    public Hand(String name)
    {
        playerName = new String(name);
    }

    //copy constructor
    public Hand(Hand hand)
    {
        //TODO
        this.tailOfTiles = hand.tailOfTiles.copyList();
    }

    public void display() {
        System.out.println("Your hand: ");
        System.out.println(getHand());
        System.out.println("");
    }

    public String getName()
    {
        return playerName;
    }

    public void drawNewHand(Board board) {
        //we are using the loop to call the recursive function a specific number of times
        //create the first one outside the loop so we can create the data structure
        if(tailOfTiles == null) {
            Tile newGuy = new Tile(board.getRandomTile());
            tailOfTiles = new ListTile(newGuy);
            tailOfTiles.setNext(tailOfTiles);
        }
        for(int i = 0; i < numOfTiles - 1; ++i)
            tailOfTiles = tailOfTiles.insert(board.getRandomTile(), tailOfTiles);
    }

    private void addAtEnd(Tile handTile)
    {
        tailOfTiles.insert(handTile, tailOfTiles);
    }

    /**
     * to replace a tile in user's hand after they play to board
     * @param tile the playing board that gives us a tile
     * @param letter
     * @return
     */
    public void replaceTile(Tile tile, char letter) {
        tailOfTiles = tailOfTiles.replaceTile(tailOfTiles, tile, letter);
    }

    public int placeTileOnBoard(Board board, char letter, int x, int y) {
        Tile fromBag = getTileFromBag(board);
        //this will replace the 'letter' tile in hand with 'fromBag' and
        Tile toPlace = findTile(letter);
        tailOfTiles = tailOfTiles.replaceTile(tailOfTiles, fromBag, letter);
        return board.layTileOnBoard(toPlace, x, y);
    }

    public ListTile findTile(char letter)
    {
        return tailOfTiles.findTile(letter);
    }

    public String getHand() {
        displayHand = new String(tailOfTiles.buildDisplayList());
        return displayHand;
    }

    abstract public void makePlay(Board baord);


    public int getScore() {
        return score;
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
