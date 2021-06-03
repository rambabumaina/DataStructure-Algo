package dp.array;

public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] input = {
                {9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}};

        System.out.println("=>" + minimumCostPath(input));
    }

    public static int minimumCostPath(int[][] input) {
        int n = input.length;
        int m = input[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = input[0][0];

        //fill first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + input[0][i];
        }

        //fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + input[i][0];
        }

        //Fill remaining values using
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = input[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        for (int x = 0; x < dp.length; x++) {
            for (int y = 0; y < dp[0].length; y++) {
                System.out.print(dp[x][y] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][m - 1];
    }
}
