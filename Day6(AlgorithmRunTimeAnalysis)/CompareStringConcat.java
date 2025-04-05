package DSA.AlgorithmRunTimeAnalysis;

public class CompareStringConcat {

    public static final String TABS = "\t\t\t\t\t\t";

    private static final int ITERATION_1 = 1_000;
    private static final int ITERATION_2 = 10_000;
    private static final int ITERATION_3 = 1_000_000;

    private static String concatWithString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "hello";
        }
        return result;
    }

    private static String concatWithStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }

    private static String concatWithStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        long s1Start = System.nanoTime();
        concatWithString(ITERATION_1);
        long s1End = System.nanoTime();

        long s2Start = System.nanoTime();
        concatWithString(ITERATION_2);
        long s2End = System.nanoTime();

        // long s3Start = System.nanoTime();
        // concatWithString(ITERATION_3); // Commented out to avoid extreme delay
        // long s3End = System.nanoTime();

        long sb1Start = System.nanoTime();
        concatWithStringBuilder(ITERATION_1);
        long sb1End = System.nanoTime();

        long sb2Start = System.nanoTime();
        concatWithStringBuilder(ITERATION_2);
        long sb2End = System.nanoTime();

        long sb3Start = System.nanoTime();
        concatWithStringBuilder(ITERATION_3);
        long sb3End = System.nanoTime();

        long sbf1Start = System.nanoTime();
        concatWithStringBuffer(ITERATION_1);
        long sbf1End = System.nanoTime();

        long sbf2Start = System.nanoTime();
        concatWithStringBuffer(ITERATION_2);
        long sbf2End = System.nanoTime();

        long sbf3Start = System.nanoTime();
        concatWithStringBuffer(ITERATION_3);
        long sbf3End = System.nanoTime();

        System.out.println("DataSet Size (N) \t String (O(N^2)) \t StringBuilder (O(N)) \t StringBuffer (O(N))");
        System.out.println(ITERATION_1 + TABS +
                (s1End - s1Start) / 1_000_000 + "ms" + TABS +
                (sb1End - sb1Start) / 1_000_000 + "ms" + TABS +
                (sbf1End - sbf1Start) / 1_000_000 + "ms");

        System.out.println(ITERATION_2 + TABS +
                (s2End - s2Start) / 1_000_000 + "ms" + TABS +
                (sb2End - sb2Start) / 1_000_000 + "ms" + TABS +
                (sbf2End - sbf2Start) / 1_000_000 + "ms");

        System.out.println(ITERATION_3 + TABS +
                "Skipped" + TABS +
                (sb3End - sb3Start) / 1_000_000 + "ms" + TABS +
                (sbf3End - sbf3Start) / 1_000_000 + "ms");
    }
}
