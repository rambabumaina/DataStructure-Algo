package geeksforgeeks.mustdo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubArrayWithTheGivenSum {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 7, 5};
        int n = input.length;
        int s = 12;

//        subarraySum(input, n, s).forEach(ss -> System.out.println(ss));
//        subArraySumPrefix(input, n, s);

        int i = 0, j = 0;
        int sum = input[0];

        while (j < n) {
            if (sum == s) {
                System.out.println((i+1) + " " + (j+1));
                break;
            } else if (sum > s) {
                sum = sum - input[i];
                i++;
            } else {
                j++;
                sum = sum + input[j];
            }
        }
    }

    static ArrayList<Integer> subarraySum(int[] input, int n, int s) {
        int i = 0, j = 0, sum = input[0];

        ArrayList<Integer> list = new ArrayList<>();

        while (j < n) {
            if (sum == s) {
                list.add(i + 1);
                list.add(j + 1);
                break;
            } else if (sum > s) {
                sum = sum - input[i];
                i++;
            } else {
                j++;
                sum = sum + input[j];
            }
        }
        return list;
    }


    static ArrayList<Integer> subArraySumPrefix(int[] arr, int n, int s) {

        Map<Integer, Integer> hm = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        int j = 0, sum = 0;

        while (j < n) {
            sum += arr[j];

            if (hm.containsKey(sum)) {
                hm.put(hm.get(sum), j);
            } else {
                hm.put(sum, j);
            }
            j++;
        }

        hm.forEach((k, v) -> System.out.println(k + " " + v));
        return list;
    }
}
