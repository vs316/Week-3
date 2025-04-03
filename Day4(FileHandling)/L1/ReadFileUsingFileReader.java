package DSA.SearchingAlgorithms.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\test.txt"; // Replace with your file path

        try (FileReader reader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}