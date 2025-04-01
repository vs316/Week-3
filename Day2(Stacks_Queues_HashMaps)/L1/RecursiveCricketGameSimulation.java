package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RecursiveCricketGameSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        HashMap<String, ArrayList<Integer>> playerScores = new HashMap<>();
        int totalScore = 0;

        System.out.println("Welcome to the Recursive Cricket Game Simulation!");
        System.out.println("Instructions:");
        System.out.println("Enter 0 - Player is out.");
        System.out.println("Enter any number >1 - Generate random number (runs between 1 to 6).");
        System.out.println("Enter 1 - Player is run out.");
        System.out.println("Let the game begin!");

        totalScore = simulateInnings(1, 10, playerScores, totalScore, scanner, random);

        System.out.println("\nGame Over!");
        System.out.println("Final Total Score: " + totalScore);
        System.out.println("Player Performance:");
        for (String player : playerScores.keySet()) {
            System.out.println(player + ": " + playerScores.get(player) + " (Total: " + getTotalRuns(playerScores.get(player)) + ")");
        }

        scanner.close();
    }

    private static int simulateInnings(int currentPlayer, int maxPlayers, HashMap<String, ArrayList<Integer>> playerScores, int totalScore, Scanner scanner, Random random) {
        if (currentPlayer > maxPlayers) {
            return totalScore; // Base case: All players have batted
        }

        System.out.print("Enter the name of the batsman: ");
        String batsman = scanner.nextLine();
        playerScores.put(batsman, new ArrayList<>());

        System.out.println(batsman + " is batting...");
        totalScore = simulatePlayerBatting(batsman, playerScores, totalScore, scanner, random);

        System.out.println(batsman + " is out! Total runs scored: " + getTotalRuns(playerScores.get(batsman)));

        return simulateInnings(currentPlayer + 1, maxPlayers, playerScores, totalScore, scanner, random);
    }


    private static int simulatePlayerBatting(String batsman, HashMap<String, ArrayList<Integer>> playerScores, int totalScore, Scanner scanner, Random random) {
        System.out.print("Enter your action: ");
        String input = scanner.nextLine();

        if (input.equals("0") || input.equals("1")) {
            // Player is out or run out, end their turn
            return totalScore;
        } else if (isNumeric(input)&& Integer.parseInt(input)>1) {
            int runs = random.nextInt(6) + 1; // Generate random runs between 1 and 6
            playerScores.get(batsman).add(runs); // Add the runs to the current player's score
            totalScore += runs;
            System.out.println(batsman + " scored " + runs + " runs! Current Total Score: " + totalScore);
            return simulatePlayerBatting(batsman, playerScores, totalScore, scanner, random); // Recursive call for next action
        } else {
            System.out.println("Invalid input. Please enter a valid action.");
            return simulatePlayerBatting(batsman, playerScores, totalScore, scanner, random); // Retry input
        }
    }


    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getTotalRuns(ArrayList<Integer> runs) {
        int total = 0;
        for (int run : runs) {
            total += run;
        }
        return total;
    }
}