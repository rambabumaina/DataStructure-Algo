package geeksforgeeks.amazon.arrays;

import java.util.Arrays;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/key-pair5616/1

/**
 * Approach 1: Run two loops i and j and check if(arry[i] +arry[j] = sum this will take o(n)2 time
 *
 * Approach 2: n(logn) : Sort the array and keep to pointer l, and r if both pointers index sum is equal return true
 * else if , sum if greater do r-- else l++ and so on...
 *
 * Approach 3: Using hashing
 * take set and sore sum-array[i] in set and check is array[i] is contains
 * logic here is sum-x is always equals to y , if x+y ==sum
 * 0(n)
 */
public class Pair_Sum {

    public static void main(String[] args) {

        int sum =50;
        int[] arr = {8,9,4,20,30,26,28,40};
        System.out.println(is_pair_exists(arr, sum));

        System.out.println(hasArrayTwoCandidates(arr, arr.length, sum));

    }

    //O(n) solution
    static boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashSet<Integer> set = new HashSet<>();

        for (int i =0 ; i < n ; i++){
            if(set.contains(arr[i])) {
                System.out.println(
                        "Pair with given sum "
                                + x + " is (" + arr[i]
                                + ", " + (x-arr[i])+ ")");
                return true;
            }else {
                set.add(x-arr[i]);
            }
        }

        return false;
    }

    //o(logn)
    public static boolean is_pair_exists(int[] arr, int sum){

        Arrays.sort(arr);

        for (int i = 0, j = arr.length-1; j > i; ) {

            if(arr[i] + arr[j] == sum){
                System.out.println("Pair with given sum "
                        + sum + " is (" + arr[i]
                        + ", " + arr[j]+ ")");
                return true;
            }else if(arr[i] + arr[j] > sum){
                j--;
            }else {
                i++;
            }
        }

        return false;
    }
}
