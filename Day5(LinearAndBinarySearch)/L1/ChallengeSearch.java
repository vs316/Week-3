package DSA.SearchingAlgorithms.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class ChallengeSearch {

    // Linear Search to find the first missing positive integer.
    // This method uses an extra boolean array to mark the presence of numbers 1..n.
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        // Create a boolean array to mark numbers in the range 1 to n.
        boolean[] present = new boolean[n + 1]; // Index 0 is unused

        // Mark all valid positive numbers (<= n) that are present in arr.
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // The first index i (from 1 to n) that is not marked indicates the missing positive integer.
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If all numbers 1..n are present, then the missing positive is n + 1.
        return n + 1;
    }

    // Binary Search to find the index of the target number in a sorted array.
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid; // Target found at index mid.
            } else if (arr[mid] < target) {
                left = mid + 1; // Continue searching in the right half.
            } else {
                right = mid - 1; // Continue searching in the left half.
            }
        }
        return -1; // Target not found.
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the list of integers.
        System.out.println("Enter the number of integers in the list:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Task 1: Linear search for the first missing positive integer.
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);

        // Task 2: Binary search for the target value.
        // Since binary search requires a sorted array, we sort a copy of the input array.
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        System.out.println("Sorted array for Binary Search: " + Arrays.toString(sortedArr));

        System.out.println("Enter the target integer for binary search:");
        int target = scanner.nextInt();
        int targetIndex = binarySearch(sortedArr, target);

        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index " + targetIndex + " in the sorted array.");
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }

        scanner.close();
    }
}