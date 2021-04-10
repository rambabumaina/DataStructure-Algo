package geeksforgeeks.amazon.arrays;

import java.util.HashSet;
//https://practice.geeksforgeeks.org/problems/sum-equals-to-sum4006/1
public class SumEqualsSum {

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        System.out.println(findPairs(arr, arr.length));
    }

    public static int findPairs(int arr[],int n)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0 ; i < arr.length; i++){
            for (int j = i+1 ; j< arr.length; j++){
                if(set.contains(arr[i]+ arr[j])){
                    return 1;
                }else {
                    set.add(arr[i]+ arr[j]);
                }
            }
        }
        return 0;
    }

}
