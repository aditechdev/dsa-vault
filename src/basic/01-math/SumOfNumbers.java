import java.util.Scanner;

/**
 * 
 * Problem: Sum of Digits
 * 
 * Given a non-negative integer, calculate the sum of all its digits.
 * 
 * Algorithm:
 * 1. Extract the last digit using the modulo (%) operator.
 * 2. Add the extracted digit to the running sum.
 * 3. Remove the last digit using integer division (/).
 * 4. Repeat until the number becomes 0.
 *
 * Example:
 * 
 * Input: 12345
 * Iteration:
 * 
 * 12345 % 10 = 5 -> sum = 5
 * 1234 % 10 = 4 -> sum = 9
 * 123 % 10 = 3 -> sum = 12
 * 12 % 10 = 2 -> sum = 14
 * 1 % 10 = 1 -> sum = 15
 * 
 * Output: 15
 *
 * Time Complexity: O(d)
 * 
 * where d is the number of digits.
 * 
 * Space Complexity: O(1)
 */
public class SumOfNumbers {
    /**
     * 
     * Returns the sum of all digits of a number.
     * 
     * @param num Non-negative integer.
     * @return Sum of all digits.
     * 
     */
    public static long sumOfDigits(long num) {
        long sum = 0;
        // Process each digit from right to left
        while (num > 0) {
            // Extract the last digit
            sum += num % 10;
            // Remove the last digit
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            long num = sc.nextLong();
            System.out.println("Sum of digits for " + num + ": " + sumOfDigits(num));
        }
        sc.close();
    }
}
