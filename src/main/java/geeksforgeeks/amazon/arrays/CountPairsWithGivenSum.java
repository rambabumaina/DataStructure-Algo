package geeksforgeeks.amazon.arrays;


//https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1};
        int k = 2;
        getPairsCount(arr, arr.length, k);
    }

    static int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) {
                count += map.get(k - arr[i]);
            }

            if (k - arr[i] == arr[i])
                count--;
        }

        return count / 2;
    }
}
