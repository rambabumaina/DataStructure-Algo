package amazon.stack;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);


        System.out.println(stack);
        reverseStack(stack);
        System.out.println(stack);
    }

    private static void addElementAtBottom(Stack<Integer> stack, int n) {
        if (stack.isEmpty()) {
            stack.push(n);
        } else {
            int poppedEle = stack.pop();
            addElementAtBottom(stack, n);
            stack.push(poppedEle);
        }
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int poppedElm = stack.pop();
            reverseStack(stack);
            addElementAtBottom(stack, poppedElm);
        }
    }
}
