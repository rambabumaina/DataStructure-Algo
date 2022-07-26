package binarySearch.com.bst;

import binarySearch.com.Tree;

public class ListToBinarySearchTree {
    public static void main(String[] args) {

       int [] nums = {0, 1, 2, 3, 4};
        Tree root = solve(nums);
        printTree(root);
    }

    private static void printTree(Tree root){
        if(root == null) return;

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    private static Tree solve(int[] nums) {
        return bst(nums, 0, nums.length);
    }

    private static Tree bst(int [] nums,int l, int r){
        Tree root = null;
        int m = (int) Math.floor((l+r)/2);

        if(l< r){
            root = new Tree(nums[m]);
            root.left = bst(nums, l, m);
            root.right = bst(nums, m+1, r);
        }
        return root;
    }
}
