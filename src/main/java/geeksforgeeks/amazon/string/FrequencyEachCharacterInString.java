package geeksforgeeks.amazon.string;

import java.util.HashMap;

public class FrequencyEachCharacterInString {
    public static void main(String[] args) {
        String str = "geekseekforgeeks";
        getFrequency(str);
    }

    public static void getFrequency(String str) {
        char[] ch = str.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();

        int i = 0;
        while (i < ch.length) {
            char c = ch[i];
            if (hm.get(c) != null) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
            i++;
        }

        hm.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
