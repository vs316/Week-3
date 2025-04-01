package DSA.HashMaps;

import java.util.HashSet;

public class PairWithTargetSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            // Check if the complement exists in the HashSet
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num); // Store this number for future reference
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9};
        int target = 13; // (4 + 9 = 13)
        System.out.println("Pair exists: " + hasPairWithSum(arr, target));
    }
}