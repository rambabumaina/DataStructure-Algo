package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        int sum =0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for (int i =0 ; i < s.length(); i++){
            int s1 = map.get(s.charAt(i));

            if(i+1 < s.length()) {
                int s2 = map.get(s.charAt(i + 1));

                if (s1 >= s2) {
                    sum = sum + s1;
                }
                else{
                    sum = sum - s1 + s2;
                    i++;
                }

            }else{
                sum  = sum +s1;
            }
        }

        return sum;
    }
}
