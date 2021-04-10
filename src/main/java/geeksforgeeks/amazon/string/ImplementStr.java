package geeksforgeeks.amazon.string;

public class ImplementStr {
    public static void main(String[] args) {
//        String haystack = "aaaaa", needle = "baa";
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
            if (needle.equals("")) return 0;
            int n = haystack.length(), m = needle.length();
            int i = 0, j = 0;
            while (i < n - m) {
                while (j < m && i < n - m) {
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                    }
                    break;
                }
                System.out.println(m+" "+j);
                if (m == j+1) {
                    return i - j;
                } else {
                    i = i - j + 1;
                    j = 0;
                }

            }
            return -1;
    }
}

