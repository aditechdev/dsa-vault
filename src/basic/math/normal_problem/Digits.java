package basic.math.normal_problem;

import java.util.Scanner;

public class Digits {

    public static long sumOfDigits(long num) {
        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            long num = sc.nextLong();
            System.out.println("Sum of digits for " + num + ": " + sumOfDigits(num));
        }
        sc.close();
    }
}
