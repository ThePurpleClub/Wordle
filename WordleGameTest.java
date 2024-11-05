package Wordle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WordleGameTest {
    private WordleGame game;
    private List<String> wordList = Arrays.asList("apple", "beach", "crate", "drone", "flute");

    @BeforeEach
    void setUp() {
        // Initialize a new game with a fixed word and max rounds for testing
        game = new WordleGame(wordList, 6);
    }

    @Test
    void testCorrectGuess() {
        // Set a known answer for predictable testing
        game = new WordleGame(Arrays.asList("apple"), 6);
        
        String result = game.playRound("apple");
        assertTrue(result.contains("Congratulations!"), "The game should declare a win for a correct guess.");
        assertTrue(game.isGameOver(), "Game should be over after a correct guess.");
    }

    @Test
    void testIncorrectGuess() {
        game = new WordleGame(Arrays.asList("apple"), 6);

        String result = game.playRound("beach");
        assertFalse(result.contains("Congratulations!"), "The game should not declare a win for an incorrect guess.");
        assertFalse(game.isGameOver(), "Game should not be over after one incorrect guess.");
    }

    @Test
    void testGameOverAfterMaxRounds() {
        game = new WordleGame(Arrays.asList("apple"), 3);  // Set max rounds to 3 for quicker testing

        game.playRound("beach");
        game.playRound("drone");
        String result = game.playRound("crate");

        assertTrue(result.contains("Game over!"), "The game should declare game over after max rounds.");
        assertTrue(game.isGameOver(), "Game should be over after reaching max rounds.");
    }

    @Test
    void testFeedbackForPresentAndCorrectLetters() {
        game = new WordleGame(Arrays.asList("apple"), 6);

        List<String> feedback = game.checkGuess("peach");

        assertEquals("Present", feedback.get(0), "First letter should be 'Present' (in answer, wrong position).");
        assertEquals("Present", feedback.get(1), "Second letter should be 'Present' (in answer, wrong position).");
        assertEquals("Incorrect", feedback.get(2), "Third letter should be 'Incorrect' (not in answer).");
        assertEquals("Correct", feedback.get(3), "Fourth letter should be 'Correct' (right letter and position).");
        assertEquals("Incorrect", feedback.get(4), "Fifth letter should be 'Incorrect' (not in answer).");
    }
}
