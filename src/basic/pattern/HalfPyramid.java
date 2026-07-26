package basic.pattern;

import java.util.Scanner;

public class HalfPyramid {

    public static void printNumericHalfPyramid(int rows) {
        int value = 1;
        for (int n = 1; n <= rows; n++) {
            for (int m = 1; m <= n; m++) {
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
        }
    }

    public static void printStarHalfPyramid(int rows) {
        for (int n = 1; n <= rows; n++) {
            for (int m = 1; m <= n; m++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println("Numeric Half Pyramid:");
            printNumericHalfPyramid(num);
            System.out.println("Star Half Pyramid:");
            printStarHalfPyramid(num);
        } else {
            printNumericHalfPyramid(4);
        }
        sc.close();
    }
}
