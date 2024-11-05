package Wordle;

	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	//**Author Po Tin Mak
	/**This focuses on managing the game’s rules and logic.
	Handles guess checking, round progression, and updating the game state (gameOver).
	 * Returns feedback so WordleController can handle display and interaction.
	 * @author User
	 *
	 */
	
	public class WordleGame {
	    private List<String> wordList;
	    private int maxRounds;
	    private String answer;
	    private int currentRound;
	    private boolean gameOver;

	    // Constructor to initialize the game
	    public WordleGame(List<String> wordList, int maxRounds) {
	        this.wordList = wordList;
	        this.maxRounds = maxRounds;
	        this.answer = wordList.get(new Random().nextInt(wordList.size())).toLowerCase();
	        this.currentRound = 0;
	        this.gameOver = false;
	    }

	    // Method to check a player's guess
	    public int getMaxRounds() {
	        return maxRounds;
	    }

	    public List<String> checkGuess(String guess) {
	        List<String> result = new ArrayList<>();
	        for (int i = 0; i < guess.length(); i++) {
	            if (guess.charAt(i) == answer.charAt(i)) {
	                result.add("Correct");         // Correct letter and position
	            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
	                result.add("Present");     // Correct letter, wrong position
	            } else {
	                result.add("Incorrect");        // Incorrect letter
	            }
	        }
	        return result;
	    }

	    // Method to play a single round
	    public String playRound(String guess) {
	        if (guess.length() != 5 ) {
	            return "Invalid guess. Please enter a valid 5-letter word from the list.";
	        }

	        guess = guess.toLowerCase();
	        currentRound++;
	        List<String> result = checkGuess(guess);

	        String roundResult = "Round " + currentRound + ": " + guess.toUpperCase() + " -> " + result;

	        if (guess.equals(answer)) {
	            roundResult += "\nCongratulations! You've guessed the word correctly.";
	            gameOver = true;
	        } else if (currentRound == maxRounds) {
	            roundResult += "\nGame over! You've used all " + maxRounds + " rounds. The answer was '" + answer.toUpperCase() + "'.";
	            gameOver = true;
	        }
	        
	        return roundResult;
	    }

	    // Method to check if the game is over
	    public boolean isGameOver() {
	        return gameOver;
	    }
	
}
