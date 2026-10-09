package basic.array;

import java.util.Scanner;

/**
 * Searching algorithms demonstration:
 * - Linear Search (First & All Occurrences)
 * - Binary Search (Iterative & Recursive)
 * - Binary Search for First and Last Occurrences
 */
public class TwoDArrayDemo {

    static int linearSearch(int[] arr, int q) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == q) {
                return i;
            }
        }
        return -1;
    }

    static void linearSearchAll(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    static int binarySearch(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > k) {
                e = mid - 1;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int binarySearchFirstOccurrence(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > k) {
                e = mid - 1;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                ans = mid;
                e = mid - 1; // Keep searching left
            }
        }
        return ans;
    }

    static int binarySearchLastOccurrence(int[] arr, int k) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > k) {
                e = mid - 1;
            } else if (arr[mid] < k) {
                s = mid + 1;
            } else {
                ans = mid;
                s = mid + 1; // Keep searching right
            }
        }
        return ans;
    }

    static int binarySearchRecursion(int[] arr, int s, int e, int key) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return binarySearchRecursion(arr, s, mid - 1, key);
        }
        return binarySearchRecursion(arr, mid + 1, e, key);
    }

    public static void main(String[] args) {
        int[] sortedArrayList = {1, 2, 5, 7, 9, 13, 24, 34, 39, 54};
        int[] repeatElementArrayList = {1, 2, 4, 8, 11, 11, 11, 11, 13, 24};

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int key = sc.nextInt();
            System.out.println("Binary Search Recursive Index: " +
                    binarySearchRecursion(sortedArrayList, 0, sortedArrayList.length - 1, key));
            System.out.println("First Occurrence Index: " +
                    binarySearchFirstOccurrence(repeatElementArrayList, key));
            System.out.println("Last Occurrence Index: " +
                    binarySearchLastOccurrence(repeatElementArrayList, key));
        } else {
            System.out.println("Binary Search (Iterative) for 13: " + binarySearch(sortedArrayList, 13));
        }
        sc.close();
    }
}
