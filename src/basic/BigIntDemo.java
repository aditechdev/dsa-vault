package basic;

import java.math.BigInteger;

/**
 * <h1>BigInteger Factorial Demo</h1>
 * 
 * <h2>Problem Statement:</h2>
 * Calculate large factorials (e.g., 100!) that exceed standard primitive integer types (32-bit int / 64-bit long).
 *
 * <h2>Approach & Key Intuition:</h2>
 * Standard 64-bit integer (`long`) overflows for values above 20!. Java's {@link BigInteger} provides
 * arbitrary-precision arithmetic to represent integers of any size limited only by memory.
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N^2 log N) for multiplying numbers up to N</li>
 *   <li><b>Space Complexity:</b> O(N log N) bit space stored in memory</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class BigIntDemo {

    public static void main(String[] args) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println("100! = " + factorial);
    }
}
