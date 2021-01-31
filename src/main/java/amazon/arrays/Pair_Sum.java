package amazon.arrays;

import java.util.Arrays;

public class Pair_Sum {

    public static void main(String[] args) {

        int sum =50;

        int[] arr = {8,9,4,20,30,26,28,40};

        System.out.println(is_pair_exists(arr, sum));

    }

    public static boolean is_pair_exists(int[] arr, int sum){

        Arrays.sort(arr);

        for (int i = 0, j = arr.length-1; j > i; ) {

            if(arr[i] + arr[j] == sum){
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
