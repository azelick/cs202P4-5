package com.azelick;

/**
 * Created by azelick on 8/5/16.
 *
 * This is a derived class of tile
 * It adds functionality to allow it to
 * function as a circular linked list node
 */
public class ListTile extends Tile{
    //This is a referenced next tile that allows you to put it into a list data structure
    private ListTile next;
    //building an array list of the characters in the subtree
    private String lettersInList;

    public ListTile(){}

    /**
     * Create a ListTile
     * @param tile the tile to create this from
     */
    public ListTile(Tile tile)
    {
        super(tile);

    }

    //traversal
    /**
     * getter
     * @return returns the ListTile 'next'
     */
    protected ListTile getNext()
    {
        return next;
    };

    /**
     * setter
     * @param tile the tile to set next reference to
     */
    protected void setNext(ListTile tile)
    {
        next = tile;
    }

    /**
     *  Wrapper function to insert at the end of the node:
     * @param tile the tile to add
     */
    public ListTile insert(Tile tile, ListTile tail)
    {
        //we're setting tail in the calling routing so it won't throw an exception in here
        tail.setNext(insertAtEnd(this.getNext(), new ListTile(tile), tail));
        return tail;
    }

    /**
     *  The recursive call to add at the end of the CLL
     * @param tile Where the function is currently pointing
     * @param newGuy The guy to add at the end of the list
     */
    private ListTile insertAtEnd(ListTile tile, ListTile newGuy, ListTile tail)
    {
        //this means there's only one in the list or we've reached the end of the list
        if(tile == tail)
        {
           //here we're inserting
            tile = new ListTile(newGuy);
            tile.setNext(tail);
        }
        //there's more than one in the list and we're recursing
        else {
            tile.setNext(insertAtEnd(tile.getNext(), newGuy, tail));
        }
        return tile;
    }

    /**
     * This method will copy the list into a new ListTile
     * @return the tail pointer to the new list
     */
    public ListTile copyList()
    {
        return this.copyAll(this, new ListTile());
    }

    /**
     * retursive call to copy the list
     * @param tile the current object
     * @param toMake the guy to create
     * @return the tile to link up
     */
    private ListTile copyAll(ListTile tile, ListTile toMake)
    {
        if(tile == null)
            return null;

        //TODO Do I need this? if not, it's kinda a pain
        return null;

    }

    /**
     * replaces the tile in hand with a new one provided to the function
     * @param tail the tail reference of the CLL
     * @param tile the tile to replace
     * @param letter the letter to remove and replace with the new tile
     * @return returns the tile added
     */
    public ListTile replaceTile(ListTile tail, Tile tile, char letter)
    {
        if(tail == null)
            return null;
        return findAndReplaceTile(tail.getNext(), tail, tile, letter);
    }

    /**
     * The recursive function called by replaceTile to traverse the list and replace
     * a given tile
     * @param lTile the current position (tile)
     * @param tail the reference to the tail pointer
     * @param toInsert the tile to insert
     * @param letter the letter to match, once found we remove that node
     * @return return the tile that's added
     */
    private ListTile findAndReplaceTile(ListTile lTile, ListTile tail, Tile toInsert, char letter) {
        //case 1 - empty list
        if (lTile == null)
            return null;
        //case 2 - only one in list
        if(lTile == tail)
        {
            if (lTile.getLetter() == letter)
            {
                return new ListTile(toInsert);
            }
        }
        //case 3 - more than 1 in list
        if(lTile.getNext().getLetter() == letter)
        {
            ListTile temp = lTile.getNext();
            lTile.setNext(new ListTile(toInsert));
            lTile.getNext().setNext(temp.getNext());
            return lTile;
        }

        //here we have reached the end of the loop and we'll exit
        if(lTile.getNext() == tail)
            return lTile;

        lTile.setNext(findAndReplaceTile(lTile.getNext(), tail, toInsert, letter));
        return lTile;
    }

    /**
     * traverse through the tiles in hand and add each letter to the
     * letterInList string reference object.
     * calls a recursive function
     * @return the string after it's been formed
     */
    public String buildDisplayList()
    {
        if(lettersInList == null)
            lettersInList = new String("");
        buildDisplayList(this.getNext(), this);
        return lettersInList;
    }

    /**
     * recursive call to add the letters in the hand CLL to a char array
     * called by buildDisplayList
     * @param tile the current reference tile
     * @param tail the tail (used as our stopping condition)
     */
    public void buildDisplayList(ListTile tile, ListTile tail)
    {
        if(tile == null)
            return;
        //make the letter a string object, then add it to the field string
        String character = Character.toString(tile.getLetter());
        lettersInList += character;
        if(tile == tail)
            return;
        buildDisplayList(tile.getNext(), tail);
    }


    /**
     * wrapper function to find a given tile in the CLL
     * @param letter the letter to search for
     * @return the ListTile we're returning that contains that letter
     */
    public ListTile findTile(char letter)
    {
        return findTile(this.getNext(), this, letter);
    }

    /**
     * the recursive function called by findTile that traverses the list and returns the matched tile
     * @param tile the current position reference
     * @param tail the tail reference ( used as stopping condition)
     * @param letter the letter to match with
     * @return the ListTile to return
     */
    private ListTile findTile(ListTile tile, ListTile tail, char letter)
    {
        if(tile == null)
            return null;
        if(tile.getLetter() == letter)
            return tile;
        if(tile == tail)
        {
            return null;
        }
        return findTile(tile.getNext(), tail, letter);
    }
}
