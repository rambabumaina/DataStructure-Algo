package dp;

import java.util.Arrays;

public class coinsChangingProblem {
    public static void main(String[] args) {

        // int coins[] = {25, 10 , 5 };

        // int total = 30;

//        int coins[] = {1,5,6,8 };

//        int coins[] = {9, 2, 11, 5, 14, 17, 8, 18};

        int total = 50;

        int coins[] = {9, 7, 15, 17, 23, 13, 20, 11, 4, 24};


        System.out.println(minCoins(coins, coins.length, total));
    }

    public static int minCoins(int coins[], int M, int total) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][total + 1];

        // Fill first row
        for (int i = 0; i < total + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }
        }

        // filling rest of the row

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < total + 1; j++) {

                if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j == coins[i]) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i - 1][j] != -1 && dp[i][j - coins[i]] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    } else {
                        if (dp[i][j - coins[i]] > -1) {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }

            }
        }


//        for (int i = 0; i < coins.length; i++) {
//            System.out.print(coins[i] + " ");
//
//            for (int j = 0; j < total + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[coins.length - 1][total];
    }

}
