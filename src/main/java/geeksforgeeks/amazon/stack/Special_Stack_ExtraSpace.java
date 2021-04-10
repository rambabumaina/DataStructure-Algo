package geeksforgeeks.amazon.stack;

import java.util.Stack;

public class Special_Stack_ExtraSpace {

    Stack<Integer> stack = new Stack<>();

    Stack<Integer> min_stack = new Stack<>();

    public void push(int a) {

        if (stack.isEmpty()) {
            stack.push(a);
            min_stack.push(a);
        } else {
            if (min_stack.peek() <= a) {
                stack.push(a);
                min_stack.push(min_stack.peek());
            }else{
                stack.push(a);
                min_stack.push(a);
            }
        }

    }

    public int pop() {
        min_stack.pop();
        return stack.pop();
    }

    public int min() {
        return min_stack.peek();
    }


    public static void main(String[] args) {

        Special_Stack_ExtraSpace s = new Special_Stack_ExtraSpace();
        s.push(18);
        System.out.println(s.min());
        s.push(19);
        System.out.println(s.min());
        s.push(29);
        System.out.println(s.min());
        s.push(15);
        System.out.println(s.min());
        s.push(16);
        System.out.println(s.min());
    }
}
