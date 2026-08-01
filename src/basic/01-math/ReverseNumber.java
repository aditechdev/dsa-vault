import java.util.Scanner;

public class ReverseNumber {

    public static int reverseInteger(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int remainder = num % 10;
            reverseNum = (reverseNum * 10) + remainder;
            num /= 10;
        }
        return reverseNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println("Reversed number: " + reverseInteger(num));
        }
        sc.close();
    }
}
