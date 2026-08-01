import java.util.Scanner;

/**
 * Prime Number
 *
 * A prime number is a natural number greater than 1
 * that has exactly two positive factors: 1 and itself.
 *
 * Algorithm:
 * 1. If n <= 1, it is not prime.
 * 2. Check divisibility from 2 to √n.
 * 3. If any divisor exists (n % i == 0), it is not prime.
 * 4. Otherwise, it is prime.
 *
 * Why check only up to √n?
 * Factors always occur in pairs.
 *
 * Example: n = 48
 * 1 × 48
 * 2 × 24
 * 3 × 16
 * 4 × 12
 * 6 × 8
 *
 * After √48 ≈ 6.9, the factor pairs repeat in reverse.
 * If no factor is found up to √n, no larger factor can exist.
 *
 * Time Complexity: O(√n)
 * Space Complexity: O(1)
 */
public class PrimeNumber {

    public static boolean checkPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void printPrimesUpTo(int limit) {
        System.out.println("Prime numbers up to " + limit + ":");
        for (int i = 2; i < limit; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printPrimesUpTo(num);
        }
        sc.close();
    }
}