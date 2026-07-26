package basic.arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class LexicographicOrder {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("guava");
        fruits.add("apple");
        fruits.add("pineapple");
        fruits.add("lemon");

        // Sort in natural lexicographic order
        Collections.sort(fruits);
        System.out.println("Lexicographical Order: " + fruits);

        // Sort in reverse order
        Collections.sort(fruits, Collections.reverseOrder());
        System.out.println("Reverse Lexicographical Order: " + fruits);
    }
}
