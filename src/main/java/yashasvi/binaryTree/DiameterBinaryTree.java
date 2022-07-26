package yashasvi.binaryTree;

//https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

/**
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */
public class DiameterBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        System.out.println(diameter(root));
    }

    private static class Diameter{
        int d =0;
    }

    static int diameter(TreeNode root) {
        Diameter dai = new Diameter();
        diameterUtil(root , dai);
        return dai.d;
    }

    private static int diameterUtil(TreeNode root, Diameter dia) {
        if (root == null) {
            return 0;
        }

        int left = diameterUtil(root.left, dia);
        int right = diameterUtil(root.right, dia);
        dia.d = Math.max(dia.d, left + right + 1);
        return Math.max(left, right)+1;
    }
}
