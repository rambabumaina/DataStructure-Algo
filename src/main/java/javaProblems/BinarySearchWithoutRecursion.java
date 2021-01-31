package javaProblems;

import java.util.Stack;

public class BinarySearchWithoutRecursion {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        BinarySearchWithoutRecursion re = new BinarySearchWithoutRecursion();
        re.inOrderTraversal(node);

    }

    public void inOrderTraversal(Node root) {

        Stack<Node> s = new Stack<>();
        Node temp = root;

        while (temp != null || s.size() > 0) {
            while (temp != null) {
                s.push(temp.left);
                temp = temp.left;
            }
            temp = s.pop();
            System.out.println(temp.data);
        }

    }
}