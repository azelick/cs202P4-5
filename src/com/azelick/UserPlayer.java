package com.azelick;

import java.util.Scanner;

/**
 * Created by azelick on 8/1/16.
 * This is a UserPlayer, it extends Hand
 * and represents a player of the game. It handles the player interaction with
 * the game.
 */
public class UserPlayer extends Hand implements Cloneable {

    /**
     * arg constructor
     * @param name the name to use when creating the class
     */
   public UserPlayer(String name)
   {
        super(name);
   }

    /**
     * overriden clone method. To be used instead of the copy constructor
     * @return returns the newly made cloned object
     */
   public UserPlayer clone()
   {
       UserPlayer cloned = null;
       try {
           cloned = (UserPlayer) super.clone();
       } catch (CloneNotSupportedException e) {}
       return cloned;
   }

    /**
     * interact with the user and ask them what
     * letter they would like to place from their hand
     * @return returns the character of the user's choice
     */
   public char getUserChoice()
   {

       String response;

       Scanner scanner = new Scanner(System.in);
       System.out.println("What letter would you like to place?");
       response = new String(scanner.nextLine());
       return Character.toUpperCase(response.charAt(0));
   }

    /**
     * overriden method to have the user player make a play
     * handles all user interaction for their turn
     * @param board the board they will be making the play upon
     */
   public void makePlay(Board board)
   {
       int turnScore = 0;
       String response;
       char userChoice;
       Scanner scanner = new Scanner(System.in);
       do
       {
           userChoice = getUserChoice();
           System.out.println("Where would you like to place it?");
           System.out.print('\n' + "x: ");
           int x = scanner.nextInt();
           System.out.print('\n' + "y: ");
           int y = scanner.nextInt();

           turnScore += placeTileOnBoard(board, userChoice, y-1, x-1);
       } while(anotherLetter());
       System.out.println("Your score for the turn is: " + turnScore);
       addToScore(turnScore);
   }

    /**
     * check to see if the user wants to continue
     * @param response the user's response
     * @return return the boolean based on their response
     */
   protected boolean again(char response)
   {
       response = Character.toUpperCase(response);
       if(response == 'Y')
           return true;
       return false;
   }

    /**
     * ask the user if they wish to play another letter
     * @return boolean based on their response
     */
   protected boolean anotherLetter()
   {
       String response;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Would you like to input another letter?");
       response = new String(scanner.nextLine());
       return again(response.charAt(0));
   }
}
