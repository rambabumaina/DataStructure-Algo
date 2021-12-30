package leetcode.binaryTree;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        if (root ==null) return true;
        return isMirror(root.left,root.right);
    }

    private static boolean isMirror(TreeNode root, TreeNode root1) {

        if(root == null && root1 ==null) return true;
        if(root == null || root1 == null) return false;

        return (root.val == root1.val) && isMirror(root.left, root1.right) &&isMirror(root.right, root1.left);
    }
}
