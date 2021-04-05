package amazon.string;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "";
        System.out.println("==>"+ isValid(s));
    }

    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            if (c == '}' || c == ']' || c == ')') {
                if (!stack.isEmpty() && getMeTheOpening(c) == stack.pop()) {
                    i++;
                }else {
                    return false;
                }
            }else{
                stack.push(c);
                i++;
            }
        }
        return stack.isEmpty();
    }

    private static char getMeTheOpening(char c) {
        char ch;
        switch (c) {
            case '}': {
                ch = '{';
                break;
            }
            case ']': {
                ch = '[';
                break;
            }
            case ')': {
                ch = '(';
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
        return ch;
    }
}
