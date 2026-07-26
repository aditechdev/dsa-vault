package basic.algorithm;

/**
 * <h1>Recursive Fibonacci Sequence</h1>
 *
 * <h2>Problem Statement:</h2>
 * Return the N-th term in the Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13...
 *
 * <h2>Approach & Key Intuition:</h2>
 * Uses recurrence relation f(n) = f(n-1) + f(n-2) with base cases f(0)=0 and f(1)=1.
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(2^N) - Exponential recursion tree (un-memoized)</li>
 *   <li><b>Space Complexity:</b> O(N) - Max stack depth</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class FibonacciSeries {

    public static int fibonacciRecursion(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("6th Fibonacci term: " + fibonacciRecursion(n));
    }
}
