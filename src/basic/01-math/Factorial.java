/**
 * 
 * Factorial
 * Calculate n! (factorial) of a non-negative integer.
 *
 * Formula:
 * n! = n × (n - 1) × ... × 2 × 1
 *
 * Examples:
 * 0! = 1
 * 5! = 120
 *
 * Algorithm:
 * 1. Initialize factorial = 1.
 * 2. Iterate from 1 to n.
 * 3. Multiply factorial by the current number.
 * 4. Return factorial.
 *
 * Time: O(n), Space: O(1)
 * 
 */
public class Factorial {
    /*
     * 
     * Dry Run (n = 5)
     *
     * i = 1 -> factorial = 1 × 1 = 1
     * i = 2 -> factorial = 1 × 2 = 2
     * i = 3 -> factorial = 2 × 3 = 6
     * i = 4 -> factorial = 6 × 4 = 24
     * i = 5 -> factorial = 24 × 5 = 120
     * 
     */
    public static int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be >= 0");

        int factorial = 1;

        for (int i = 1; i <= n; i++) {

            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {

        // Test Cases
        int t1 = 0;
        int t2 = 5;
        int t3 = 10;
        System.out.println("Factorial of " + t1 + " is " + factorial(t1)); // Output 1
        System.out.println("Factorial of " + t2 + " is " + factorial(t2)); // Output 120
        System.out.println("Factorial of " + t3 + " is " + factorial(t3)); // Output 3628800
    }
}