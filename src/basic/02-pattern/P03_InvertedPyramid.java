/**
 * Problem Definition: Inverted Diamond Pattern
 * Print a half diamond pattern using stars for a given number of rows.
 * 
 * Formula / Concept:
 * Use nested loops to control the number of rows, spaces, and stars printed in
 * each row.
 * The pattern involves printing leading spaces to right-align the stars, and
 * then an odd number of stars.
 * 
 * Algorithm:
 * 1. Loop `i` from 1 to `n` (rows).
 * 2. Loop `j` from 1 to `n - i` to print leading spaces.
 * 3. Loop `k` from 1 to `2 * i - 1` to print stars.
 * 4. Move to the next line.
 * 
 * Time: O(N^2) Space: O(1)
 */

public class P03_InvertedPyramid {

    // Dry Run
    /*
     * Input: num = 3
     * i = 3: 1 2 3
     * i = 2:  1 2
     * i = 1:   1
     * Note: the provided code prints an inverted pyramid, despite the name.
     */

    // Code
    public static void printHalfDiamond(int num) {
        for (int i = num; i > 0; i--) {
            for (int j = num - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        printHalfDiamond(4);
    }
}
