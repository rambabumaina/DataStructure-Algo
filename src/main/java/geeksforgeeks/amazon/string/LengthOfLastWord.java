package geeksforgeeks.amazon.string;

public class LengthOfLastWord {

    public static void main(String[] args) {
//        String s = "Hello World";
        String s = "      ";
        System.out.println(lengthOfLastWord(s));
    }

    private static boolean isWhite(String s) {
        int i = 0;
        while (i < s.length()) {
            if (Character.isWhitespace(s.charAt(i))) {
                i++;
            } else {
                break;
            }
        }
        if (i == s.length()) {
            return true;
        }
        return false;
    }

    public static int lengthOfLastWord(String s) {
        if (s.isEmpty() || isWhite(s)) {
            return 0;
        } else {
            String[] arr = s.split(" ");
            return arr[arr.length - 1].length();
        }
    }

    //Best solution
    public static int wowSolution(String s){
        s = s.trim();
        System.out.println(s.length()+ " " + s.lastIndexOf(" "));
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
