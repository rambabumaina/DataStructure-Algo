package binarySearch.com.dp;

import java.util.Arrays;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String s = "mactacocatbook";
//        String s = "bab";
        System.out.println(solve(s));
    }

    static int solve(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];

        //Check single length string
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        // Check 2 length string
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
                maxLen = 2;
            }
        }

        //For more than 2 length strings..
        //Here K is length of string
        for (int k = 3; k <= dp.length; k++) {

            for (int i = 0; i < dp.length - k + 1; i++) {
                int j = i+k - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = Math.max(maxLen, (j - i + 1));
                }
            }
        }
        Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        return maxLen;
    }
}
