package DSA.SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

// public class Solution {

// public void quickSort(int [] lst) {
// /* Sorts an array in the ascending order in O(n log n) time */
// int n = lst.length;
// qSort(lst, 0, n - 1);
// }

// private void qSort(int [] lst, int lo, int hi) {
// if (lo < hi) {
// int p = partition(lst, lo, hi);
// qSort(lst, lo, p - 1);
// qSort(lst, p + 1, hi);
// }
// }

// private int partition(int [] lst, int lo, int hi) {
// /*
// Picks the last element hi as a pivot
// and returns the index of pivot value in the sorted array */
// int pivot = lst[hi];
// int i = lo;
// for (int j = lo; j < hi; ++j) {
// if (lst[j] < pivot) {
// int tmp = lst[i];
// lst[i] = lst[j];
// lst[j] = tmp;
// i++;
// }
// }
// int tmp = lst[i];
// lst[i] = lst[hi];
// lst[hi] = tmp;
// return i;
// }

// }