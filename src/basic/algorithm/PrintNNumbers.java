package basic.algorithm;

import java.util.Scanner;

/**
 * <h1>Print 1 to N Using Recursion</h1>
 *
 * <h2>Problem Statement:</h2>
 * Print numbers from 1 to N in ascending order without using loops.
 *
 * <h2>Approach & Key Intuition:</h2>
 * Call recursion first with (N-1), then print N after recursive call returns (Head-to-Tail recursion flow).
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N) - N function calls</li>
 *   <li><b>Space Complexity:</b> O(N) - Call stack depth</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class PrintNNumbers {

    public static void printNumbersRecursion(int n) {
        if (n >= 1) {
            printNumbersRecursion(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printNumbersRecursion(num);
            System.out.println();
        }
        sc.close();
    }
}
