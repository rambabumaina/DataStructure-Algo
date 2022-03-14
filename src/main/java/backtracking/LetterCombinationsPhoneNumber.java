package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String input = "12";
        System.out.println("Result : "+ letterCombinations(input));
    }

    static List<String> letterCombinations(String digits) {

        Map<Character, String> keyPad = Map.of('1',"abc",'2', "def",'3',
                                                "ghi",'4',"jkl", '5',"mno",'6',"pqr",
                                                '7',"stu",'8',"vwx", '9',"yz");

        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()){
            helper(digits, keyPad, 0, "", result);
        }
        return result;
    }

    private static void helper(String digits, Map<Character, String> keyPad, int index, String current, List<String> result) {

        if(index >= digits.length()){
            result.add(current);
            return;
        }

        String values = keyPad.get(digits.charAt(index));

        for (int i = 0; i < values.length(); i++) {
            String x = current+ values.charAt(i);
            helper(digits,keyPad,index+1,x,result);
        }
    }
}
