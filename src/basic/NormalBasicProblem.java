package basic;

import java.util.Scanner;

/**
 * <h1>Find Maximum in a Stream of Numbers</h1>
 *
 * <h2>Problem Statement:</h2>
 * Given N numbers from standard input, find and output the maximum number.
 *
 * <h2>Approach & Key Intuition:</h2>
 * Initialize a tracker variable `largestNum` to `Integer.MIN_VALUE`. Iterate through the N numbers,
 * updating `largestNum` whenever a value greater than `largestNum` is encountered.
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N) - single pass over N input elements</li>
 *   <li><b>Space Complexity:</b> O(1) - auxiliary space constant</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class NormalBasicProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int count = sc.nextInt();
            int largestNum = Integer.MIN_VALUE;

            for (int i = 1; i <= count; i++) {
                int userNumber = sc.nextInt();
                if (userNumber > largestNum) {
                    largestNum = userNumber;
                }
            }
            System.out.println("Maximum: " + largestNum);
        }
        sc.close();
    }
}
