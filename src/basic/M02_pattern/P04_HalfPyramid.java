package basic.m02_pattern;

/**
 * Problem Definition: Half Pyramid (Numeric and Star)
 * Print half pyramid patterns using numbers and stars for a given number of rows.
 * 
 * Formula / Concept:
 * Use nested loops. The outer loop controls the rows. The inner loop controls the elements in each row, up to the current row number.
 * 
 * Algorithm:
 * 1. Numeric Pyramid: Loop `n` from 1 to `rows`. Loop `m` from 1 to `n`. Print `value` and increment.
 * 2. Star Pyramid: Loop `n` from 1 to `rows`. Loop `m` from 1 to `n`. Print `*`.
 * 3. Move to the next line after each row.
 * 
 * Time: O(N^2)  Space: O(1)
 */

public class P04_HalfPyramid {

    // Dry Run
    /*
     * Input: rows = 3
     * Numeric:
     * n = 1: 1
     * n = 2: 2 3
     * n = 3: 4 5 6
     * 
     * Star:
     * n = 1: *
     * n = 2: * *
     * n = 3: * * *
     */

    // Code
    public static void printNumericHalfPyramid(int rows) {
        int value = 1;
        for (int n = 1; n <= rows; n++) {
            for (int m = 1; m <= n; m++) {
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
        }
    }

    public static void printStarHalfPyramid(int rows) {
        for (int n = 1; n <= rows; n++) {
            for (int m = 1; m <= n; m++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        System.out.println("Numeric Half Pyramid:");
        printNumericHalfPyramid(4);
        System.out.println("Star Half Pyramid:");
        printStarHalfPyramid(4);
    }
}
