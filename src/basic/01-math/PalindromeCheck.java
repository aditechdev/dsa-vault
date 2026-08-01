import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(int num) {
        if (num < 0) return false;
        int original = num;
        int revNum = 0;
        while (num != 0) {
            int remainder = num % 10;
            revNum = (revNum * 10) + remainder;
            num /= 10;
        }
        return original == revNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            System.out.println("Is " + num + " a palindrome? " + (isPalindrome(num) ? "Yes" : "No"));
        }
        sc.close();
    }
}
