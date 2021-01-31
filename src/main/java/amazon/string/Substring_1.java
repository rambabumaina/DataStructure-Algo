package amazon.string;

import java.util.Stack;

public class Substring_1 {
    public static void main(String[] args) {

//        String str = "(()(";

        String str = "()(())(()()()()";

        System.out.println(findMaxLen(str));
    }

    static int findMaxLen(String str) {
         Stack<Integer> stack = new Stack<>();
         stack.push(-1);

         int result = 0;

        for (int i = 0 ; i < str.length() ;i++){

            if(str.charAt(i) == '(' ){
                stack.push(i);
            }else {
                if(!stack.empty())
                stack.pop();

                if (!stack.empty())
                    result = Math.max(result, i - stack.peek());
                else
                    stack.push(i);
            }
        }
        return result;
    }
}
