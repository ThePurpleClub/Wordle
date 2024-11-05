package Wordle;

import java.util.Arrays;
import java.util.List;
/* Author Po Tin Mak
 * Sets up game parameters, such as the word list and max rounds.
 * Initializes both the WordleGame and WordleController instances and starts the game.
 */

public class WordleMain {
	 public static void main(String[] args) {
	        // Example word list and game configuration
	        List<String> wordList = Arrays.asList("apple", "berry", "charm", "delta", "eagle", "flame", "grape", "honey"); //* example wordlist
	        int maxRounds = 6;

	        // Initialize the game and controller
	        WordleGame game = new WordleGame(wordList, maxRounds);
	        WordleController controller = new WordleController(game);

	        // Start the game through the controller
	        controller.startGame();
	    }

}
