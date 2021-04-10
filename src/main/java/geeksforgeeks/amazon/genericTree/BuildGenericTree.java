package geeksforgeeks.amazon.genericTree;

import java.util.Stack;

public class BuildGenericTree {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 70, -1, 80, -1, 90, -1, -1, 60, -1, -1, 30, -1, 40, -1, -1};

        Node root = buildGenericTree(arr);
        displayTree(root);
    }

    private static void displayTree(Node root) {

        if (root == null) {
            return;
        }

        String data = root.data + " -> ";
        for (Node child : root.children) {
            data += child.data + " ";
        }
        System.out.println(data);

        for (Node child : root.children){
            displayTree(child);
        }
    }

    private static Node buildGenericTree(int[] arr) {
        Node root = null;
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == -1) {
                stack.pop();
            } else {
                Node node = new Node(arr[i]);
                if (!stack.isEmpty()) {
                    stack.peek().children.add(node);
                    stack.push(node);
                } else {
                    stack.push(node);
                    root = node;
                }
            }
        }
        return root;
    }
}
