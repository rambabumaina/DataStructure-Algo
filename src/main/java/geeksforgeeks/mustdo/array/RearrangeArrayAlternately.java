package geeksforgeeks.mustdo.array;

import java.util.Arrays;

public class RearrangeArrayAlternately {
    public static void main(String args[]) throws Exception {

//        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        rearrange(arr);

        System.out.println("After rearranging");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void rearrange(int[] arr) {
        int currentIndex = 0;
        int nextIndex = 0;
        int lastIndex = arr.length - 1;
        int tmp1 = arr[0];
        do {
            nextIndex = currentIndex * 2 + 1;
            if (nextIndex > lastIndex) {
                int temp = nextIndex - lastIndex;
                nextIndex = lastIndex - temp + 1;
            }
            int tmp2 = arr[nextIndex];
            arr[nextIndex] = tmp1;
            currentIndex = nextIndex;
            tmp1 = tmp2;
        } while (currentIndex != 0);
    }

}
