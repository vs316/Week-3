package DSA.SearchingAlgorithms.FileHandling;

import java.io.*;

public class WriteToFIleUsingInputStreamReader {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\test.txt";
        System.out.println("Write to File( Type 'exit' to stop): ");
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filepath, true)) {
            String input;
            while (true) {
                System.out.println("Enter text: ");
                input = bufferedReader.readLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                fileWriter.write(input + System.lineSeparator());
            }
            System.out.println("User input has been written to the file successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
