package DSA.SearchingAlgorithms.LinearSearch;

import java.util.Scanner;

public class LinearSearchToFindFirstNegativeNumber {
    private static int findFirstNegativeNumberInArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // Correctly check the value at index `i`
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in the array: ");
        int n = sc.nextInt(); // Read the number of elements in the array

        int[] arr = new int[n]; // Initialize the array
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Populate the array
        }

        int index = findFirstNegativeNumberInArray(arr); // Call the method
        if (index != -1) {
            System.out.println("Index of first negative number in the array = " + index);
        } else {
            System.out.println("The array does not contain any negative numbers.");
        }

        sc.close(); // Close the Scanner
    }
}