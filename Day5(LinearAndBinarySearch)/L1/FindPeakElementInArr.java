package DSA.SearchingAlgorithms.BinarySearch;

public class FindPeakElementInArr {
    private static int binarySearchToFindPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare mid with its neighbor to determine the direction
            if (arr[mid] < arr[mid + 1]) {
                // Peak must be in the right half
                left = mid + 1;
            } else {
                // Peak must be in the left half (including mid)
                right = mid;
            }
        }
        // When left == right, we are at the peak
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3,20, 20, 4, 1, 0}; // Example array
        int peakElement = binarySearchToFindPeakElement(arr);
        System.out.println("A peak element in the array: " + peakElement);
    }
}