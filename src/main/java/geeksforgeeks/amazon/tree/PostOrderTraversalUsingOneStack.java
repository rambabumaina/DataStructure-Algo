package geeksforgeeks.amazon.tree;

import java.util.Stack;

public class PostOrderTraversalUsingOneStack {

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.right = new Node(50);
        root.right.right.right = new Node(70);

        root.right.right.left = new Node(80);

        postOrder( root);
    }

    public static void postOrder(Node root){

        if(root == null){
            return;
        }


        Stack<Node> stack = new Stack<>();
//        stack.push(root);

        while (!stack.isEmpty()|| root !=null){

            if(root == null){
                root = stack.pop();

                if(!stack.isEmpty() && root.right == stack.peek()){
                    Node temp = stack.pop();
                    stack.push(root);
                    root = temp;

                }else{
                    System.out.print(root.data + " ");
                    root = null;
                }
            }else{
                if(root.right != null){
                    stack.push(root.right);
                }
                stack.push(root);
                root = root.left;
            }
        }
    }

}
