package amazon.string;


public class Palindrome {
    public static void main(String[] args) {
//        String str = "levels";
//        String str = "A car, a man, a maraca";
//        String str = "A man, a plan, a canal: Panama";
        String str =  "race a car";


//        String replace = str.replace(" ", "").replace(",","");
//        System.out.println("Palindrome : " + isPalindrome_0(replace.toLowerCase()));

        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome_0(String str) {
        System.out.print(str);
        System.out.println();

        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    //"A car, a man, a maraca";
    public static boolean isPalindrome(String s) {
        s= s.toLowerCase();

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
       return true;
    }
}
