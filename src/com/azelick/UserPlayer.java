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

   public UserPlayer clone()
   {
      UserPlayer cloned = this.clone();
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
       String response;
       char userChoice = getUserChoice();
       //TODO
       Scanner scanner = new Scanner(System.in);
       do
       {
           System.out.println("Where would you like to place it?");
           System.out.print('\n' + "x: ");
           int x = scanner.nextInt();
           System.out.print('\n' + "y: ");
           int y = scanner.nextInt();

           placeTileOnBoard(board, userChoice, x, y);

           System.out.println("Would you like to enter another letter? ");
           response = new String(scanner.nextLine());
       } while(again(response.charAt(0)));

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
