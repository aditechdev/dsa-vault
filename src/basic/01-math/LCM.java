package basic.math;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int i = Math.min(a, b); i >= 1; i--) {
                if (a % i == 0 && b % i == 0) {
                    int lcm = (a * b) / i;
                    System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
                    break;
                }
            }
        }
        sc.close();
    }
}
