package yashasvi.binaryTree;

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

public class TopViewTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(topView(root));

    }

    static class QueNode {
        final TreeNode node;
        final int hd;

        public QueNode(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }

    private static ArrayList<Integer> topView(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        Queue<QueNode> queue = new LinkedList<>();

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        if (root == null) {
            return result;
        }

        queue.offer(new QueNode(0, root));

        while (!queue.isEmpty()) {

            QueNode curr = queue.poll();

            tmap.putIfAbsent(curr.hd, curr.node.data);

            if (curr.node.left != null) {
                queue.add(new QueNode(curr.hd - 1, curr.node.left));
            }

            if (curr.node.right != null) {
                queue.add(new QueNode(curr.hd + 1, curr.node.right));
            }
        }

        return new ArrayList<>(tmap.values());
    }
}
