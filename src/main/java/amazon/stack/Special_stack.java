package amazon.stack;

import java.util.Stack;

public class Special_stack {

    int min_ele = 0;

    public void push(int a, Stack<Integer> s) {
        System.out.println("pushing :"+ a);
        if (s.isEmpty()) {
            s.push(a);
            min_ele = a;
        } else {
            if (a > min_ele) {
                s.push(a);
            } else {
                s.push((a * 2) - min_ele);
                min_ele = a;
            }
        }

    }

    public int pop(Stack<Integer> s) {
        if (s.isEmpty()) {
            min_ele = 0;
            return 0;
        } else {
            if (s.peek() > min_ele) {
                return s.pop();
            } else {
                min_ele = min_ele * 2 - s.peek();
                return s.pop();
            }
        }
    }

    public int min(Stack<Integer> s) {
        return min_ele;
    }

    public boolean isFull(Stack<Integer>s, int n)
    {
        return s.size()==n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        if (s.isEmpty()) {
            return true;
        } else return false;
    }


    public static void main(String[] args) {

        Special_stack s = new Special_stack();

        Stack<Integer> stack = new Stack<>();
        s.push(18, stack);
        System.out.println(s.min_ele);
        s.push(19, stack);
        System.out.println(s.min_ele);
        s.push(29, stack);
        System.out.println(s.min_ele);
        s.push(15, stack);
        System.out.println(s.min_ele);
        s.push(16, stack);
        System.out.println(s.min_ele);

        //pop
        System.out.println("Pop starting....");
        s.pop(stack);
        System.out.println(s.min_ele);
        s.pop(stack);
        System.out.println(s.min_ele);
        s.pop(stack);
        System.out.println(s.min_ele);
        s.pop(stack);
        System.out.println(s.min_ele);
        s.pop(stack);
        System.out.println(s.min_ele);
        s.pop(stack);
        System.out.println(s.min_ele);

    }
}
