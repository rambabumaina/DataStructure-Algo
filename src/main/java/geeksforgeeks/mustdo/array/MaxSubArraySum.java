package geeksforgeeks.mustdo.array;


//https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
public class MaxSubArraySum {

    public static void main(String[] args) {
       int [] input = {1,2,3,-2,5};
//        int input[] = {-1,-2,-3,-4};
//        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        maxSubarraySum(input, input.length);
    }


    static int maxSubarraySum(int arr[], int n) {

        int MaxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int start =0;

        for (int i = 0; i < n; i++) {

            currentSum += arr[i];
            if (MaxSum < currentSum) {
                MaxSum = currentSum;
                start = startIndex;
                endIndex = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                startIndex = i+1;
            }
        }

        System.out.println("S:" + start + " e :" + endIndex + " M :" + MaxSum);
        return MaxSum;
    }
}
