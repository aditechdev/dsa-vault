package basic.m01_math;

/**
 * Problem Definition: Palindrome Check
 * Check whether a given integer reads the same forwards and backwards.
 * 
 * Formula / Concept:
 * Reverse the number digit by digit: rev = rev * 10 + (num % 10).
 * Compare rev with original.
 * 
 * Algorithm:
 * 1. If num < 0, return false (negative numbers are not palindrome).
 * 2. Store original = num.
 * 3. Extract last digit using % 10, build reversed integer.
 * 4. Return true if original == reversed, false otherwise.
 * 
 * Time: O(log10 n)  Space: O(1)
 */
public class P07_PalindromeCheck {

    // Dry Run
    /*
     * num = 121
     * original = 121, revNum = 0
     * remainder = 1 -> revNum = 1, num = 12
     * remainder = 2 -> revNum = 12, num = 1
     * remainder = 1 -> revNum = 121, num = 0
     * original (121) == revNum (121) -> returns true
     */

    // Code
    public static boolean isPalindrome(int num) {
        if (num < 0) return false;
        int original = num;
        int revNum = 0;
        while (num != 0) {
            int remainder = num % 10;
            revNum = (revNum * 10) + remainder;
            num /= 10;
        }
        return original == revNum;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int t1 = 121;
        int t2 = -121;
        int t3 = 12345;

        System.out.println("Is " + t1 + " a palindrome? " + (isPalindrome(t1) ? "Yes" : "No"));
        System.out.println("Is " + t2 + " a palindrome? " + (isPalindrome(t2) ? "Yes" : "No"));
        System.out.println("Is " + t3 + " a palindrome? " + (isPalindrome(t3) ? "Yes" : "No"));
    }
}
