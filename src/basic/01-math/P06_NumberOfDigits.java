/**
 * Problem Definition: Count Number of Digits
 * Given an integer num, count and return the total number of digits present in num.
 * 
 * Formula / Concept:
 * Successive division by 10 until num becomes 0, or Math.floor(Math.log10(num)) + 1.
 * 
 * Algorithm:
 * 1. If num is 0, return 1.
 * 2. Take absolute value of num.
 * 3. While temp > 0, increment count and divide temp by 10.
 * 4. Return count.
 * 
 * Time: O(log10 n)  Space: O(1)
 */
public class P06_NumberOfDigits {

    // Dry Run
    /*
     * num = 12345
     * temp = 12345, count = 0
     * temp = 1234,  count = 1
     * temp = 123,   count = 2
     * temp = 12,    count = 3
     * temp = 1,     count = 4
     * temp = 0,     count = 5
     * Result: 5
     */

    // Code
    public static int countDigits(long num) {
        if (num == 0) return 1;
        int count = 0;
        long temp = Math.abs(num);
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        long n1 = 0;
        long n2 = 12345;
        long n3 = 9876543210L;

        System.out.println("Number of digits in " + n1 + ": " + countDigits(n1));
        System.out.println("Number of digits in " + n2 + ": " + countDigits(n2));
        System.out.println("Number of digits in " + n3 + ": " + countDigits(n3));
    }
}
