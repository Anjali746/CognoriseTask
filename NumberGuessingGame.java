import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        final int MAX_ATTEMPTS = 5; // Change this value to adjust the number of attempts allowed
        int attempts = 0;
        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");
        
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == randomNumber) {
                System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber);
        }
        
        scanner.close();
    }
}
