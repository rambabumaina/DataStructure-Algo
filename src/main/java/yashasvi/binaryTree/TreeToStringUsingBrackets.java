package yashasvi.binaryTree;

public class TreeToStringUsingBrackets {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(tree2str(root));
    }

    //"1(2(4))(3)"
    private static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        helper(root, sb);
        return sb.toString();
    }

    private static void helper(TreeNode root, StringBuffer sb) {
        sb.append(root.data);

        if (root.left != null) {
            sb.append("(");
            helper(root.left, sb);
            sb.append(")");
        }

        if (root.right != null) {
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}