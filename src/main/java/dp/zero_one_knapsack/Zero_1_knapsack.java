package dp.zero_one_knapsack;


class Zero_1_knapsack {
    public static void main(String[] args) {
        int[] weight = {2, 5, 1, 3, 4};
        int[] value = {15, 14, 10, 45, 30};

        int result = knapSack(7, weight, value, weight.length);
        System.out.println(result);
    }

    static int knapSack(int W, int wt[], int val[], int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {//capacity

                if (j < wt[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }

            }
        }

        return dp[n][W];
    }

    public static void print(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }
    }

}
