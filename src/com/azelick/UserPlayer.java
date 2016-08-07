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

   public UserPlayer makeClone() throws CloneNotSupportedException
   {
      UserPlayer cloned = (UserPlayer) this.clone();
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

           placeTileOnBoard(board, userChoice, y-1, x-1);

           System.out.println("Would you like to enter another letter? ");
           Scanner scan2 = new Scanner(System.in);
           String newResponse = scan2.nextLine();
           response = new String(newResponse);
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
