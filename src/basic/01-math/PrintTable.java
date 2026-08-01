import java.util.Scanner;

public class PrintTable {

    public static void printMultiplicationTable(int num) {
        System.out.println("Multiplication table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            printMultiplicationTable(num);
        }
        sc.close();
    }
}
