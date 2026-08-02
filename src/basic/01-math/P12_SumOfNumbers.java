/**
 * Problem Definition: Sum of Digits
 * Given a non-negative integer, calculate the sum of all its digits.
 * 
 * Formula / Concept:
 * Extract each digit using modulo 10 (%) and accumulate into running total.
 * 
 * Algorithm:
 * 1. Initialize sum = 0.
 * 2. Take absolute value of num.
 * 3. While num > 0:
 *    a. sum += num % 10.
 *    b. num /= 10.
 * 4. Return sum.
 * 
 * Time: O(log10 n)  Space: O(1)
 */
public class P12_SumOfNumbers {

    // Dry Run
    /*
     * num = 12345
     * 12345 % 10 = 5 -> sum = 5,  num = 1234
     * 1234  % 10 = 4 -> sum = 9,  num = 123
     * 123   % 10 = 3 -> sum = 12, num = 12
     * 12    % 10 = 2 -> sum = 14, num = 1
     * 1     % 10 = 1 -> sum = 15, num = 0
     * Result: 15
     */

    // Code
    public static long sumOfDigits(long num) {
        long sum = 0;
        long temp = Math.abs(num);
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        long n1 = 12345;
        long n2 = 999;

        System.out.println("Sum of digits for " + n1 + ": " + sumOfDigits(n1));
        System.out.println("Sum of digits for " + n2 + ": " + sumOfDigits(n2));
    }
}
