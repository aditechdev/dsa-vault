package basic.m02_pattern;

/**
 * Problem Definition: Full Numeric Pyramid (Simplified)
 * Print a full pyramid pattern using numbers for a given number of rows.
 * 
 * Formula / Concept:
 * Use nested loops to control the number of rows, spaces, and numbers printed
 * in each row.
 * The pattern involves printing leading spaces to center the pyramid and then
 * printing numbers from 1 up to the current row number.
 * 
 * Algorithm:
 * 1. Loop `i` from `num` down to 1 (controls the number of elements printed per
 * row indirectly).
 * 2. Loop `j` from `num - i` down to 1 to print leading spaces.
 * 3. Loop `k` from 1 to `i` to print numbers from 1 to `i`.
 * 4. Move to the next line.
 * 
 * Time: O(N^2) Space: O(1)
 */

public class P02_FullPyramid {

    // Dry Run
    /*
     * Input: n = 3
     * i = 1: *
     * i = 2: ***
     * i = 3: *****
     */

    // Code
    public static void printFullPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        printFullPyramid(5);
    }
}
