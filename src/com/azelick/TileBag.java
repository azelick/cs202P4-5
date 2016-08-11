package com.azelick;

import java.util.Random;

/**
 * Created by azelick on 8/1/16.
 *
 *  A TileBag class is used to create and 'hand out' the tiles the
 *  game will play with. Since the class keeps track of the number of tiles
 *  given out and returned, the game can only have so many of a given letter
 *
 */
public class TileBag {
    //the array of tiles in the bag
    private Tile [] tiles;
    //the array of tiles given out
    private Tile [] tilesGivenOut;
    //the number of tiles in the game
    private static final int numOfTiles = 41;
    //the number of consonants in the game
    private static final int numOfConsonants = 21;
    //the number of vowels in the game
    private static final int numOfVowels = 20;
    //the point value of a consonant
    private static final int consonantPointValue = 2;
    //the point value of a vowel in the game
    private static final int vowelPointValue = 1;
    //the consonants in the game
    private static final char [] consonantsInGame = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    //the vowels in the game
    private static final char [] vowelsInGame = {'A', 'A', 'A', 'A', 'E', 'E', 'E', 'E', 'I', 'I', 'I', 'I',
            'O', 'O', 'O', 'O', 'U', 'U', 'U', 'U'};

    /**
     * constructor
     *
     * Instantiates the tile bag with a new set of tiles
     */
    public TileBag()
    {
        tiles = new Tile[numOfTiles];
        for(int i = 0; i < numOfTiles; ++i)
            tiles[i] = null;
        tilesGivenOut = new Tile[numOfTiles];
        for (int i = 0; i < numOfTiles; ++i)
            tilesGivenOut[i] = null;
        populate();
        shuffleTiles();
    }

    /**
     * Copy Constructor
     * @param bag the bag to copy from
     */
    public TileBag(TileBag bag)
    {
        //need to copy tiles and tile given out
        tiles = new Tile[numOfTiles];
        for (int i = 0; i < numOfTiles; ++i)
        {
            if(bag.tiles[i] == null)
                tiles[i] = bag.tiles[i];
            else
                tiles[i] = new Tile(bag.tiles[i].letter, bag.tiles[i].pointValue);
        }
        tilesGivenOut = new Tile[numOfTiles];
        for (int i = 0; i < numOfTiles; ++i)
            if(bag.tilesGivenOut[i] == null)
                tilesGivenOut[i] = bag.tilesGivenOut[i];
            else
                tilesGivenOut[i] = new Tile(bag.tilesGivenOut[i].letter, bag.tilesGivenOut[i].pointValue);
    }

    /**
     * The overridden clone method, used in place of the copy constructor
     * @return the newly created, 'cloned' object
     */
    public TileBag clone()
    {
        TileBag cloned = null;
        try {
            cloned = (TileBag) super.clone();
        } catch (CloneNotSupportedException e) {}
        return cloned;
    }
    /**
     * Used to return to the client a randomized tile from the bag
     * then puts the tile into the 'given out' list
     * @return a randomized tile
     */
    public Tile getRandomTile()
    {
        int i = 0;
        while(tiles[i] == null)
            ++i;

        int v = 0;
        while(tilesGivenOut[v] != null)
            ++v;

        tilesGivenOut[v] = tiles[i];
        tiles[i] = null;

        return tilesGivenOut[v];
    }

    /**
     * put a given tile back in the bag
     * @param tile the given tile
     */
    public void putTileBack(Tile tile)
    {
        int i = 0;
        while (tilesGivenOut[i] != null && tilesGivenOut[i] != tile)
            ++i;
        returnToUnused(tile);
        tiles[i] = null;
    }

    /**
     *  Shuffle the tiles so clients who call getRandomTile() get random ones
     */
    protected void shuffleTiles()
    {
        Random rand = new Random();
        for (int i = 0; i < numOfTiles; ++i)
        {
            int index1 = rand.nextInt(numOfTiles);
            int index2 = rand.nextInt(numOfTiles);
            Tile temp = tiles[index1];
            tiles[index1] = tiles[index2];
            tiles[index2] = temp;
        }
    }

    /**
     * populate the tiles array with the tiles from the consonants and vowels static arrays,
     * and set their point values
     */
    protected void populate()
    {
        int v = 0;
        for(int i = 0; i < numOfConsonants; ++i)
        {
            tiles[v] = new Tile(consonantsInGame[i], consonantPointValue);
            ++v;
        }
        for(int i = 0; i < numOfVowels; ++i)
        {
            tiles[v] = new Tile(vowelsInGame[i], vowelPointValue);
            ++v;
        }
    }

    /**
     * return a given tile to the unused pile
     * @param tile the tile to be returned
     */
    public void returnToUnused(Tile tile)
    {
        int i = 0;
        while(tiles[i] != null)
            ++i;
        tiles[i] = tile;
    }
}
