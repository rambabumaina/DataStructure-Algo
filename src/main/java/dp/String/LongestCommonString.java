package dp.String;

class LongestCommonString {

    public static void main(String[] args) {
        String str2 = "abcdaf";
        String str1 = "zbcdf";

        System.out.println(longestCommonSubString(str1, str2));
    }

    int longestCommonSubstr(String S1, String S2, int n, int m){
        int sum = Integer.MIN_VALUE;

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < S1.length() + 1; i++) {
            for (int j = 1; j < S2.length() + 1; j++) {

                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (sum < dp[i][j]) {
                        sum = dp[i][j];
                    }
                }
            }
        }
        return sum;
    }


    public static int longestCommonSubString(String s1, String s2) {
        int sum = Integer.MIN_VALUE, index1 = 0, index2 = 0;

        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (sum < dp[i][j]) {
                        sum = dp[i][j];
                        index1 = i;
                        index2 = j;
                    }

                }
            }
        }

        System.out.println(findSubString(dp, index1, index2, s1));
        System.out.println(sum + " " + index1 + " " + index2);

        printMatrix(dp);
        return 0;
    }


    //        String str1 = "xyzabcd"; row
    //        String str2 = "abcdxyz"; col
    private static String findSubString(int[][] dp, int i, int j, String str) {

        String res = "";
        while (dp[i][j] != 0) {
            res = str.charAt(i - 1) + res;
            i--;
            j--;
        }
        return res;
    }


    private static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int findCount(int[][] dp) {
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (count < dp[i][j]) {
                    count = dp[i][j];
                }
            }
        }
        return count;
    }
}
