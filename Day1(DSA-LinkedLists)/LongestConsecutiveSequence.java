package DSA.HashMaps;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        // Check for the start of a sequence
        for (int num : set) {
            if (!set.contains(num - 1)) {  // Only start counting if `num` is the start of a sequence
                int current = num;
                int currentStreak = 1;
                while (set.contains(current + 1)) {
                    current++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of longest consecutive sequence: " + longestConsecutive(nums));
    }
}