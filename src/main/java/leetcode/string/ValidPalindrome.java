package leetcode.string;

public class ValidPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = ".,";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        System.out.println(s);
        int i = 0, j = s.length() - 1;

        while (i < j) {

            while (i<j && !isValidChar(s.charAt(i))) {
                i++;
            }

            while (i<j && !isValidChar(s.charAt(j))) {
                j--;
            }

            if (i < j && s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private static boolean isValidChar(char ch) {
        return (ch >= 48 && ch <= 57) || (ch >= 97 && ch <= 122);
    }
}
