package geeksforgeeks.amazon.arrays.windowSliding;


//https://www.geeksforgeeks.org/window-sliding-technique/
public class MaximumSumOfKSize {
    public static void main(String[] args) {

//        int[] input = {100, 200, 300, 400};
//        int k = 2;

        int input[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;

        int sum = maxSum(input, input.length, k);
//        int sum = maxSum(input,k);
        System.out.println(sum);

    }

    //1. Brute force Approach
    private static int maxSum(int[] input, int k) {

        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < input.length - k + 1; i++) {

            int currentSum = 0;

            for (int j = i; j < i + k; j++)
                currentSum += input[j];

            MAX = Math.max(currentSum, MAX);
        }

        return MAX;
    }

    // On , Sliding window approach
    private static int maxSum(int[] input, int n, int k) {
        int maxSum = 0;

        for (int i = 0; i < k; i++)
            maxSum += input[i];

        int windowSum = maxSum;
        for (int i = k; i < n; i++) {
            windowSum = windowSum + input[i] - input[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }


        return maxSum;
    }
}
