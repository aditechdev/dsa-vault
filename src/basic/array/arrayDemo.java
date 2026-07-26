package basic.array;

import java.util.Scanner;

/**
 * <h1>1D Array Fundamentals & Operations</h1>
 *
 * <h2>Concepts Demonstrated:</h2>
 * <ul>
 *   <li>Array instantiation & indexing (0-based)</li>
 *   <li>Iterating using enhanced for-loop (for-each)</li>
 *   <li>Accessing array bounds (`arr.length`)</li>
 * </ul>
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N) for traversal</li>
 *   <li><b>Space Complexity:</b> O(N) for array storage</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class ArrayDemo {
    public static void arrayPractice() {
        int[] arr = {2, 4, 19, 184, 37};

        System.out.println("Length of array: " + arr.length);
        System.out.println("Element at index 4: " + arr[4]);
        System.out.print("Array elements: ");
        for (int x : arr) {
            System.out.print(x + ", ");
        }
        System.out.println();
        System.out.println("Last element: " + arr[arr.length - 1]);
    }

    static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            printArray(arr);
        } else {
            arrayPractice();
        }
        sc.close();
    }
}
