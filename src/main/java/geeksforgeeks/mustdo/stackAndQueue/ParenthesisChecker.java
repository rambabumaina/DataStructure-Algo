package geeksforgeeks.mustdo.stackAndQueue;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
public class ParenthesisChecker {
    public static void main(String[] args) {
        String str = "{[]}}";

        boolean ispar = ispar(str);
        System.out.println(ispar);
    }

    static boolean ispar(String x) {
        char[] charArray = x.toCharArray();

        Stack<Character> stack = new Stack<>();

        if (charArray[0] == ')' || charArray[0] == ']' || charArray[0] == '}') {
            return false;
        }

        for(int i =0 ; i < charArray.length ; i++) {
            if (charArray[i] == ')' || charArray[i] == ']' || charArray[i] == '}') {
                char opening = getOpening(charArray[i]);
                if (!stack.isEmpty() && opening == stack.pop()) {
                    continue;
                }
            }
            stack.push(charArray[i]);
        }
        return stack.empty();
    }

    private static char getOpening(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        throw new RuntimeException("Invalid Operator");
    }
}
