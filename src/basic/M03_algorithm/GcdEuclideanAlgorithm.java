package basic.M03_algorithm;

/**
 * Problem Definition: Compute the Greatest Common Divisor (GCD) of two non-negative integers a and b.
 *
 * Formula / Concept:
 * GCD(a, b) = GCD(b, a % b). Continue until the second argument becomes 0; GCD(a, 0) = a.
 *
 * Algorithm:
 * 1. If b == 0, return a.
 * 2. Else return gcd(b, a % b).
 *
 * Time: O(log(min(a, b)))  Space: O(log(min(a, b)))
 */
public class GcdEuclideanAlgorithm {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 69;
        int b = 50;
        int gcd = gcd(a,b);
        System.out.print("GCD(" + a + ", " + b + ") = " + gcd);
    }
}
