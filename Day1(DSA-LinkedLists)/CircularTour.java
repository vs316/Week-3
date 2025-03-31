package DSA.StacksAndQueues;

class CircularTour {

    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length; // Number of petrol pumps

        int totalSurplus = 0;  // Tracks the total surplus petrol for the entire tour
        int currentSurplus = 0;  // Tracks surplus petrol for the current tour segment
        int startIndex = 0;  // Tracks the potential starting point

        for (int i = 0; i < n; i++) {
            // Calculate the surplus petrol at the current pump
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If currentSurplus becomes negative, we cannot start from the current startIndex
            if (currentSurplus < 0) {
                startIndex = i + 1;  // Move the starting point to the next pump
                currentSurplus = 0;  // Reset the currentSurplus for the new segment
            }
        }

        // If totalSurplus is negative, no solution exists
        return totalSurplus >= 0 ? startIndex : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startingPoint = findStartingPoint(petrol, distance);
        if (startingPoint != -1) {
            System.out.println("The truck can start the tour at petrol pump: " + startingPoint);
        } else {
            System.out.println("No solution exists. The tour cannot be completed.");
        }
    }
}