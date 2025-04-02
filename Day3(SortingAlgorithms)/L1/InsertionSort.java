package DSA.SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n=arr.length;
        for (int i = 1; i < n; i++) {
            int key=arr[i];
            int j=i-1;
            //Move elements that are greater than key to one position ahead
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
