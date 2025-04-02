package DSA.SortingAlgorithms;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }

        // Modify count array to store the cumulative count
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[--count[arr[i] - min]] = arr[i];
        }

        // Copy the sorted array back to the original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}