package binarySearch.com.tree;

import binarySearch.com.Tree;

public class LargestTreeSumPath {
    static int maxPath = 0;

    public static void main(String[] args) {
        Tree root = new Tree(-6);
        root.left = new Tree(5);
        root.right = new Tree(4);

        root.right.left = new Tree(7);
        root.right.right = new Tree(12);

        root.right.left.left = new Tree(4);
        root.right.left.right = new Tree(8);

        root.right.left.left.left = new Tree(2);

        System.out.println(solve(root));
    }

    private static int solve(Tree root) {
        solveUtil(root);
        return maxPath;
    }


    private static int solveUtil(Tree root) {
        if (root == null) return 0;

        int l = solveUtil(root.left);
        int r = solveUtil(root.right);

        l = Math.max(l, 0);
        r = Math.max(r, 0);

        maxPath = Math.max(maxPath, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
