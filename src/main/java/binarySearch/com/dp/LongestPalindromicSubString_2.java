package binarySearch.com.dp;

import java.util.Arrays;

// Logic: reverse string , then compare both strings and fill dp array
// IF both strings has same character than add one on the diagonal value of dp array
public class LongestPalindromicSubString_2 {
    public static void main(String[] args) {
        String s = "mactacocatbook";
//        String s = "bab";
        System.out.println(solve(s));
    }

    static int solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String ss = sb.toString();

        int [][] dp = new int[s.length()+1][s.length()+1];

        int max =0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if(s.charAt(i-1) == ss.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                   max=  Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
