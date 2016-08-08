package com.azelick;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Board playingBoard = new Board(10);

        Scanner scanner = new Scanner(System.in);
        String response;
        UserPlayer player1;
        UserPlayer player2;

        //greet users
        System.out.println("Welcome to scrabble!");
        System.out.println("There will be two players today.");

        //get player names
        //player 1
        System.out.println("What would the first player like to be called?");
        response = scanner.nextLine();
        player1 = new UserPlayer(response);
        response = null;

        //player 2
        System.out.println("What would the second player like to be called?");
        response = scanner.nextLine();
        player2 = new UserPlayer(response);

        //give each player a hand
        player1.drawNewHand(playingBoard);
        player2.drawNewHand(playingBoard);

//        //TODO for testing purposes
//        UserPlayer player3 = new UserPlayer();
//        try {
//            player3 = player1.makeClone();
//        } catch(CloneNotSupportedException e) {}
//        player1.display();
//        player3.display();

        //make plays until one of them reaches the final number
        do {
            playingBoard.display();
            System.out.println(player1.getName() + " it's your turn!");
            player1.displayHand();
            player1.makePlay(playingBoard);
            //display score
            //System.out.println(player1.getName() + " your score is: " + player1.getScore());
            player1.displayScore();

            playingBoard.display();

            System.out.println(player2.getName() + " it's your turn!");
            player2.displayHand();
            player2.makePlay(playingBoard);
            //display score
            //System.out.println(player2.getName() + " your score is: " + player2.getScore());
            player2.displayScore();


            playingBoard.display();
        } while(checkScores(player1, player2) && quit());

        //check who won and celebrate them
        if(player1.getScore() > player2.getScore())
            System.out.println(player1.getName() + " has won!");
        else if (player1.getScore() == player2.getScore())
            System.out.println("Users have tied!");
        else
            System.out.println(player2.getName() + " has won!");

    }

    static public boolean quit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to quit? ");
        String response = scanner.nextLine();
        if (Character.toUpperCase(response.charAt(0)) == 'Y')
            return false;
        return true;
    }
    static public boolean checkScores(UserPlayer player1, UserPlayer player2)
    {
        if(player1.getScore() > 25 || player2.getScore() > 25)
            return false;
        return true;
    }

}
