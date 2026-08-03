package basic.M01_math;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Definition: Greatest Common Divisor (GCD)
 * Find the largest positive integer that divides two integers or each integer in a given list of numbers.
 *
 * Formula / Concept:
 * GCD(a, b) = GCD(b, a % b) until b = 0 (Euclidean Algorithm)
 * Or loop downwards from min(a, b) to 1 to find common divisor.
 *
 * Algorithm:
 * 1. For two numbers: Loop i from min(a, b) down to 1; first i dividing both is GCD.
 * 2. For list of numbers: Loop i from min(numbers) down to 1; first i dividing all is GCD.
 *
 * Time: O(min(a, b)) or O(min(N) * L)  Space: O(1)
 */
public class P04_GCDOfNumber {

    // Dry Run
    /*
     * GCD(12, 20):
     * min(12, 20) = 12
     * i = 12 -> 12%12==0, 20%12!=0
     * ...
     * i = 4  -> 12%4==0, 20%4==0 -> GCD = 4
     * 
     * List: [50, 35, 90]
     * minNumber = 35
     * i = 5 -> 50%5 == 0, 35%5 == 0, 90%5 == 0 -> GCD = 5
     */

    // Code
    public static int gcd(int a, int b) {
        int gcd = 1;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static int findGCD(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        int minNumber = numbers.get(0);
        for (int num : numbers) {
            if (num < minNumber) {
                minNumber = num;
            }
        }

        for (int i = minNumber; i >= 1; i--) {
            boolean isGCD = true;
            for (int num : numbers) {
                if (num % i != 0) {
                    isGCD = false;
                    break;
                }
            }
            if (isGCD) {
                return i;
            }
        }
        return 1;
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        System.out.println("GCD of 12 and 20: " + gcd(12, 20));

        List<Integer> list1 = Arrays.asList(50, 35, 90);
        List<Integer> list2 = Arrays.asList(12, 18, 24);

        System.out.println("GCD of " + list1 + " is: " + findGCD(list1));
        System.out.println("GCD of " + list2 + " is: " + findGCD(list2));
    }
}
