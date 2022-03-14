package recursion;

import java.util.Arrays;

// This will not modify the original array
public class MergeSortUsingNewArray {
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        int[] res = mergeSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int m = arr.length / 2;

        // copyOfRange array returns the new array
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));

        return merge(left, right);
    }


    private static int[] merge(int[] a, int[] b) {

        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
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
