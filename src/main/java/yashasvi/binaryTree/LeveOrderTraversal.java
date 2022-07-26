package yashasvi.binaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8

 */
public class LeveOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);


//        System.out.println(levelOrder(root));
        levelOrderRecur(root);
    }

    static ArrayList<Integer> levelOrder(TreeNode node) {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            TreeNode temp = queue.poll();
            result.add(temp.data);

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }

        }

        return result;
    }

    //Recursive Approach
    public static void levelOrderRecur(TreeNode root) {
        int height = heightOfTheTree(root);
        for (int i = 1; i <= height; i++) {
            levelOrderRecurUtil(root, i);
        }
        System.out.println();
    }

    public static void levelOrderRecurUtil(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            levelOrderRecurUtil(root.left, level - 1);
            levelOrderRecurUtil(root.right, level - 1);
        }
    }

    private static int heightOfTheTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfTheTree(root.left);
        int right = heightOfTheTree(root.right);

        return Math.max(left, right) + 1;
    }
}

