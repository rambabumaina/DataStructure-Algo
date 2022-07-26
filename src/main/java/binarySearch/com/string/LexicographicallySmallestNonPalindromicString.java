package binarySearch.com.string;

import java.util.Arrays;

public class LexicographicallySmallestNonPalindromicString {
    public static void main(String[] args) {
//        String str = "racecar";
        String str = "aa";
        System.out.println(solve(str));
    }

    private static String solve(String s) {
        char[] arr = s.toCharArray();
        for (int i =0 ; i < arr.length/2; i++){
            if(arr[i] != 'a'){
                 arr[i]= 'a';
                return new String(arr);
            }
        }

        arr[arr.length-1] = 'b';
        return new String(arr);
    }
}
