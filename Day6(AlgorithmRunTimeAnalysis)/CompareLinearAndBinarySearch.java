package DSA.AlgorithmRunTimeAnalysis;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class CompareLinearAndBinarySearch {
    private static int linearSearch(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
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
        double t1Start = System.currentTimeMillis();
        int randomTarget=random.nextInt(1_000_000) + 1;
        int n1 = linearSearch(arr1, randomTarget);
        double t1End = System.currentTimeMillis();

        double t2Start = System.currentTimeMillis();
        int n2 = linearSearch(arr2, randomTarget);
        double t2End = System.currentTimeMillis();

        double t3Start = System.currentTimeMillis();
        int n3 = linearSearch(arr3, randomTarget);
        double t3End = System.currentTimeMillis();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        double b1Start = System.currentTimeMillis();
        Arrays.binarySearch(arr1, randomTarget);
        double b1End = System.currentTimeMillis();

        double b2Start = System.currentTimeMillis();
        Arrays.binarySearch(arr2, randomTarget);
        double b2End = System.currentTimeMillis();

        double b3Start = System.currentTimeMillis();
        Arrays.binarySearch(arr3, randomTarget);
        double b3End = System.currentTimeMillis();

        System.out.println("DataSet Size (N) \t Linear Search (O(N)) \t Binary Search (O(log N))");
        System.out.println(iteration1 + "\t\t\t\t\t\t" + (t1End - t1Start) + "ms\t\t\t\t\t" + (b1End - b1Start) + "ms");
        System.out.println(iteration2 + "\t\t\t\t\t\t" + (t2End - t2Start) + "ms\t\t\t\t\t" + (b2End - b2Start) + "ms");
        System.out.println(iteration3 + "\t\t\t\t\t\t" + (t3End - t3Start) + "ms\t\t\t\t\t" + (b3End - b3Start) + "ms");
    }
}
