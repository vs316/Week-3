package DSA.AlgorithmRunTimeAnalysis;

import java.util.Random;

public class CompareBubbleMergeQuickSort {

    public static final String TABS = "\t\t\t\t\t\t";

    private static void bubbleSort(int[] num) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    // Bitwise XOR swap
//                    num[j] = num[j] ^ num[j + 1];
//                    num[j + 1] = num[j] ^ num[j + 1];
//                    num[j] = num[j] ^ num[j + 1];
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;

                }
            }
        }
    }

    private static void mergeSort(int[] num, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(num, left, mid);
            mergeSort(num, mid + 1, right);
            merge(num, left, mid, right);
        }
    }


    private static void merge(int[] num, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(num, left, leftArr, 0, n1);
        System.arraycopy(num, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                num[k++] = leftArr[i++];
            } else {
                num[k++] = rightArr[j++];
            }
        }
        while (i < n1) num[k++] = leftArr[i++];
        while (j < n2) num[k++] = rightArr[j++];
    }

    private static void quickSort(int[] num, int low, int high) {
        if (low < high) {
            int pi = partition(num, low, high);
            quickSort(num, low, pi - 1);
            quickSort(num, pi + 1, high);
        }
    }

    //    private static int partition(int[] arr, int low, int high) {
//        int pivot = arr[high];
//        int i = low - 1;
//        for (int j = low; j < high; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//
//        }
//        int temp = arr[i + 1];
//        arr[i + 1] = arr[high];
//        arr[high] = temp;
//        return i + 1;
//    }
    private static int partition(int[] arr, int low, int high) {
        // Find the middle index
        int mid = low + (high - low) / 2;

        // Perform median-of-three pivot selection
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }

        // The median is now at index `mid`, swap it with the last element (pivot position)
        swap(arr, mid, high);

        // Use the median as the pivot
        int pivot = arr[high];
        int i = low - 1;

        // Partitioning logic
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Place the pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int iteration1 = 1_000, iteration2 = 10_000, iteration3 = 1_000_000;
        int[] arr1 = new int[iteration1];
        int[] arr2 = new int[iteration2];
        int[] arr3 = new int[iteration3];
        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(1_000_000) + 1;
        }
        double b1Start = System.nanoTime();
        bubbleSort(arr1);
        double b1End = System.nanoTime();

        double b2Start = System.nanoTime();
        bubbleSort(arr2);
        double b2End = System.nanoTime();

        double b3Start = System.nanoTime();
        //bubbleSort(arr3);
        double b3End = System.nanoTime();
//Reshuffling elements
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(1_000_000) + 1;
        }

        double m1Start = System.nanoTime();
        mergeSort(arr1, 0, arr1.length - 1);
        double m1End = System.nanoTime();

        double m2Start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        double m2End = System.nanoTime();

        double m3Start = System.nanoTime();
        mergeSort(arr3, 0, arr3.length - 1);
        double m3End = System.nanoTime();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(1_000_000) + 1;
        }
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = random.nextInt(1_000_000) + 1;
        }
        //Reshuffling elements
        double q1Start = System.nanoTime();
        quickSort(arr1, 0, arr1.length - 1);
        double q1End = System.nanoTime();

        double q2Start = System.nanoTime();
        quickSort(arr2, 0, arr2.length - 1);
        double q2End = System.nanoTime();

        double q3Start = System.nanoTime();
        quickSort(arr3, 0, arr3.length - 1);
        double q3End = System.nanoTime();

        System.out.println("DataSet Size (N) \t Bubble Sort (O(N^2)) \t Merge Sort (O(N log N)) \t Quick Sort (O(N log N))");
        System.out.println(iteration1 + TABS + (b1End - b1Start) / 1_000_000 + "ms" + TABS + (m1End - m1Start) / 1_000_000 + "ms" + TABS + (q1End - q1Start) / 1_000_000 + "ms");
        System.out.println(iteration2 + TABS + (b2End - b2Start) / 1_000_000 + "ms" + TABS + (m2End - m2Start) / 1_000_000 + "ms" + TABS + (q2End - q2Start) / 1_000_000 + "ms");
        System.out.println(iteration3 + TABS + (b3End - b3Start) / 1_000_000 + "ms" + TABS + (m3End - m3Start) / 1_000_000 + "ms" + TABS + (q3End - q3Start) / 1_000_000 + "ms");
    }

}
