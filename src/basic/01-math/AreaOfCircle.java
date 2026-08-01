import java.util.Scanner;

public class AreaOfCircle {
    public static int solveAreaOfCircle(int r) {
        double area = Math.PI * r * r;
        return (int) Math.ceil(area);
    }

    public static int solveVolumeOfSphere(int r) {
        double volume = (4.0 * Math.PI * Math.pow(r, 3)) / 3.0;
        return (int) Math.ceil(volume);
    }

    public static int gcd(int a, int b) {
        int gcd = 1;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int radius = sc.nextInt();
            System.out.println("Area of Circle: " + solveAreaOfCircle(radius));
            System.out.println("Volume of Sphere: " + solveVolumeOfSphere(radius));
        } else {
            System.out.println("GCD of 12 and 20: " + gcd(12, 20));
        }
        sc.close();
    }
}
