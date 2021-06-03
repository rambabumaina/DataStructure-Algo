package dp.String;

//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
//https://www.youtube.com/watch?v=UflHuQj6MVA
public class LongestPalindromicSubString {

    public static void main(String[] args) {
//        String s = "babad";
        String s = "forgeeksskeegfor";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        int maxLen = 1;


        //fill all one length in arrays , Diagonal
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;

        int start = 0;
        //Fill all 2 len String on the array
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = 1;
                start = i;
                maxLen = 2;
            }
        }

        //Fill more than 2 len
        for (int k = 3; k < len; k++) {

            for (int i = 0; i < len-k+1; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    maxLen = k;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
