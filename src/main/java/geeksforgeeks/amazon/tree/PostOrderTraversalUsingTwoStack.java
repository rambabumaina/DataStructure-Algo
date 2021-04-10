package geeksforgeeks.amazon.tree;

import java.util.Stack;

public class PostOrderTraversalUsingTwoStack {

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

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()){

            root = stack1.pop();
            stack2.push(root);


            if(root.left != null){
                stack1.push(root.left);
            }

            if(root.right != null){
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
    }
}
