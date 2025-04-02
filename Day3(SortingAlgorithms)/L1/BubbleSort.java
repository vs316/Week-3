package DSA.SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped=false;
            for (int j = 0; j < n-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) break; //Optimization:stop if no swaps occurred
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
