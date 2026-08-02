import java.util.Scanner;

public class FullNumericPyramid {

    public static void printPyramid(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print("0 ");
            }
            for (int k = i; k <= 2 * i - 1; k++) {
                System.out.print(k + " ");
            }
            for (int l = 2 * (i - 1); l >= i; l--) {
                System.out.print(l + " ");
            }
            for (int m = 1; m <= num - i; m++) {
                System.out.print(m == num - i ? "0" : "0 ");
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
