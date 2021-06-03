package geeksforgeeks.mustdo.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckIfStringCanBeAPalindrome {

    public static void main(String[] args) {
        String str = "madam";

//        usingCountArray(str);
        usingHasMap(str);
    }


    public static void usingHasMap(String str){
        Map<Character, Integer> map = new HashMap<>();

        for (int i =0 ; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        Collection<Integer> values = map.values();
        int count =0;
        for ( Integer i :values){
            if(i % 2 !=0){
                count++;
            }
        }

        if(count >1){
            System.out.println("its not a Palindrome");
        }else{
            System.out.println("its a Palindrome");
        }

    }




    private static void usingCountArray(String str) {
        int[] count = new int[25];
        //
        for (int i =0 ; i < str.length() ; i++){
            count[str.charAt(i)-97]++;
        }

        int c =0;
        for (int i =0 ; i< count.length;i++){
            if(count[i] %2 !=0){
                c++;
            }
        }

        if (c != 1) {
            System.out.println("can not be a palindrome");
        }else {
            System.out.println("String can be a palindrome");
        }
    }
}
