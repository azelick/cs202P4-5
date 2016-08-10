package com.azelick;

import java.util.Scanner;

/**
 * Created by azelick on 8/1/16.
 */
public class UserPlayer extends Hand implements Cloneable {
   public UserPlayer()
   {
   }

   public UserPlayer(String name)
   {
        super(name);
   }

   public UserPlayer makeClone()
   {
       UserPlayer cloned = null;
       try {
           cloned = (UserPlayer) super.clone();
       } catch (CloneNotSupportedException e) {}
       return cloned;
   }

   public char getUserChoice()
   {

       String response;

       Scanner scanner = new Scanner(System.in);
       System.out.println("What letter would you like to place?");
       response = new String(scanner.nextLine());
       return Character.toUpperCase(response.charAt(0));
   }

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

   protected boolean again(char response)
   {
       response = Character.toUpperCase(response);
       if(response == 'Y')
           return true;
       return false;
   }

   protected boolean anotherLetter()
   {
       String response;
       Scanner scanner = new Scanner(System.in);
       System.out.println("Would you like to input another letter?");
       response = new String(scanner.nextLine());
       return again(response.charAt(0));
   }
}
