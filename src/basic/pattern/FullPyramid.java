package basic.pattern;

import java.util.Scanner;

public class FullPyramid {

    public static void printPyramid(int num) {
        for (int i = num; i > 0; i--) {
            for (int j = num - i; j >= 1; j--) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printPyramid(num);
        } else {
            printPyramid(5);
        }
        sc.close();
    }
}
