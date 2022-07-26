package yashasvi.binaryTree;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
public class ReverseLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

//        System.out.println(reverseLevelOrder(root));
        reverseLevelOrderRecur(root);
    }

    //USING STACK AND QUEUE
    public static ArrayList<Integer> reverseLevelOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            stack.push(temp);

            if (temp.right != null) {
                queue.offer(temp.right);
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
        }

        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.data);
        }
        return result;
    }


    //USING Recursion
    public static void reverseLevelOrderRecur(TreeNode root) {
        int height = heightOfTheTree(root);

        for (int i = height; i > 0 ; i--) {
            reverseLevelOrderRecurUtil(root, i);
        }
        System.out.println();
    }

    public static void reverseLevelOrderRecurUtil(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            reverseLevelOrderRecurUtil(root.left, level - 1);
            reverseLevelOrderRecurUtil(root.right, level - 1);
        }
    }

    //Time Complexity :O(N) : space : Auxiliary Space: O(Height of the Tree).
    private static int heightOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfTheTree(root.left);
        int right = heightOfTheTree(root.right);

        return Math.max(left, right) + 1;
    }
}

