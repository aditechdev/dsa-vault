package basic.string;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            System.out.println("Capacity: " + sb.capacity());
            System.out.println("Length: " + sb.length());
        } else {
            StringBuilder sb = new StringBuilder("Hello Java");
            System.out.println("Capacity: " + sb.capacity());
            System.out.println("Length: " + sb.length());
        }
        sc.close();
    }
}
