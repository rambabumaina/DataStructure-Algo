package leetcode.string;

import java.util.Arrays;

public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    static int firstUniqChar(String s) {

        int[] count = new int[256];

        Arrays.fill(count, -1);

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == -1) {
                count[s.charAt(i)] = i;
            } else {
                count[s.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int c : count)
            if(c>=0) res = Math.min(res, c);

        return res ==Integer.MAX_VALUE?-1:res;
    }
}
