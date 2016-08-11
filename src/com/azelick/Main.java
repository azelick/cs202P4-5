package com.azelick;

import java.util.Scanner;

public class Main {

    static int winningScore = 25;

    public static void main(String[] args) {
        // create a new board of size 10
        Board playingBoard = new Board(10);

        //scanner used to get user input
        Scanner scanner = new Scanner(System.in);
        String response;

        //create our players
        UserPlayer player1;
        UserPlayer player2;

        //greet users
        System.out.println("Welcome to scrabble!");
        System.out.println("There will be two players today.");

        //get player names, use that to create player objects
        //player 1
        System.out.println("What would the first player like to be called?");
        response = scanner.nextLine();
        player1 = new UserPlayer(response);
        //player 2
        System.out.println("What would the second player like to be called?");
        response = scanner.nextLine();
        player2 = new UserPlayer(response);

        //give each player a hand
        player1.drawNewHand(playingBoard);
        player2.drawNewHand(playingBoard);

        //make plays until one of them reaches the final number
        do {
            playingBoard.display();
            //player one's turn
            System.out.println(player1.getName() + " it's your turn!");
            player1.displayHand();
            player1.makePlay(playingBoard);
            //display score
            player1.displayScore();

            //display board in between player's turns
            playingBoard.display();

            //player two's turn
            System.out.println(player2.getName() + " it's your turn!");
            player2.displayHand();
            player2.makePlay(playingBoard);
            //display score
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

    /**
     * ask the user if they want to end the game
     * @return boolean based on their response
     */
    static public boolean quit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to quit? ");
        String response = scanner.nextLine();
        if (Character.toUpperCase(response.charAt(0)) == 'Y')
            return false;
        return true;
    }

    /**
     * compare the scores, to see if someone has eclipsed the game winning score
     * @param player1 the first player
     * @param player2 the second player
     * @return the boolean if at least one player has won
     */
    static public boolean checkScores(UserPlayer player1, UserPlayer player2)
    {
        if(player1.getScore() > winningScore || player2.getScore() > winningScore)
            return false;
        return true;
    }

}
