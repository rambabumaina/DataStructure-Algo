package leetcode.binaryTree;



public class SortedArrayToBinaryTree {
    public static void main(String[] args) {
        int[] input = {-10,-3,0,5,9};
        
        TreeNode result = sortedArrayToBST(input);
        printTree(result);

    }


    private static void printTree(TreeNode result) {
        if (result == null) {
            return;
        }

        System.out.print(result.val + " ");
        printTree(result.left);
        printTree(result.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBSTUtil(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low)/2;
        TreeNode root  = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTUtil(nums, low , mid-1);
        root.right = sortedArrayToBSTUtil(nums, mid+1 , high);

        return root;
    }

}
