// Hangman game
import java.util.*;

public class ques24 {

    private static final String[] WORDS = {
            "java", "programming", "hangman", "computer", "challenge", "console", "developer"
    };

    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');

        Set<Character> guessedLetters = new HashSet<>();
        int triesLeft = MAX_TRIES;

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word:");

        while (triesLeft > 0) {
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Tries left: " + triesLeft);

            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }

            guessedLetters.add(guess);

            if (wordToGuess.indexOf(guess) >= 0) {
                // Correct guess: reveal letters
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }

                // Check if word is fully guessed
                if (String.valueOf(guessedWord).equals(wordToGuess)) {
                    System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
                    break;
                }
            } else {
                // Wrong guess
                triesLeft--;
                System.out.println("Wrong guess!");
            }
        }

        if (triesLeft == 0) {
            System.out.println("\nGame Over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}
