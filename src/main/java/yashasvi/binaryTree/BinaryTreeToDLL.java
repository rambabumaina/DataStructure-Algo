package yashasvi.binaryTree;
//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
//https://www.youtube.com/watch?v=nGNoTdav5bQ
public class BinaryTreeToDLL {
    private static TreeNode head;
    private static TreeNode prev;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(36);

        convertToDll(root);

      printDll(head);
      System.out.println();
      printDll1(prev);
    }

    private static void convertToDll(TreeNode root) {
        if(root == null) return;

        convertToDll(root.left);

        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToDll(root.right);
    }


    private static void printDll(TreeNode head1) {
        if(head1 == null)return;

        System.out.print("-> "+head1.data);
        printDll(head1.right);
    }

    private static void printDll1(TreeNode head2) {
        if(head2 == null)return;

        System.out.print("-> "+head2.data);
        printDll(head2.left);
    }

}
