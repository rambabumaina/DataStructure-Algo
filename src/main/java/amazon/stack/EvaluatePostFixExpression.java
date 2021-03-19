package amazon.stack;

import java.util.Stack;

public class EvaluatePostFixExpression {
    public static void main(String[] args) {
        String S = "231*+9-";
        System.out.println(evaluatePostFix(S));
    }


    public static int evaluatePostFix(String S) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (isOperator(S.charAt(i))) {
                stack.push(calculate(stack, S.charAt(i)));
            } else {
                stack.push((int) S.charAt(i) - 48);
            }
        }
        return stack.peek();
    }

    private static boolean isOperator(Character ch) {
        if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
            return true;
        }
        return false;
    }

    private static int calculate(Stack<Integer> stack, char ch) {
        if (stack.size() >= 2) {
            int n1 = stack.pop();
            int n2 = stack.pop();
            switch (ch) {
                case '*': {
                    return n2 * n1;
                }
                case '+': {
                    return n2 + n1;
                }
                case '/': {
                    return n2 / n1;
                }
                case '-': {
                    return n2 - n1;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
