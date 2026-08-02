import java.util.Arrays;
import java.util.List;

/**
 * GCD of Two Numbers (Euclidean Algorithm)
 * 
 * GCD(a, b) = GCD(b, a % b) until b = 0
 * Examples: GCD(50, 35) = 5, GCD(12, 8) = 4
 * 
 * Time: O(log n), Space: O(1)
 */
public class GCDOfNumber {

    public static void gcd(List<Integer> n) {
        if (n == null || n.isEmpty()) {

            return;

        }
        // find the min of number
        int minNumber = n.get(0);
        for (int i = 0; i < n.size(); i++) {

            if (n.get(i) < minNumber) {
                minNumber = n.get(i);
            }

        }

        for (int i = minNumber; i >= 1; i--) {
            boolean isGCD = true;

            for (int j = 0; j < n.size(); j++) {

                if (n.get(j) % i != 0) {
                    isGCD = false;
                    break;

                }

            }

            if (isGCD) {
                System.out.println("GCD for " + n + " is " + i);
                return;
            }
        }

    }

    public static void main(String[] args) {
        // Fix: Use Arrays.asList to initialize the list
        gcd(Arrays.asList(50, 35, 90));
    }

}
