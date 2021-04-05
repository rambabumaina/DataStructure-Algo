package amazon.string;

public class LongestCommonPrefixDivideAndConquer {
    public static void main(String[] args) {
        String[] strs = {"geeksforgeeks", "geeks", "geek", "geezer"};
        System.out.println(longestCommonPrefix(strs,0, strs.length-1));
    }

    public static String longestCommonPrefix(String[] arr, int l0w, int high) {
        if(high==l0w){
            return arr[l0w];
        }

        if(high>l0w){
        int mid = l0w + (high-l0w)/2;
        String left = longestCommonPrefix(arr, l0w, mid);
        String right = longestCommonPrefix(arr, mid+1, high);
        return common(left,right);
        }

        return null;
    }

    private static String common(String s1, String s2) {
        String prefix = "";

        int j = 0;
        while (j < s1.length() && j < s2.length()) {
            if (s1.charAt(j) != s2.charAt(j)) {
                break;
            } else {
                prefix += s1.charAt(j);
                j++;
            }
        }
        return prefix;
    }
}
