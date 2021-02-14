package amazon.arrays;

import java.util.ArrayList;

public class MaximizeNumberOf_1 {
    public static void main(String[] args) {

        int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int M = 0;

        System.out.println(findZeroes(arr, arr.length, M));

    }

    // m is maximum of number zeroes allowed to flip
    static int findZeroes(int arr[], int n, int m) {

        ArrayList<Integer> list = new ArrayList<>(); //2

        int count = 0; //3
        int startIndex = 0; //2

        int max_length = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (m == 0) {
                    count = 0;
                } else {
                    if (list.size() == m) {
                        int index = list.remove(0);
                        count = count - (index - startIndex + 1);
                        startIndex = index + 1;
                    }
                    count++;
                    list.add(i);
                }

            } else {
                count++;
            }
            max_length = Math.max(max_length, count);
        }
        return max_length;
    }
}
