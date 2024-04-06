import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "orange", "grape", "kiwi", "melon", "pear"};

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = words[random.nextInt(words.length)];
        char[] displayWord = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            displayWord[i] = '_';
        }

        int attempts = 7;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word!");

        while (attempts > 0 && !wordGuessed) {
            System.out.println("Attempts left: " + attempts);
            System.out.println("Current word: " + String.valueOf(displayWord));

            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    displayWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("Incorrect guess!");
                drawHangman(7 - attempts);
            }

            if (String.valueOf(displayWord).equals(wordToGuess)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry! You didn't guess the word. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    public static void drawHangman(int attempts) {
        switch (attempts) {
            case 1:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 2:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |     |");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 3:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 4:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |");
                System.out.println(" |");
                break;
            case 5:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    /");
                System.out.println(" |");
                break;
            case 6:
                System.out.println("  _____");
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    / \\");
                System.out.println(" |");
                break;
            default:
                System.out.println(" |     |");
                System.out.println(" |     O");
                System.out.println(" |    /|\\");
                System.out.println(" |    / \\");
                break;
        }
    }
}

