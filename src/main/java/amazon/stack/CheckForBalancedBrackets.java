package amazon.stack;

import java.util.Stack;

public class CheckForBalancedBrackets {
    public static void main(String[] args) {
//        String str = "([{}])";
        String str = "(";

        System.out.println(ispar(str));
    }

    private static boolean ispar(String str) {
        Stack<Character> stack = new Stack<>();

        if (str == null || str.charAt(0) == '}' || str.charAt(0) == ']' || str.charAt(0) == ')') {
            return false;
        }
        stack.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch == ']' || ch == ')' || ch == '}') {
                if (!stack.isEmpty() && getOpeningBraket(ch) == stack.pop()) {
                    continue;
                }
            }
            stack.push(ch);
        }

      return stack.isEmpty();
    }

    private static Character getOpeningBraket(Character ch) {
        if (ch == ')') {
            return '(';
        } else if (ch == ']') {
            return '[';
        } else {
            return '{';
        }
    }
}
