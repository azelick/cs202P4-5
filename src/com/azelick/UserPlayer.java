package com.azelick;

import java.util.Scanner;

/**
 * Created by azelick on 8/1/16.
 */
public class UserPlayer extends Hand {
   public UserPlayer()
   {

   }

   public UserPlayer(String name)
   {
        super(name);
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
        char userChoice = getUserChoice();
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

   protected void getAndSendTilesToBoard(Board board)
   {

   }
}
