import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("Welcome to the Number Game!");

        int lowerLimit = 1;
        int upperLimit = 100;
        
        int maxAttempts = 10;

        int roundsWon = 0;

        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes")) {
            int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ":");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + (attempts + 1) + " attempts.");
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        }

        System.out.println("Thanks for playing! Rounds won: " + roundsWon);
        scanner.close();
    }
}
