package yashasvi.binaryTree;


public class BalancedTree {
    static boolean res = true;

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(39);

        root.left.left = new TreeNode(5);

        System.out.println(isBalanced(root));
    }


    static boolean isBalanced(TreeNode root) {
        height(root);
        return res;
    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        if (Math.abs(l - r) > 1) {
            res = false;
        }

        return Math.max(l, r) + 1;
    }
}
