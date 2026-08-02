/**
 * Problem Definition: Random Number Generation
 * Generate a pseudo-random integer in the range [0, bound).
 * 
 * Formula / Concept:
 * java.util.Random.nextInt(bound) returns a uniform pseudo-random int between 0 (inclusive) and bound (exclusive).
 * 
 * Algorithm:
 * 1. Initialize java.util.Random instance.
 * 2. Invoke random.nextInt(bound).
 * 3. Return generated random integer.
 * 
 * Time: O(1)  Space: O(1)
 */

import java.util.Random;

public class P10_RandomDemo {

    // Dry Run
    /*
     * bound = 100
     * random.nextInt(100) -> returns pseudo-random integer e.g., 42 in [0, 99].
     */

    // Code
    public static int generateRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int bound = 100;
        int randomVal = generateRandomInt(bound);
        System.out.println("Random generated number (0-" + (bound - 1) + "): " + randomVal);
    }
}
