package DSA.SearchingAlgorithms.LinearSearch;

import java.util.Scanner;

public class LinearSearchForSpecificWord {
    private static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) { // Case-insensitive comparison
                return sentence; // Return the first sentence containing the word
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of sentences: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline character

        String[] sentences = new String[n];
        System.out.println("Enter the sentences: ");
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine(); // Populate the array with sentences
        }

        System.out.println("Enter the word to search for: ");
        String word = sc.nextLine();

        String result = findSentenceContainingWord(sentences, word); // Perform the search
        System.out.println("Result: " + result);

        sc.close(); // Close the Scanner
    }
}