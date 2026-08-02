/**
 * Problem Definition: Print Multiplication Table
 * Print the multiplication table of a given integer num from 1 to 10.
 * 
 * Formula / Concept:
 * Product = num * i for i in [1, 10]
 * 
 * Algorithm:
 * 1. Loop i from 1 to 10.
 * 2. Calculate product = num * i.
 * 3. Print "num x i = product".
 * 
 * Time: O(1)  Space: O(1)
 */
public class P09_PrintTable {

    // Dry Run
    /*
     * num = 5
     * i = 1 -> 5 x 1 = 5
     * i = 2 -> 5 x 2 = 10
     * ...
     * i = 10 -> 5 x 10 = 50
     */

    // Code
    public static void printMultiplicationTable(int num) {
        System.out.println("Multiplication table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int num = 7;
        printMultiplicationTable(num);
    }
}
