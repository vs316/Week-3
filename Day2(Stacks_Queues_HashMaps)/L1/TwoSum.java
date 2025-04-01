package DSA.HashMaps;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // key: number, value: index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If the complement exists in the map, return the pair of indices.
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store the index of the current number.
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution exists.");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;  // expecting indices for numbers 2 and 7
        int[] indices = twoSum(nums, target);
        System.out.println("Indices: " + indices[0] + ", " + indices[1]);
    }
}