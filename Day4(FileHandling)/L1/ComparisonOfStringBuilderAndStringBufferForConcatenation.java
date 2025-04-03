package DSA.SearchingAlgorithms.FileHandling;

public class ComparisonOfStringBuilderAndStringBufferForConcatenation {
    public static void main(String[] args) {
        // Define the number of concatenations and the string to be appended
        int iterations = 1_000_000;
        String str = "hello";

        // Measure time for StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long timeTakenBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + timeTakenBuffer + " nanoseconds");

        // Measure time for StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();
        long timeTakenBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + timeTakenBuilder + " nanoseconds");

        // Compare the results
        if (timeTakenBuffer > timeTakenBuilder) {
            System.out.println("StringBuilder is faster than StringBuffer for concatenation.");
        } else {
            System.out.println("StringBuffer is faster than StringBuilder for concatenation.");
        }
    }
}