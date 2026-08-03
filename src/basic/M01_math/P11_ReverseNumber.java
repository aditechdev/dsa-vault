package basic.M01_math;

/**
 * Problem Definition: Reverse Number
 * Given an integer num, reverse its digits.
 * 
 * Formula / Concept:
 * Extract last digit: remainder = num % 10
 * Append digit: reverseNum = reverseNum * 10 + remainder
 * Truncate last digit: num = num / 10
 * 
 * Algorithm:
 * 1. Initialize reverseNum = 0.
 * 2. While num != 0:
 *    a. Extract remainder = num % 10.
 *    b. Update reverseNum = (reverseNum * 10) + remainder.
 *    c. Update num /= 10.
 * 3. Return reverseNum.
 * 
 * Time: O(log10 n)  Space: O(1)
 */
public class P11_ReverseNumber {

    // Dry Run
    /*
     * num = 1234
     * 1. rem = 4 -> rev = 4, num = 123
     * 2. rem = 3 -> rev = 43, num = 12
     * 3. rem = 2 -> rev = 432, num = 1
     * 4. rem = 1 -> rev = 4321, num = 0
     * Result: 4321
     */

    // Code
    public static int reverseInteger(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int remainder = num % 10;
            reverseNum = (reverseNum * 10) + remainder;
            num /= 10;
        }
        return reverseNum;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int n1 = 1234;
        int n2 = -567;
        int n3 = 1000;

        System.out.println("Reversed of " + n1 + ": " + reverseInteger(n1));
        System.out.println("Reversed of " + n2 + ": " + reverseInteger(n2));
        System.out.println("Reversed of " + n3 + ": " + reverseInteger(n3));
    }
}
