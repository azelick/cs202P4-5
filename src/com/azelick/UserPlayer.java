package com.azelick;

import java.util.Scanner;

/**
 * Created by azelick on 8/1/16.
 */
public class UserPlayer extends Hand {
   public UserPlayer()
   {

   }

   public UserPlayer(String name, Board board)
   {

   }

   public void queryDictionary(Board board)
   {

   }

   public char getUserChoice()
   {

       String response;
       do
       {
           Scanner scanner = new Scanner(System.in);
           System.out.println("What letter would you like to place?");
           response = new String(scanner.nextLine());
           response.toUpperCase();
           
       } while(again(response.charAt(0)));

   }

   public void makePlay(Board board)
   {

   }

   protected boolean again(char response)
   {
       if(response == 'Y')
           return true;
       return false;
   }

   protected boolean anotherLetter()
   {
       System.out.println("Would you like to input another letter?");
   }

   protected void getAndSendTilesToBoard(Board board)
   {

   }
}
