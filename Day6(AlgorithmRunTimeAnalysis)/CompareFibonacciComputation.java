package DSA.AlgorithmRunTimeAnalysis;

public class CompareFibonacciComputation {

    public static final String TABS = "\t\t\t\t";

    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n1 = 10; // Fibonacci(10)
        int n2 = 30; // Fibonacci(30)
        int n3 = 50; // Fibonacci(50)

        // Measuring Recursive
        long recStart1 = System.nanoTime();
        fibonacciRecursive(n1);
        long recEnd1 = System.nanoTime();

        long recStart2 = System.nanoTime();
        fibonacciRecursive(n2); // Warning: Slow for larger n
        long recEnd2 = System.nanoTime();

        // Measuring Iterative
        long iterStart1 = System.nanoTime();
        fibonacciIterative(n1);
        long iterEnd1 = System.nanoTime();

        long iterStart2 = System.nanoTime();
        fibonacciIterative(n2);
        long iterEnd2 = System.nanoTime();

        long iterStart3 = System.nanoTime();
        fibonacciIterative(n3);
        long iterEnd3 = System.nanoTime();

        System.out.println("Fibonacci (N) \t Recursive (O(2^n)) \t Iterative (O(N))");
        System.out.println(n1 + TABS + (recEnd1 - recStart1) / 1_000_000 + "ms" + TABS +TABS+
                (iterEnd1 - iterStart1) / 1_000_000 + "ms");

        System.out.println(n2 + TABS + (recEnd2 - recStart2) / 1_000_000 + "ms" + TABS +TABS+
                (iterEnd2 - iterStart2) / 1_000_000 + "ms");

        System.out.println(n3 + TABS + "Unfeasible (>1hr)" + TABS+
                (iterEnd3 - iterStart3) / 1_000_000 + "ms");
    }
}
