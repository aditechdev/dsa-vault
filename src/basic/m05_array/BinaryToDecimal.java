package basic.array;

import java.util.Scanner;

/**
 * <h1>Number Base Conversions & Magic Number Computation</h1>
 *
 * <h2>Concepts & Approaches:</h2>
 * <ul>
 *   <li><b>Binary to Decimal:</b> Extract base-10 digits and multiply by powers of 2.</li>
 *   <li><b>Decimal to Binary:</b> Extract base-2 remainders (N % 2) and scale by powers of 10.</li>
 *   <li><b>Magic Number (Base-5 Powers):</b> Extract binary bits and multiply active bits by powers of 5.</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(log_{10} N) / O(log_2 N)</li>
 *   <li><b>Space Complexity:</b> O(1)</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class BinaryToDecimal {
    public static int binaryToDec(int n) {
        int ans = 0;
        int power = 1;
        while (n > 0) {
            int lastDigit = n % 10;
            ans = ans + lastDigit * power;
            power = power * 2;
            n = n / 10;
        }
        return ans;
    }

    public static int decimalToBinary(int n) {
        int ans = 0;
        int power = 1;
        while (n > 0) {
            int lastDigit = n % 2;
            ans = ans + lastDigit * power;
            n = n / 2;
            power = power * 10;
        }
        return ans;
    }

    public static int magicNumber(int n) {
        int ans = 0;
        int power = 5;
        while (n > 0) {
            int lastDigit = n % 2;
            ans = ans + lastDigit * power;
            n = n / 2;
            power = power * 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println("Binary to Decimal (" + n + "): " + binaryToDec(n));
            System.out.println("Decimal to Binary (" + n + "): " + decimalToBinary(n));
            System.out.println("Magic Number (" + n + "): " + magicNumber(n));
        }
        sc.close();
    }
}
