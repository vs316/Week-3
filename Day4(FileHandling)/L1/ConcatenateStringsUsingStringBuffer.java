package DSA.SearchingAlgorithms.FileHandling;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        System.out.println("Enter strings to concatenate (leave empty to finish): ");
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) { // Stop when the user enters an empty string
                break;
            }
            strings.add(input);
        }

        String concatenatedString = concatenateString(strings);
        System.out.println("Concatenated String using StringBuffer: " + concatenatedString);
        sc.close();
    }

    public static String concatenateString(ArrayList<String> strings) {
        StringBuffer concatenatedString = new StringBuffer();
        for (String s : strings) {
            concatenatedString.append(s);
        }
        return concatenatedString.toString();
    }
}