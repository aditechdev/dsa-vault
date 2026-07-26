package basic.math.normal_problem;

import java.util.Scanner;

public class NumberOfDigits {

    public static int countDigits(long num) {
        if (num == 0) return 1;
        int count = 0;
        long temp = Math.abs(num);
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            long num = sc.nextLong();
            System.out.println("Number of digits in " + num + ": " + countDigits(num));
        }
        sc.close();
    }
}
