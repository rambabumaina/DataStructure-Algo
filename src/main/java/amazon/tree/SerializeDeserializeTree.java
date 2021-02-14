package amazon.tree;

import java.util.ArrayList;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
public class SerializeDeserializeTree {
    public static void main(String[] args) {
//        Node root = new Node(20);
//        root.left = new Node(8);
//        root.right = new Node(22);
//
//        root.left.left = new Node(4);
//        root.left.right = new Node(12);
//        root.right.right = new Node(25);
//
//        root.left.right.left = new Node(10);
//        root.left.right.right = new Node(14);


        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(60);


        ArrayList<Integer> list = new ArrayList<>();

        serialize(root,list);
        System.out.println(list);
        Node root1 = deSerialize(list);

        inorder(root1);
        System.out.println();
        preOrder(root1);
        System.out.println();
        postOrder(root1);

    }

    public static void inorder(Node root){

        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " " );
        inorder(root.right);
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " " );
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " " );
    }


    //Preorder (Root, Left, Right)
    //posOrder(Left, right, root)
    public static void serialize(Node root, ArrayList<Integer> A) {

        if(root ==null){
            A.add(-1);
            return;
        }

        A.add(root.data);
        serialize(root.left, A);
        serialize(root.right,A);

    }
    //[10, 20, 40, -1, -1, 60, -1, -1, 30, -1, -1]
    public static Node deSerialize(ArrayList<Integer> A){

        int i =0;
        Node root = new Node(A.get(i));
        i++;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node temp = stack.pop();
            int left = A.get(i++);
            int right = A.get(i++);

            if(left != -1 ){
                Node leftNode = new Node(left);
                temp.left = leftNode;
                stack.push(leftNode);
            }

            if(right != -1 ){
                Node rightNode = new Node(right);
                temp.right = rightNode;
                stack.push(rightNode);
            }
        }

        return root;
    }



}
