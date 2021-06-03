package geeksforgeeks.amazon.arrays;

import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1#

/**
 * Approach 1 : Sort the array and find missing
 *
 * Approach 2 : take map/set store to store
 * Run loop from 1 to size of the array and check if value contains in the set if not break the loop
 * return the number
 */
public class SmallestPositiveInteger {
    public static void main(String[] args) {
        int[] A = {1,1,2,3,4,6};//1,1,2,3,4,6
        System.out.println("Arr :" + missingNumber(A, A.length));
    }

    static int missingNumber(int A[], int size) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add(A[i]);
        }

        int num = 1;
        while(num <= size){
            if(!set.contains(num)) {
                break;
            }else{
                num++;
            }
        }
        return num;
    }
}
