package com.azelick;

/**
 * Created by azelick on 8/1/16.
 *
 * This is the hand class. It is a base class for a UserPlayer and holds the
 * fields and methods required for the player to function
 * It is extended simply because that allows us to add in an AI player easily if
 * desired.
 */
abstract public class Hand {
    /**
    * The tiles this player has in their hand
    * data structure is a CLL
    * This is a tail pointer
    **/
    private ListTile tailOfTiles;
    //the score of the player which is adjusted over the game
    private int score;
    //name of player
    private String playerName;
    // The String of of letters in hand tiles
    private String displayHand;
    // The number of tiles each player should have in their hand at all times
    private final static int numOfTiles = 7;

    /**
     * creates a new Hand. initializes the player's name to an empty string
     */
    public Hand() {
        playerName = "";
    }

    /**
     * Argument constructor
     * @param name the supplied string to use as the playerName
     */
    public Hand(String name)
    {
        playerName = new String(name);
    }

    /**
     * copy constructor
     * @param hand the hand to copy from
     */
    public Hand(Hand hand)
    {
        //TODO
        this.tailOfTiles = hand.tailOfTiles.copyList();
    }

    /**
     * To display the string-ified version of the player's hand
     */
    public void displayHand() {
        System.out.println("Your hand: ");
        System.out.println(getHand());
        System.out.println("");
    }

    /**
     * getter
     * @return return the string form of the player's hand
     */
    public String getName()
    {
        return playerName;
    }


    /**
     * fills a player's hand with random tiles from the board's TileBag
     * @param board the board to take the tiles from
     */
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

    /**
     * to replace a tile in user's hand after they play to board
     * @param tile the playing board that gives us a tile
     * @param letter
     * @return
     */
    public void replaceTile(Tile tile, char letter) {
        tailOfTiles = tailOfTiles.replaceTile(tailOfTiles, tile, letter);
    }

    /**
     *  Place a tile matched from supplied letter
     *  on the board in a given location (predetermined outside the method)
     * @param board the board to place the tile upon
     * @param letter the letter to find the match from the hand with
     * @param x the x coordinate to place the tile upon
     * @param y the y coordinate to place the tile upon
     * @return the point value that placing that tile down will result with
     */
    public int placeTileOnBoard(Board board, char letter, int x, int y) {
        Tile fromBag = getTileFromBag(board);
        //this will replace the 'letter' tile in hand with 'fromBag' and
        Tile toPlace = findTile(letter);
        tailOfTiles = tailOfTiles.replaceTile(tailOfTiles, fromBag, letter);
        return board.layTileOnBoard(toPlace, x, y);
    }

    /**
     * find a tile given a letter
     * @param letter the letter to match with the existing tiles
     * @return returning the first occurrence of a ListTile that matches the given letter
     */
    public ListTile findTile(char letter)
    {
        return tailOfTiles.findTile(letter);
    }

    /**
     * makes a new string object with the tiles from the hand
     * @return returns a copy of the reference to that string
     */
    public String getHand() {
        displayHand = new String(tailOfTiles.buildDisplayList());
        return displayHand;
    }

    /**
     * abstract base method. This is abstract to allow an AI player and a user player
     * to have two different implementations
     * @param baord the board to make the play upon
     */
    abstract public void makePlay(Board baord);

    // return the player's score
    public int getScore() {
        return score;
    }

    /**
     * add to the players score
     * @param turnScore the score the player earned during this turn
     */
    public void addToScore(int turnScore)
    {
        score += turnScore;
    }

    // The score gets displayed here
    public void displayScore() {
        System.out.println(playerName + ", your score is: " + score);
    }

    /**
     * wrapper function to get a random tile from the bag
     * @param board the board to get a tile from
     * @return returns the tile
     */
    protected Tile getTileFromBag(Board board) {
        return board.getRandomTile();
    }

    /**
     * put a tile back in the bag
     * currently unused function
     * @param board the board that holds the bag to put the tile back into
     * @param tile the tile to put back in the bag
     */
    protected void putTileBack(Board board, Tile tile) {
        board.putTileBack(tile);
    }
}
