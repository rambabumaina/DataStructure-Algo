package recursion;

//12321
public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println("isPalindrome : " + isPalindrome(n));

        String str = String.valueOf(n);
        System.out.println("isPal : " + isPal(str, 0, str.length() - 1));
    }

    private static boolean isPalindrome(int n) {
        return n == ReverseNumber.reverseNumber(n);
    }

    private static boolean isPal(String str, int s, int e) {
        if (s > e) {
            return true;
        }

        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }

        return isPal(str, ++s, --e);
    }
}

