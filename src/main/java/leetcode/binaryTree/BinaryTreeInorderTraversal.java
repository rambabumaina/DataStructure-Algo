package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);
        root.right.left = new Node(3);

        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(final Node root) {
        if (root == null) return list;
        inorderTraversal(root.left);
        list.add(root.data);
        inorderTraversal(root.right);
        return list;
    }
}
