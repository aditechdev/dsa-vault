package basic.M03_algorithm;

import java.util.Scanner;

/**
 * <h1>Recursive Factorial (Principle of Mathematical Induction)</h1>
 *
 * <h2>Problem Statement:</h2>
 * Compute the factorial of a non-negative integer N using recursion.
 *
 * <h2>Approach & Key Intuition:</h2>
 * Uses Principle of Mathematical Induction (PMI):
 * <ol>
 *   <li><b>Base Case:</b> 0! = 1 or 1! = 1</li>
 *   <li><b>Inductive Hypothesis:</b> Assume fun(N-1) calculates (N-1)! correctly</li>
 *   <li><b>Inductive Step:</b> fun(N) = N * fun(N-1)</li>
 * </ol>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N) - N recursive stack frames</li>
 *   <li><b>Space Complexity:</b> O(N) - auxiliary call stack space</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class FactorialPMI {

    public static int factorialUsingRecursion(int n) {
        if (n <= 0) return 1;
        return n * factorialUsingRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println("Factorial of " + num + ": " + factorialUsingRecursion(num));
        }
        sc.close();
    }
}
