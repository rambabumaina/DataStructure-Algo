package geeksforgeeks.mustdo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
public class PermutationsOfString {

    public static void main(String[] args) {
        String s = "ljr";
        List<String> permutation = find_permutation(s);
        System.out.println(permutation);

    }

    public static List<String> find_permutation(String S) {

        // Count the Characters first and sore in HasMap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            } else {
                map.put(S.charAt(i), 1);
            }
        }

        int[] count = new int[map.size()];
        Character[] key = new Character[map.size()];
        Character[] result = new Character[S.length()];


        int j = 0;
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            key[j] = s.getKey();
            count[j] = s.getValue();
            j++;
        }

        List<String> list = new ArrayList<>();
        findPermutations(key, count, result, 0, list);
        Collections.sort(list);
        return list;
    }

    private static void findPermutations(Character[] key, int[] count, Character[] result, int depth, List<String> list) {
        if (depth == result.length) {
            updatelist(result, list);
            return;
        }

        for (int j = 0; j < key.length; j++) {
            if (count[j] > 0) {
                result[depth] = key[j];
                count[j]--;
                findPermutations(key, count, result, depth + 1, list);
                count[j]++;
            }
        }
    }

    private static void updatelist(Character[] result, List<String> list) {
        String ss ="";
        for (int i =0 ; i < result.length; i++){
            ss +=result[i];
        }
        list.add(ss);
    }
}
