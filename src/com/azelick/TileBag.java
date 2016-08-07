package com.azelick;

import java.util.Random;

/**
 * Created by azelick on 8/1/16.
 */
public class TileBag {
    private Tile [] tiles;
    private Tile [] tilesGivenOut;
    private static final int numOfTiles = 41;
    private static final int numOfConsonants = 21;
    private static final int numOfVowels = 20;
    private static final int consonantPointValue = 2;
    private static final int vowelPointValue = 1;
    private static final char [] consonantsInGame = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
            'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char [] vowelsInGame = {'A', 'A', 'A', 'A', 'E', 'E', 'E', 'E', 'I', 'I', 'I', 'I',
            'O', 'O', 'O', 'O', 'U', 'U', 'U', 'U'};

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

    public void putTileBack(Tile tile)
    {
        int i = 0;
        while (tilesGivenOut[i] != null && tilesGivenOut[i] != tile)
            ++i;
        returnToUnused(tile);
        tiles[i] = null;
    }

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

    public void returnToUnused(Tile tile)
    {
        int i = 0;
        while(tiles[i] != null)
            ++i;
        tiles[i] = tile;
    }
}
