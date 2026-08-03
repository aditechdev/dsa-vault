package basic.M01_math;

/**
 * Problem Definition: Least Common Multiple (LCM)
 * Find the smallest positive integer that is divisible by both integers a and b.
 * 
 * Formula / Concept:
 * LCM(a, b) = (a * b) / GCD(a, b)
 * 
 * Algorithm:
 * 1. Find GCD of a and b by iterating downwards from min(a, b).
 * 2. Compute LCM = (a * b) / GCD.
 * 3. Return LCM.
 * 
 * Time: O(min(a, b))  Space: O(1)
 */
public class P05_LCM {

    // Dry Run
    /*
     * a = 6, b = 8
     * min(6, 8) = 6
     * i = 6 -> 6%6==0, 8%6!=0
     * ...
     * i = 2 -> 6%2==0, 8%2==0 -> GCD = 2
     * LCM = (6 * 8) / 2 = 24
     */

    // Code
    public static int calculateLCM(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int gcd = 1;
        for (int i = Math.min(a, b); i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return (a * b) / gcd;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int a = 6, b = 8;
        int x = 12, y = 15;

        System.out.println("LCM of " + a + " and " + b + " is: " + calculateLCM(a, b));
        System.out.println("LCM of " + x + " and " + y + " is: " + calculateLCM(x, y));
    }
}
