package basic.m01_math;

/**
 * Problem Definition: Prime Number Check
 * Determine if a natural number n > 1 is prime, and print all prime numbers up to limit.
 * 
 * Formula / Concept:
 * A prime number has exactly two distinct positive divisors: 1 and itself.
 * Divisors occur in pairs up to √n.
 * 
 * Algorithm:
 * 1. If n <= 1, return false.
 * 2. Loop i from 2 to √n (i * i <= n).
 * 3. If n % i == 0, return false (composite).
 * 4. If loop completes without finding a divisor, return true (prime).
 * 
 * Time: O(√n)  Space: O(1)
 */
public class P08_PrimeNumber {

    // Dry Run
    /*
     * n = 29
     * i = 2 -> 29%2 != 0
     * i = 3 -> 29%3 != 0
     * i = 4 -> 29%4 != 0
     * i = 5 -> 29%5 != 0 (5*5 <= 29)
     * i = 6 -> 6*6 = 36 > 29 -> loop ends
     * Result: true (29 is prime)
     */

    // Code
    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void printPrimesUpTo(int limit) {
        System.out.print("Primes up to " + limit + ": ");
        for (int i = 2; i < limit; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int n1 = 29;
        int n2 = 48;

        System.out.println("Is " + n1 + " prime? " + (checkPrime(n1) ? "Yes" : "No"));
        System.out.println("Is " + n2 + " prime? " + (checkPrime(n2) ? "Yes" : "No"));
        printPrimesUpTo(30);
    }
}
