package com.azelick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by azelick on 8/5/16.
 * This is a derived class of tile
 * It adds functionality to allow it to
 * function as a circular linked list node
 */
public class ListTile extends Tile{
    //This is an extended tile that allows you to put it into a list
    private ListTile next;
    //building an array list of the characters in the subtree
    private String letterInList;

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
        return insertAtEnd(this.getNext(), new ListTile(tile), tail);
    }

    /**
     *  The recursive call to add at the end of the CLL
     * @param tile Where the function is currently pointing
     * @param newGuy The guy to add at the end of the list
     */
    private ListTile insertAtEnd(ListTile tile, ListTile newGuy, ListTile tail)
    {
        //this is bad news, means our list isn't a CLL
        if(tile == null)
            return null;
        //this means there's only one in the list
        if(tile == tail)
        {
           //here we're inserting
            ListTile temp = new ListTile(newGuy);
            temp.setNext(tail);
            tail.setNext(temp);
            return temp;
        }
        //there's more than one in the list and we're now inserting
        if(tile.getNext() == tail)
        {
            ListTile temp = new ListTile(newGuy);
            tile.setNext(temp);
            temp.setNext(tail.getNext());
            return temp;
        }

        //there's more than one in the list and we're recursing
        return insertAtEnd(tile.getNext(), newGuy, tail);
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

    public void displayAll()
    {
        displayAll(this);

    }

    private void displayAll(ListTile tile)
    {
        if(tile == null)
            return;
        display();
        displayAll(tile.getNext());

    }

    public ListTile replaceTile(ListTile tail, Tile tile, char letter)
    {
        if(tail == null)
            return null;
        return findAndReplaceTile(tail.getNext(), tail, tile, letter);
    }

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

    public String buildDisplayList()
    {
        if(letterInList == null)
            letterInList = new String();
        buildDisplayList(this.getNext(), this);
        return letterInList;
    }

    /**
     * recursive call to add the letters in the hand CLL to a char array
     */
    public void buildDisplayList(ListTile tile, ListTile tail)
    {
        if(tile == null)
            return;
        //make the letter a string object, then add it to the field string
        letterInList.concat(Character.toString(tile.getLetter()));
        if(tile == tail)
            return;
        buildDisplayList(tile.getNext(), tail);
    }

    public ListTile findTile(char letter)
    {
        return findTile(this.getNext(), this, letter);
    }

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
