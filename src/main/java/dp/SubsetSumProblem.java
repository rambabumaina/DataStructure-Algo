package dp;

import java.util.Arrays;

public class SubsetSumProblem {

    public static void main(String[] args) {

       int[] arr = {11,1,5,5};
        System.out.println(equalPartition(11, arr));
    }

    static int equalPartition(int N, int arr[])
    {

        int sum = Arrays.stream(arr).sum();

        if(sum % 2 == 1 ){
            return 0;
        }else{
            return equalPartition_util(sum/2,arr)?1:0;
        }
    }

    static boolean equalPartition_util(int sum, int arr[])
    {
        Arrays.sort(arr);

        boolean [][] subSet = new boolean[arr.length][sum+1];

        //filling first column

        for (int i = 0; i < arr.length; i++) {
            subSet[i][0] = true;
        }

        subSet[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (j < arr[i] || subSet[i - 1][j]) {
                    subSet[i][j] = subSet[i - 1][j];
                } else if (j == arr[i]) {
                    subSet[i][j] = true;
                } else {
                    subSet[i][j] = subSet[i - 1][j - arr[i]];
                }
            }
        }

        return subSet[arr.length - 1][sum];
    }

    public static void printArr(boolean[][] subset){
        for (int i = 0 ; i< subset.length ; i++){
            for (int j = 0 ; j< subset[0].length ;j++){
                System.out.print(" "+ subset[i][j]+" ");
            }
            System.out.println();
        }

    }
}



