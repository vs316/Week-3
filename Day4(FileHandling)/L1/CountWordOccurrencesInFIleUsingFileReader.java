package DSA.SearchingAlgorithms.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrencesInFIleUsingFileReader {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\test.txt";
        String word = "Hello";
        try (FileReader reader = new FileReader(filepath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String currentWord : words) {
                    if (currentWord.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
            }
            System.out.println("Number of times the word \"" + word + "\" occurs is: " + count);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
