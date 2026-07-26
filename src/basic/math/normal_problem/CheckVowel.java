package basic.math.normal_problem;

import java.util.Scanner;

public class CheckVowel {
    public static boolean isVowel(char ch) {
        char lower = Character.toLowerCase(ch);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            char inputChar = sc.next().charAt(0);
            System.out.println("Is '" + inputChar + "' a vowel? " + (isVowel(inputChar) ? 1 : 0));
        } else {
            System.out.println("Is 'a' a vowel? " + (isVowel('a') ? 1 : 0));
        }
        sc.close();
    }
}
