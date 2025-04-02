package DSA.SortingAlgorithms;

import java.util.*;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int exp = 1; // Exponent (1 = units place, 10 = tens place, etc.)

        while (max / exp > 0) {
            countingSortByDigit(arr, exp);
            exp *= 10; // Move to the next significant digit
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Digits (0-9)

        // Count occurrences of digits
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }

        // Update count array to store cumulative counts
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }

        // Copy the sorted array back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
