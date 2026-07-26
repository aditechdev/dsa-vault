package basic.math.normal_problem;

import java.util.Scanner;

public class PrintPrimeByMethod {

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println("Is " + num + " prime? " + checkPrime(num));
        }
        sc.close();
    }
}
