package DSA.HashMaps;
import java.util.*;
public class ZeroSumSubarrays {
//hash map to store cumulative sums and their indices
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int cumulativeSum = 0;

        //Initialize the hash map with sum 0 at index -1 (for subarrays starting from index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum+=arr[i];
            //check if cumulative sum exists in the map
            if(map.containsKey(cumulativeSum)){
                //if it exists, it means that there are subarrays with zero sum
                for(int startIndex: map.get(cumulativeSum)){
                    //add the indices of the zero-sum subarray to the result
                    result.add(new int[]{startIndex+1, i});
                }
            }
            //add the current index to the list of indices for this cumulative sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};

        List<int[]> result = findZeroSumSubarrays(arr);

        System.out.println("Zero-Sum Subarrays:");
        for (int[] subarray : result) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}