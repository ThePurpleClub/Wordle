package Wordle;

import java.util.Scanner;
/*
 *  **Author Po Tin Mak
 *  Controls the game flow by interacting with the user and WordleGame.
 *	Contains the startGame method, which manages the game loop and user input.
 *	Calls game.playRound(guess) and displays the output to the player.
 * *
 */

public class WordleController {
	private WordleGame game;

    // Constructor to initialize the controller with a game instance
    public WordleController(WordleGame game) {
        this.game = game;
    }

    // Method to start the game and handle user interaction
    public void startGame() {
        System.out.println("Welcome to Wordle!");
        System.out.println("Guess the 5-letter word. You have " + game.getMaxRounds() + " rounds.");

        Scanner scanner = new Scanner(System.in);
        while (!game.isGameOver()) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().trim();
            String roundResult = game.playRound(guess);
            System.out.println(roundResult);
        }
        scanner.close();
    }

}
