package leetcode.binaryTree;

import java.util.function.Predicate;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/
public class ArrayToCompleteBinaryTree {

    public static void main(String[] args) {
        int[] input = {-10, -3,0,5,9};

        TreeNode result = sortedArrayToBST(input);
        printTree(result);
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        return build(nums,root, 0);
    }

    private static TreeNode build(int[] input, TreeNode root, int i) {

        if (i < input.length) {
            root = new TreeNode(input[i]);

            root.left = build(input, root.left, 2 * i + 1);
            root.right = build(input, root.right, 2 * i + 2);
        }
        return root;
    }


    private static void printTree(TreeNode result) {
        if (result == null) {
            return;
        }

        System.out.print(result.val + " ");
        printTree(result.left);
        printTree(result.right);
    }

}
