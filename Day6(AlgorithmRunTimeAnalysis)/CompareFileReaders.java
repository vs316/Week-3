package DSA.AlgorithmRunTimeAnalysis;

import java.io.*;

public class CompareFileReaders {

    public static final String TABS = "\t\t\t\t";

    private static final String FILE_PATH_1MB = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\FileHandling\\100mbexamplefile.txt";
    private static final String FILE_PATH_100MB = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\FileHandling\\100mbexamplefile.txt";
    private static final String FILE_PATH_500MB = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\DSA\\SearchingAlgorithms\\FileHandling\\100mbexamplefile.txt";

    private static long measureFileReader(String filePath) throws IOException {
        long start = System.nanoTime();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.readLine() != null) {
                // Processing
            }
        }
        return (System.nanoTime() - start) / 1_000_000; // Convert to milliseconds
    }

    private static long measureInputStreamReader(String filePath) throws IOException {
        long start = System.nanoTime();
        try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            while (inputStreamReader.readLine() != null) {
                // Processing
            }
        }
        return (System.nanoTime() - start) / 1_000_000; // Convert to milliseconds
    }

    public static void main(String[] args) throws IOException {
        System.out.println("File Size \t\t FileReader (ms) \t InputStreamReader (ms)");

        // 1MB File
        long frTime1MB = measureFileReader(FILE_PATH_1MB);
        long isrTime1MB = measureInputStreamReader(FILE_PATH_1MB);
        System.out.println("1MB" + TABS + frTime1MB + "ms" + TABS + isrTime1MB + "ms");

        // 100MB File
        long frTime100MB = measureFileReader(FILE_PATH_100MB);
        long isrTime100MB = measureInputStreamReader(FILE_PATH_100MB);
        System.out.println("100MB" + TABS + frTime100MB + "ms" + TABS + isrTime100MB + "ms");

        // 500MB File
        long frTime500MB = measureFileReader(FILE_PATH_500MB);
        long isrTime500MB = measureInputStreamReader(FILE_PATH_500MB);
        System.out.println("500MB" + TABS + frTime500MB + "ms" + TABS + isrTime500MB + "ms");
    }
}