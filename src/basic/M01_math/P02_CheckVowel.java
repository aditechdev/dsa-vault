package basic.M01_math;

/**
 * Problem Definition: Check Vowel
 * Given a character ch, check whether it is a vowel (a, e, i, o, u) case-insensitively.
 * 
 * Formula / Concept:
 * Character.toLowerCase(ch) == 'a' || 'e' || 'i' || 'o' || 'u'
 * 
 * Algorithm:
 * 1. Convert character to lowercase.
 * 2. Check equality against 'a', 'e', 'i', 'o', 'u'.
 * 3. Return true if match, false otherwise.
 * 
 * Time: O(1)  Space: O(1)
 */


public class P02_CheckVowel {

    // Dry Run
    /*
     * Input: ch = 'E'
     * lower = 'e'
     * 'e' == 'e' -> returns true
     * 
     * Input: ch = 'z'
     * lower = 'z'
     * 'z' not in {a, e, i, o, u} -> returns false
     */

    // Code
    public static boolean isVowel(char ch) {
        char lower = Character.toLowerCase(ch);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        char test1 = 'a';
        char test2 = 'E';
        char test3 = 'z';

        System.out.println("Is '" + test1 + "' a vowel? " + (isVowel(test1) ? "Yes" : "No")); // Yes
        System.out.println("Is '" + test2 + "' a vowel? " + (isVowel(test2) ? "Yes" : "No")); // Yes
        System.out.println("Is '" + test3 + "' a vowel? " + (isVowel(test3) ? "Yes" : "No")); // No
    }
}
