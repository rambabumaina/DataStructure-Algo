package leetcode.twoPointer;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/779/
public class LongestCommonSubStringWithoutRepeat {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //Time O(n), Space O(n)
    //Approach sliding window, once repeated character found, remove fist one from set and add new one.
    // At every step check the size of set and compare with max
    static int lengthOfLongestSubstring(String s) {

        int startWindow =0, endWindow =0, max =0;
        Set<Character> set = new HashSet<>();

        while (endWindow < s.length()){
            char ch = s.charAt(endWindow);

            if (set.contains(ch)){
                set.remove(s.charAt(startWindow));
                startWindow++;
                continue;
            }

            set.add(ch);
            max = Math.max(max, set.size());
            endWindow++;
        }

        return max;
    }
}
