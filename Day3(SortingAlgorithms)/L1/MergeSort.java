package DSA.SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}

// import java.util.Arrays;
// public class Solution {

// public int [] merge_sort(int [] input) {
// if (input.length <= 1) {
// return input;
// }
// int pivot = input.length / 2;
// int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
// int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot,
// input.length));
// return merge(left_list, right_list);
// }

// public int [] merge(int [] left_list, int [] right_list) {
// int [] ret = new int[left_list.length + right_list.length];
// int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

// while (left_cursor < left_list.length &&
// right_cursor < right_list.length) {
// if (left_list[left_cursor] < right_list[right_cursor]) {
// ret[ret_cursor++] = left_list[left_cursor++];
// } else {
// ret[ret_cursor++] = right_list[right_cursor++];
// }
// }
// // append what is remain the above lists
// while (left_cursor < left_list.length) {
// ret[ret_cursor++] = left_list[left_cursor++];
// }
// while (right_cursor < right_list.length) {
// ret[ret_cursor++] = right_list[right_cursor++];
// }
// return ret;
// }
// }