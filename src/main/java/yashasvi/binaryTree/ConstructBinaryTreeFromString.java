package yashasvi.binaryTree;


import java.util.Stack;

public class ConstructBinaryTreeFromString {

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
//        String str = "4(1)(2)";
        TreeNode root = solve(str);
        print(root);
    }

    // Use stack

    private static TreeNode solve(String str) {
        int start = 0;
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();

        while (start < str.length()) {
            char c = str.charAt(start);

            if( Character.isDigit(c) || c == '-'){
                if ('-' == c) {
                    flag = true;
                    start++;
                }

                int num = 0;
                while (start < str.length() && Character.isDigit(str.charAt(start))) {
                    num = num * 10 + str.charAt(start) - '0';
                    start++;
                }

                if (flag) {
                    num = -num;
                    flag = false;
                }

                TreeNode root = new TreeNode(num);
                if (!stack.isEmpty()) {
                    TreeNode peek = stack.peek();

                    if (peek.left == null) {
                        peek.left = root;
                    } else {
                        peek.right = root;
                    }
                }
                stack.add(root);
                continue;

            } else if (c == ')') {
                stack.pop();
            }
            start++;
        }

        return stack.pop();
    }



    private static void print(TreeNode node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }
}
