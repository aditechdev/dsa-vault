package basic.algorithm;

/**
 * <h1>Euclidean Algorithm for Greatest Common Divisor (GCD)</h1>
 *
 * <h2>Problem Statement:</h2>
 * Compute the GCD (Highest Common Factor) of two non-negative integers A and B.
 *
 * <h2>Approach & Key Intuition:</h2>
 * Based on the mathematical principle: GCD(A, B) = GCD(B, A % B) until B becomes 0.
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(log(min(A, B))) - Logarithmic reduction per modulo step</li>
 *   <li><b>Space Complexity:</b> O(log(min(A, B))) - Call stack depth</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class GcdEuclideanAlgorithm {

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 69;
        int b = 50;
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd(a, b));
    }
}
