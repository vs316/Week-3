package DSA.AlgorithmRunTimeAnalysis;

import java.util.*;

public class CompareDataStructuresForSearching {

    public static final String TABS = "\t\t\t\t"; // For output formatting

    public static void main(String[] args) {

        // Define dataset sizes to test
        int[] dataSetSizes = {1_000, 100_000, 1_000_000};

        // Print header
        System.out.println("Dataset Size (N) " + TABS
                + "Array Search (O(N))" + TABS
                + "HashSet Search (O(1))" + TABS
                + "TreeSet Search (O(logN))");

        // Test each dataset size
        for (int size : dataSetSizes) {
            // 1) Generate random data
            int[] testData = generateRandomData(size);

            // 2) Build data structures
            int[] array = Arrays.copyOf(testData, testData.length);

            HashSet<Integer> hashSet = new HashSet<>();
            for (int val : testData) {
                hashSet.add(val);
            }

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int val : testData) {
                treeSet.add(val);
            }

            // 3) Choose how many searches to perform.
            // For simplicity, let's do N searches with random keys from the array.
            int[] searchKeys = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                // 50% of the time we'll search for an existing element,
                // 50% of the time a random element that may or may not exist
                if (i % 2 == 0) {
                    searchKeys[i] = testData[random.nextInt(size)];
                } else {
                    searchKeys[i] = random.nextInt(size * 2); // Possibly not in dataset
                }
            }

            // 4) Measure search performance for each structure.
            double arraySearchTime = measureArraySearch(array, searchKeys);
            double hashSetSearchTime = measureHashSetSearch(hashSet, searchKeys);
            double treeSetSearchTime = measureTreeSetSearch(treeSet, searchKeys);

            // 5) Print the results in milliseconds
            System.out.println(size + TABS+TABS+
                    + arraySearchTime + " ms" + TABS+TABS+
                    + hashSetSearchTime + " ms" + TABS+TABS+
                    + treeSetSearchTime + " ms");
        }
    }

    /**
     * Generates an array of random integers of given size.
     * Values range from 0 to size*10 to reduce collisions.
     */
    private static int[] generateRandomData(int size) {
        Random random = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(size * 10);
        }
        return data;
    }

    /**
     * Performs a linear search on an array for each element in 'searchKeys'.
     * Returns the total time taken (in ms) to perform all searches.
     */
    private static double measureArraySearch(int[] array, int[] searchKeys) {
        long start = System.nanoTime();
        for (int key : searchKeys) {
            // Linear search
            for (int val : array) {
                if (val == key) {
                    break; // Found it, no need to continue
                }
            }
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; // Convert ns -> ms
    }

    /**
     * Performs a contains() check in a HashSet for each element in 'searchKeys'.
     * Returns the total time taken (in ms) to perform all searches.
     */
    private static double measureHashSetSearch(HashSet<Integer> hashSet, int[] searchKeys) {
        long start = System.nanoTime();
        for (int key : searchKeys) {
            hashSet.contains(key);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; // Convert ns -> ms
    }

    /**
     * Performs a contains() check in a TreeSet for each element in 'searchKeys'.
     * Returns the total time taken (in ms) to perform all searches.
     */
    private static double measureTreeSetSearch(TreeSet<Integer> treeSet, int[] searchKeys) {
        long start = System.nanoTime();
        for (int key : searchKeys) {
            treeSet.contains(key);
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; // Convert ns -> ms
    }
}
