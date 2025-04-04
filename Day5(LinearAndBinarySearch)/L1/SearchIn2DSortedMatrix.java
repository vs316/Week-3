package DSA.SearchingAlgorithms.BinarySearch;

public class SearchIn2DSortedMatrix {
    private static boolean searchTargetInMatrix(int[][] matrix, int target) {
        // Dimensions of the matrix
        int rows = matrix.length;
        if (rows == 0) return false; // Edge case: Empty matrix
        int cols = matrix[0].length;

        // Binary Search initialization
        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert 1D index to 2D indices
            int row = mid / cols;
            int col = mid % cols;

            int midValue = matrix[row][col];

            if (midValue == target) {
                return true; // Target found
            } else if (midValue < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int target = 16; // Example target value

        boolean isFound = searchTargetInMatrix(matrix, target);
        if (isFound) {
            System.out.println("Target value " + target + " found in the matrix.");
        } else {
            System.out.println("Target value " + target + " not found in the matrix.");
        }
    }
}