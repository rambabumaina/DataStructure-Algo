package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *  (count_of_charS)!/(count of duplicate)! => 3!/1! = 3*2*1=6
 *
 * 1. Calculate the count of characters using Map
 * 2. Create 2 Arrays one for characters one for count
 * 3. Fill the arrays from map
 * 4.
 */
public class PermutationString {
    public static void main(String[] args) {
        String str = "ABC";
        permutation(str);
    }

    public static void permutation(String str) {
        Map<Character, Integer> m = new HashMap<>();

        // Find the count of each character
        for (int i = 0; i < str.length(); i++) {
            if (m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            } else {
                m.put(str.charAt(i), 1);
            }
        }

        // Keep characters in char array and count in count array
        Character[] keys = new Character[m.size()];
        int[] count = new int[m.size()];

        int i = 0;
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            keys[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }

        Character [] result = new Character[str.length()];
        permutation(keys, count, result, 0);
    }

    private static void permutation(Character[] keys, int[] counts, Character [] result, int depth) {

        if(depth == result.length){
            Arrays.stream(result).forEach(s -> System.out.print(s + " "));
            System.out.println();
            return;
        }

        for (int i =0 ; i< keys.length; i++){
            if(counts[i] > 0){
                result[depth] = keys[i];
                counts[i]--;
                permutation(keys,counts,result,depth+1);
                counts[i]++;
            }

        }
    }
}
