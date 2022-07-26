package yashasvi.binaryTree;
//https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1

import java.util.*;


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

public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(zigZagTraversal(root));

    }

    static ArrayList<Integer> zigZagTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> result = new ArrayList<>();
        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();

            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();

                if (level % 2 == 0) {
                    result.add(node.data);
                } else {
                   tempList.add(node.data);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }

            if(level %2 != 0){
                Collections.reverse(tempList);
                result.addAll(tempList);
            }

            level++;
        }
        return result;
    }

}
