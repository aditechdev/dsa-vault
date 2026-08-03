package basic.M02_pattern;

/**
 * Problem Definition: Hour Glass Pattern (Star)
 * Print an hour glass pattern using '*' for a given number of rows.
 *
 * Example (num = 5):
 * * * * *
 * * * * *
 * * * *
 * * *
 * *
 * * *
 * * * *
 * * * * *
 * * * * *
 *
 * Formula / Concept:
 * Divide the pattern into two halves:
 * 1. Upper Half:
 * - Leading spaces increase in each row.
 * - Number of stars decreases in each row.
 * 2. Lower Half:
 * - Leading spaces decrease in each row.
 * - Number of stars increases in each row.
 *
 * Algorithm:
 * 1. Print the upper half.
 * - Loop `i` from `num` down to `1`.
 * - Print `(num - i)` leading spaces.
 * - Print `i` stars.
 * 2. Print the lower half.
 * - Loop `i` from `2` to `num`.
 * - Print `(num - i)` leading spaces.
 * - Print `i` stars.
 *
 * Time Complexity: O(N²)
 * Space Complexity: O(1)
 */

public class P05_HourGlass {

    // Dry Run
    /*
     * Input: num = 3
     *
     * * * *
     * * *
     * *
     * * *
     * * * *
     */

    // Code
    public static void printStarHourGlass(int num) {

        // Upper Half
        for (int i = num; i >= 1; i--) {

            // Leading Spaces
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower Half
        for (int i = 2; i <= num; i++) {

            // Leading Spaces
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            // Stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void printNumericHourGlass(int num) {

        // Upper Half

        for (int i = num; i >= 1; i--) {

            // Leading Spaces

            for (int j = 1; j <= num - i; j++) {

                System.out.print("  ");

            }

            // Numbers

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();

        }

        // Lower Half

        for (int i = 2; i <= num; i++) {

            // Leading Spaces

            for (int j = 1; j <= num - i; j++) {

                System.out.print("  ");

            }

            // Numbers

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");

            }

            System.out.println();

        }

    }

    // Main
    public static void main(String[] args) {
        // Test Case
        printStarHourGlass(5);
        System.out.println();
        printNumericHourGlass(5);
    }
}