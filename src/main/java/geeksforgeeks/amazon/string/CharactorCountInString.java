package geeksforgeeks.amazon.string;

import java.util.Arrays;

public class CharactorCountInString {
    public static void main(String[] args) {

//        String str = "aaabcddaABCD%*@";
//
//        int [] count = new int[256];
//        for (int i=0 ; i< str.length();i++){
//            char c = str.charAt(i);
//            count[c]++;
//        }

        String str = "aaabcdda";

        int [] count = new int[26];
        for (int i=0 ; i< str.length();i++){
            char c = str.charAt(i);
            count[c-97]++;
        }

        Arrays.stream(count).forEach(s -> System.out.print(s + " "));
    }
}
