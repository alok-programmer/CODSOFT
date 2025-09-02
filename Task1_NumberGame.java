import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int roundsWon = 0; 
        boolean play = true;

        System.out.println("=== Welcome to Number Guessing Game ===");

        while (play) {
            
            int num = rand.nextInt(100) + 1;
            int maxTries = 7; 
            int tries = 0;
            boolean correct = false;

            System.out.println("\nI have selected a number between 1 and 100");
            System.out.println("You have " + maxTries + " chances to guess it!");

            while (tries < maxTries) {
                System.out.print("Enter your guess: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    sc.next(); 
                    continue;
                }

                int guess = sc.nextInt();
                tries++;

                if (guess == num) {
                    System.out.println(" Correct! You guessed in " + tries + " tries.");
                    roundsWon++;
                    correct = true;
                    break;
                } else if (guess < num) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!correct) {
                System.out.println(" You lost! Number was: " + num);
            }

            System.out.println("Rounds won so far: " + roundsWon);

            // next round option
            System.out.print("Play again? (y/n): ");
            char c = sc.next().charAt(0);
            if (c == 'n' || c == 'N') {
                play = false;
            }
        }

        System.out.println("\nGame Over! Total rounds won: " + roundsWon);
        sc.close();
    }
}

