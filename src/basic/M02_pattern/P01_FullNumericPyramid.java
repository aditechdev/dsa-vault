package basic.m02_pattern;

/**
 * 
 * Problem Definition: Full Numeric Pyramid
 * Print a full numeric pyramid pattern for a given number of rows.
 *
 * Time: O(N²)
 * Space: O(1)
 */

public class P01_FullNumericPyramid {

    // Dry Run
    /*
     * Input: num = 3
     * i = 1: 0 0 1 0 0
     * i = 2: 0 2 3 2 0
     * i = 3: 3 4 5 4 3
     */

    // Code
    public static void printPyramid(int num) {
        for (int i = 1; i <= num; i++) {
            // Leading spaces
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }

            // Increasing numbers
            for (int k = i; k <= 2 * i - 1; k++) {
                System.out.print(k);
            }

            // Decreasing numbers
            for (int l = 2 * (i - 1); l >= i; l--) {
                System.out.print(l);
            }

            System.out.println();
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        printPyramid(5);

        /*
          ....1
          ...232
          ..34543
          .4567654
          567898765

         */

    }
}
