package DSA.SearchingAlgorithms.FileHandling;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        String distinctChars = removeDuplicateCharacters(s);
        System.out.println("String after removing duplicate characters: " + distinctChars);
        sc.close();
    }

    public static String removeDuplicateCharacters(String s) {
        StringBuilder str = new StringBuilder();
        HashSet<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!chars.contains(currentChar)) {
                chars.add(currentChar);
                str.append(currentChar);
            }
        }
        return str.toString();
    }
}
