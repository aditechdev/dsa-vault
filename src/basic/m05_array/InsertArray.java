package basic.array;

import java.util.Scanner;

/**
 * <h1>Element Insertion into Fixed-Size Array</h1>
 *
 * <h2>Problem Statement:</h2>
 * Insert an element at a specified index in an array by creating a new array of size (N+1)
 * and shifting elements accordingly.
 *
 * <h2>Complexity:</h2>
 * <ul>
 *   <li><b>Time Complexity:</b> O(N) - single pass shift</li>
 *   <li><b>Space Complexity:</b> O(N) - new array allocation</li>
 * </ul>
 *
 * @author Aditya Anand
 */
public class InsertArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int noOfDigit = sc.nextInt();
            int[] arr = new int[noOfDigit - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int insertPosition = sc.nextInt();
            int insertNumber = sc.nextInt();
            int[] newArr = new int[noOfDigit];
            for (int i = 0; i < newArr.length; i++) {
                if (i == insertPosition) {
                    newArr[i] = insertNumber;
                } else if (i < insertPosition) {
                    newArr[i] = arr[i];
                } else {
                    newArr[i] = arr[i - 1];
                }
            }
            System.out.print("Updated Array: ");
            for (int x : newArr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
