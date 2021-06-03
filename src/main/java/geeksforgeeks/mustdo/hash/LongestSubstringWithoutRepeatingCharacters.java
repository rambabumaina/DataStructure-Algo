package geeksforgeeks.mustdo.hash;


import java.util.HashSet;
import java.util.Set;

//https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/

/**
 * Approach is :
 * Take set to store unique element: and take two pointers l and r
 * Run loop until r < n
 * Check if r in present in the set, if not then store it and calculate length(r-l)+1 and increase r (r++)
 * else remove element at l from set and l++
 * Return length
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String S = "geeksforgeeks";
        String S = "abdefgabef";
        int len = longestUniqueSubsttr(S);

        System.out.println(len);
    }

    static int longestUniqueSubsttr(String S) {
        if (S == null) return 0;

        Set<Character> set = new HashSet<>();
        int MaxLength = Integer.MIN_VALUE;

        int l = 0, r = 0;
        while (r < S.length()) {
            if (!set.contains(S.charAt(r))) {
                MaxLength = Math.max(MaxLength, (r - l) + 1);
                set.add(S.charAt(r));
                r++;
            } else {
                set.remove(S.charAt(l));
                l++;
            }
        }
        return MaxLength;
    }
}
