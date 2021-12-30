package leetcode.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String [] Input  = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(Input));
    }

    static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }

        if(strs.length == 1 ){
            return strs[0];
        }

        int i =1;
        String prefix = strs[0];

        while( i < strs.length){
            prefix =longestCommonPrefixUtil(prefix, strs[i]);
            i++;
        }
        return prefix;
    }

    private static String longestCommonPrefixUtil(String prefix, String str) {
        String p ="";

        for(int i =0, j =0 ; i< prefix.length() && j <str.length() ; i++, j++){
            if(prefix.charAt(i) != str.charAt(j)){
                break;
            }
            p = p+prefix.charAt(i);
        }
        return p;
    }
}
