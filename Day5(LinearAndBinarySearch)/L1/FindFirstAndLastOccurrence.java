package DSA.SearchingAlgorithms.BinarySearch;

public class FindFirstAndLastOccurrence {
    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstOccurrence = mid; // Record the index
                right = mid - 1; // Continue searching to the left
            } else if (arr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return firstOccurrence;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                lastOccurrence = mid; // Record the index
                left = mid + 1; // Continue searching to the right
            } else if (arr[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }
        return lastOccurrence;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5, 6}; // Example sorted array
        int target = 5; // Target element to search

        int firstIndex = findFirstOccurrence(arr, target);
        int lastIndex = findLastOccurrence(arr, target);

        if (firstIndex != -1 && lastIndex != -1) {
            System.out.println("First occurrence of " + target + ": " + firstIndex);
            System.out.println("Last occurrence of " + target + ": " + lastIndex);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }
}