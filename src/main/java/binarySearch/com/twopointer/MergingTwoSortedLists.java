package binarySearch.com.twopointer;

import java.util.Arrays;

public class MergingTwoSortedLists {
    public static void main(String[] args) {
//        int [] a = {5, 15};
//        int [] b = {3, 8, 9};

        int a[] = {};
        int b[] = {0};

        int[] solve = solve(a, b);
        Arrays.stream(solve).forEach(System.out::println);
    }


    static int[] solve(int[] a, int[] b) {

        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }
}
