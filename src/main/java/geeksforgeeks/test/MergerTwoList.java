package geeksforgeeks.test;

import java.util.Arrays;

public class MergerTwoList {


    public static void main(String[] args) {
        int[] l1 = new int[]{1, 3, 4};
        int[] l2 = new int[]{2, 5, 6, 8};

        int[] merge = merge(l1, l2);
        Arrays.stream(merge).forEach(m -> System.out.print(m + " "));
    }

    private static int[] merge(int[] l1, int[] l2) {
        int[] l3 = new int[l1.length + l2.length];

        int i = 0, k = 0, j = 0;
        while (i < l1.length && j < l2.length) {
            if (l1[i] <= l2[j]) {
                l3[k++] = l1[i++];
            } else {
                l3[k++] = l2[j++];
            }
        }

        while (j < l2.length) {
            l3[k++] = l2[j++];
        }

        while (i < l1.length) {
            l3[k++] = l1[i++];
        }

        return l3;
    }
}
