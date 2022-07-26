package binarySearch.com.tree;

import binarySearch.com.Tree;

/**
 * 1
 * /
 * 2
 * /
 * 3
 * <p>
 * 2
 * /
 * 3
 */
public class Subtree {
    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        root.right.left = new Tree(4);
        root.right.right = new Tree(5);

        root.right.left.left = new Tree(6);
        root.right.right.right = new Tree(7);


        Tree target = new Tree(3);
        target.left = new Tree(4);
        target.right = new Tree(5);
        target.left.left = new Tree(6);
        target.right.right = new Tree(7);

//        Tree root = new Tree(1);
//        root.left = new Tree(2);
//
//        Tree target = new Tree(3);
//        target.left = new Tree(2);

        System.out.println(solve(root, target));
    }

    private static boolean solve(Tree root, Tree target) {
        if (root == null) return true;
        if(target == null) return false;

        return solveUtil(root, target)||
                solveUtil(root.left,target.left) ||
                solveUtil(root.right, target.right);
    }

    private static boolean solveUtil(Tree root, Tree target) {

        if (root == null && target == null) return true;
        if (root == null || target == null) return false;

        return root.val == target.val && solveUtil(root.left, target.left) && solveUtil(root.right, target.right);
    }
}
