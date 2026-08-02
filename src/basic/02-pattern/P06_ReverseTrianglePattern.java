/**
 * Problem Definition: Reverse Triangle Pattern (Numeric)
 * Print a reverse numeric triangle pattern for a given number of rows.
 * 
 * Formula / Concept:
 * Use nested loops. The outer loop controls rows, starting from max down to 1. The inner loop prints numbers from 1 to current row number.
 * 
 * Algorithm:
 * 1. Loop `i` from `num` down to 1.
 * 2. Loop `j` from 1 to `i`.
 * 3. Print `j` with appropriate spacing.
 * 4. Move to the next line.
 * 
 * Time: O(N^2)  Space: O(1)
 */

public class P06_ReverseTrianglePattern {

    // Dry Run
    /*
     * Input: num = 3
     * i = 3: 1 2 3
     * i = 2: 1 2
     * i = 1: 1
     */

    // Code
    public static void printReverseTriangle(int num) {
        for (int i = num; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + (i == j ? "" : " "));
            }
            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        printReverseTriangle(5);
    }
}
