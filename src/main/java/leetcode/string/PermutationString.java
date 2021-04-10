package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
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

        for (int i = 0; i < str.length(); i++) {
            if (m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            } else {
                m.put(str.charAt(i), 1);
            }
        }

        //Keep characters in char array and count in count array
        Character[] keys = new Character[m.size()];
        int[] count = new int[m.size()];

        int i = 0;
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            keys[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }

        permutation(keys, count);
    }

    private static void permutation(Character[] keys, int[] counts) {

        Arrays.stream(keys).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(counts).forEach(s -> System.out.print(s + " "));
    }
}
