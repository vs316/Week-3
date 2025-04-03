package DSA.SearchingAlgorithms.FileHandling;

import java.util.Scanner;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        StringBuilder str = new StringBuilder(sc.nextLine());
        System.out.println("Reversed String: " + str.reverse());
        sc.close();
    }
}
