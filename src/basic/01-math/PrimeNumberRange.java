package basic.math.normal_problem;

import java.util.Scanner;

public class PrimeNumberRange {

    public static void printPrimesUpTo(int limit) {
        System.out.println("Prime numbers up to " + limit + ":");
        for (int i = 2; i < limit; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printPrimesUpTo(num);
        }
        sc.close();
    }
}
