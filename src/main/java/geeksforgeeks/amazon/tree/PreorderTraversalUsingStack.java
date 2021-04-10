package geeksforgeeks.amazon.tree;

import java.util.ArrayList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/preorder-traversal/1
public class PreorderTraversalUsingStack {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.right = new Node(50);
        root.right.right.right = new Node(70);

        root.right.right.left = new Node(80);

        System.out.println(preorder(root));
    }

    //root, left , right
    //print root
    //check if left not null then push root into stack
    //If left is null then move to the right side
    // if right is null then pop from stack and continue the same process
    static ArrayList<Integer> preorder(Node root)
    {   list.clear();
        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();

        do{
            list.add(root.data);
            if(root.left != null){
                stack.push(root);
                root = root.left;
            }else{
                root = root.right;
                if(root == null && !stack.isEmpty()){
                    root = stack.pop();
                    if(root.right !=null){
                        root = root.right;
                    }
                }

            }
        }while (!stack.isEmpty() || root !=null);

        return list;
    }
}
