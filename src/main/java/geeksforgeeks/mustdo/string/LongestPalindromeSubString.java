package geeksforgeeks.mustdo.string;

public class LongestPalindromeSubString {

    public static void main(String[] args) {
        String str = "aaaabbaa";
        int i = longestPalin(str);
        System.out.println(i);
    }

    static int longestPalin(String S) {
        int len = S.length();
        int dp[][] = new int[len][len];

        int max = 1;

        //fill 1 length staring length since it is always palindrome
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        //fill 2 length string by comparing start index and end index
        for (int i = 1; i < len; i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                dp[i - 1][i] = 1;
                if (max < 2) {
                    max = 2;
                }
            } else {
                dp[i - 1][i] = 0;
            }
        }

        //More then 2 length String
        for (int k = 3; k < len; k++) {

            for (int i = 0; i < len-k+1; i++) {
                int j = i+k-1;

                if (S.charAt(i) == S.charAt(j) && dp[i + 1][j-1] == 1) {
                    dp[i][j] = 1;
                    if (max < k) {
                        max = k;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        printArray(dp);
        return max;
    }

    private static void printArray(int[][] dp) {

        for (int i =0 ; i < dp.length ; i ++){
            for (int j=0 ; j < dp.length ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
