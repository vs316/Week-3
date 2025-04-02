package DSA.SortingAlgorithms;

import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // Create buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Add elements into buckets based on their value
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Determine bucket based on value
            buckets[bucketIndex].add(num);
        }

        // Sort each bucket
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket); // Sort using built-in sort
        }

        // Concatenate sorted buckets
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}