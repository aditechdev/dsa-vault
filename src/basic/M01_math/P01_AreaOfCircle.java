package basic.m01_math;

/**
 * Problem Definition: Area of Circle & Volume of Sphere
 * Calculate the area of a circle and volume of a sphere for a given radius r.
 *
 * Formula / Concept:
 * Area = π * r^2
 * Volume = (4/3) * π * r^3
 *
 * Algorithm:
 * 1. Read radius r.
 * 2. Area = Math.ceil(Math.PI * r * r).
 * 3. Volume = Math.ceil((4.0 * Math.PI * r^3) / 3.0).
 *
 * Time: O(1)  Space: O(1)
 */
public class P01_AreaOfCircle {

    // Dry Run
    /*
     * Input: r = 5
     * Area = ceil(3.14159 * 25) = ceil(78.5398) = 79
     * Volume = ceil((4 * 3.14159 * 125) / 3) = ceil(523.598) = 524
     */

    // Code
    public static int solveAreaOfCircle(int r) {
        double area = Math.PI * r * r;
        return (int) Math.ceil(area);
    }

    public static int solveVolumeOfSphere(int r) {
        double volume = (4.0 * Math.PI * Math.pow(r, 3)) / 3.0;
        return (int) Math.ceil(volume);
    }

    // Main
    public static void main(String[] args) {
        // TestCase
        int radius = 5;
        System.out.println("Area of Circle (r=" + radius + "): " + solveAreaOfCircle(radius)); // 79
        System.out.println("Volume of Sphere (r=" + radius + "): " + solveVolumeOfSphere(radius)); // 524
    }
}
