package yashasvi.binaryTree;
//https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
public class MirrorTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        display(root);
        System.out.println();
        TreeNode mirrorTree = mirrorTree(root);
        display(mirrorTree);
    }

    private static void display(TreeNode root) {
        if (root == null){
            return;
        }

        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }


    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode mirror = new TreeNode(root.data);
        mirror.right = mirrorTree(root.left);
        mirror.left = mirrorTree(root.right);
        return mirror;
    }
}
