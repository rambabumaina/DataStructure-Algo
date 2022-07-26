package yashasvi.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class Construct_Tree_Preorder_Inorder_Traversal {
    static int index = 0;

    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preOrder, inOrder);

        printTreeNode(treeNode);
    }

    private static void printTreeNode(TreeNode treeNode) {

        if (treeNode == null) return;

        System.out.println(treeNode.data);
        printTreeNode(treeNode.left);
        printTreeNode(treeNode.right);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, map);
    }

    private static TreeNode helper(int[] preorder, int Istart, int Iend, Map<Integer, Integer> map) {

        TreeNode root = null;
        root = new TreeNode(preorder[index++]);
        if (Istart == Iend) {
            return root;
        }

        root.left = helper(preorder, Istart, map.get(root.data) - 1, map);
        root.right = helper(preorder, map.get(root.data) + 1, Iend, map);
        return root;
    }
}
