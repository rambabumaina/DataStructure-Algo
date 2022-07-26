package binarySearch.com.string;

public class BalancedBrackets {
    public static void main(String[] args) {
//        String s = ")((()))";
        String s = "())(";
        System.out.println(solve(s));
    }

    private static boolean solve(String s) {
        if (s.isEmpty()) return true;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (count == 0 && s.charAt(i) == ')') {
                return false;
            } else {
                if (s.charAt(i) == '(') {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count == 0;
    }
}
