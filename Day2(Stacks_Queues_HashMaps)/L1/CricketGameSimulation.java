package DSA;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class CricketGameSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String batsman = "Rohit Sharma";
        ArrayList<Integer> rohitRuns = new ArrayList<>();
        ArrayList<Integer> gillRuns = new ArrayList<>();
        int score = 0; // Total score of the game

        System.out.println("Welcome to the Cricket Game Simulation!");
        System.out.println("Instructions:");
        System.out.println("Enter 0 - Player is out.");
        System.out.println("Enter any number > 1 - Generate random number (runs between 1 to 6).");
        System.out.println("Enter 1 - Player is run out.");
        System.out.println("Enter a character - Change batsman.");
        System.out.println("Let the game begin!");

        while (true) {
            System.out.print("Enter your action: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("Player is out! Final Score: " + score);
                break;
            } else if (input.equals("1")) {
                System.out.println("Player is run out! Final Score: " + score);
                break;
            } else if (isNumeric(input)) {
                int userInput = Integer.parseInt(input);
                if (userInput > 1) {
                    int runs = random.nextInt(6) + 1;
                    score += runs;

                    if (batsman.equals("Rohit Sharma")) {
                        rohitRuns.add(runs);
                    } else {
                        gillRuns.add(runs);
                    }

                    System.out.println("Batsman " + batsman + " scored " + runs + " runs! Total Score: " + score);
                }
            } else {
                batsman = batsman.equals("Rohit Sharma") ? "Gill" : "Rohit Sharma";
                System.out.println("Batsman changed to: " + batsman);
            }
        }

        System.out.println("Game Over!");
        System.out.println("Runs scored by Rohit Sharma: " + rohitRuns);
        System.out.println("Runs scored by Gill: " + gillRuns);

        scanner.close();
    }


    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}