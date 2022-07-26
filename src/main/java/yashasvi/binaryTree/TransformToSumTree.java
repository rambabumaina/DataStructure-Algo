package yashasvi.binaryTree;

/**
 *              10
 *           /      \
 *         -2        6
 *        /   \     /  \
 *      8     -4   7    5
 */
//https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
public class TransformToSumTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        toSumTree(root);
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if(root == null){
            return;
        }

        System.out.print("->" +  root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void toSumTree(TreeNode root){
        toSumTreeUtil(root);
    }

    public static int toSumTreeUtil(TreeNode root){
        if(root ==null) return 0;

        int left = toSumTreeUtil(root.left);
        int right = toSumTreeUtil(root.right);

        int currentRoot = root.data;
        if(root.left == null && root.right == null){
            root.data = left+right;
            return currentRoot;
        }else{
            root.data = left+right;
            return root.data+currentRoot;
        }
    }
}

