package basic.arrayList;

import java.util.ArrayList;

/**
 * ArrayList Overview:
 * - Part of Java Collections Framework
 * - Resizable array implementation of the List interface
 * - Dynamically grows and shrinks as elements are added/removed
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListNew = new ArrayList<>(100);
        arrayListNew.add(5);
        arrayListNew.add(6);
        arrayListNew.add(7);
        arrayListNew.add(9);
        arrayListNew.add(10);
        arrayListNew.add(2, 10);
        
        Integer targetObj = 6;
        arrayListNew.remove(targetObj);

        System.out.println("ArrayList Elements:");
        for (int i = 0; i < arrayListNew.size(); i++) {
            System.out.println(arrayListNew.get(i));
        }
    }
}
