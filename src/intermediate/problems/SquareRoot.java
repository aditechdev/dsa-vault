package intermediate.problems;

import java.util.Scanner;

public class SquareRoot {

    /**
     * Finds integer square root using Binary Search O(log A)
     *
     * @param a Integer value
     * @return Perfect square root or -1 if not a perfect square
     */
    public static int solve(int a) {
        if (a < 0) return -1;
        if (a == 0 || a == 1) return a;

        long left = 1;
        long right = a;
        int squareRoot = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < a) {
                left = mid + 1;
            } else if (mid * mid > a) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return squareRoot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int input = sc.nextInt();
            int number = solve(input);
            System.out.println("Square Root: " + number);
        } else {
            System.out.println("Square Root of 25: " + solve(25));
        }
        sc.close();
    }
}
