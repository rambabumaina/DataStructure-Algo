package leetcode.arrays;

import java.util.Arrays;

public class FindSecondLargest {
    public static void main(String[] args) {

        int[] arr = {1, -1, 0, 45, 50, 7, 90, 97};

        int brr[] = findSecondLargest(arr);
        Arrays.stream(brr).forEach(d -> System.out.print(d + " "));
    }

    private static int[] findSecondLargest(int[] arr) {
        int brr[] = new int[arr.length];
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(d -> System.out.print(d + " "));
        System.out.println();

            for (int i = 0; i < arr.length; i++) {
                    if (i+2 < arr.length) {
                        brr[i] = arr[i + 2];
                    } else {
                        brr[i] = -1;
                    }
                }

        return brr;
    }

}
