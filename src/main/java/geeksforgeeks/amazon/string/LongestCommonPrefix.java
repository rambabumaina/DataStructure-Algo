package geeksforgeeks.amazon.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"geeksforgeeks", "geks", "geek", "geezer"};

        System.out.println("Result : " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
         prefix= common(prefix, strs[i]);
        }
        return prefix;
    }

    private static String common(String s1, String s2) {
        String prefix = "";

        int j = 0;
        while (j < s1.length() && j < s2.length()) {
            if (s1.charAt(j) != s2.charAt(j)) {
                break;
            } else {
                prefix += s1.charAt(j);
                j++;
            }
        }
       return prefix;
    }
}
