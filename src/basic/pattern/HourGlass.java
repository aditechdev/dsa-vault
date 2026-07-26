package basic.pattern;

import java.util.Scanner;

public class HourGlass {

    public static void printHourGlass(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printHourGlass(num);
        } else {
            printHourGlass(5);
        }
        sc.close();
    }
}
