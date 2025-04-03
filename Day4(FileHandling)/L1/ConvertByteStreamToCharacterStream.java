package DSA.SearchingAlgorithms.FileHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\test.txt";
        try (FileInputStream fileInputStream = new FileInputStream(filepath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
