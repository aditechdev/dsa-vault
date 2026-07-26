package basic.pattern;

import java.util.Scanner;

public class ReverseTrianglePattern {

    public static void printReverseTriangle(int num) {
        for (int i = num; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + (i == j ? "" : " "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printReverseTriangle(num);
        } else {
            printReverseTriangle(5);
        }
        sc.close();
    }
}
