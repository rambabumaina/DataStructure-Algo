package geeksforgeeks.amazon.tree;

import java.util.Stack;

public class InorderUsingStack {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);

        root.right.right = new Node(50);
        root.right.right.right = new Node(70);

        root.right.right.left = new Node(80);

        inorder(root);
    }

    static void inorder(Node root){

        Stack<Node> stack = new Stack<>();

        do {
            if(root.left !=null){
                stack.push(root);
                root = root.left;

            }else {
                System.out.print(root.data + " ");

                if (root.right == null) {
                    if (!stack.isEmpty()) {
                        root = stack.pop();
                        System.out.print(root.data + " ");
                    }
                }
                root = root.right;
            }
        }while (!stack.isEmpty() || root !=null);
    }
}
