package geeksforgeeks.amazon.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/remove-duplicates-in-small-prime-array/1
//Approach 1: Sort the array compare ith element with the (i-1)th elements
//Approach 2: Store in set
public class RemoveDuplicates {

    public static void main(String[] args) {
        int A[] = {2, 2, 3, 3, 7, 5};
        int N = A.length;
        ArrayList<Integer> list = removeDuplicate(A, N);
        list.forEach(s -> System.out.println(s));
    }

    static ArrayList<Integer> removeDuplicate(int arr[], int n) {
        HashMap<Integer, String> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(arr[i], null);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, String> mm : m.entrySet()) {
            res.add(mm.getKey());
        }
        return res;
    }
}
