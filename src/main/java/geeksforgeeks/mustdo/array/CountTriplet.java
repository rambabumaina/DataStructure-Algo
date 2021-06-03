package geeksforgeeks.mustdo.array;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
public class CountTriplet {
    public static void main(String[] args) {
        int[] arr = {14, 3, 6, 8, 11, 16};

        int i = countTriplet(arr, arr.length);
        System.out.println("I :" + i);
    }

    static int countTriplet(int arr[], int n) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i] + arr[j];
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += map.get(arr[i]) != null ? map.get(arr[i]) : 0;
        }

        return count;
    }
}
