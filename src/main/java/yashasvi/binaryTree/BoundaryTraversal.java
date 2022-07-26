package yashasvi.binaryTree;

import java.util.*;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        System.out.println(boundary(root));
    }

    static ArrayList<Integer> boundary(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftTraversal(root, result);
        leafNodeTraversal(root, result);
        rightTraversal(root, result);
        return new ArrayList<>(result);
    }

    private static void leftTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            result.add(root.data);
            leftTraversal(root.left, result);
        } else if (root.right != null) {
            result.add(root.data);
            leftTraversal(root.right, result);
        }
    }

    private static void leafNodeTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        leafNodeTraversal(root.left, result);
        if (root.left == null && root.right == null) {
            result.add(root.data);
        }
        leafNodeTraversal(root.right, result);
    }

    private static void rightTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            rightTraversal(root.right, result);
            result.add(root.data);
        } else if (root.left != null) {
            rightTraversal(root.left, result);
            result.add(root.data);
        }
    }
}
