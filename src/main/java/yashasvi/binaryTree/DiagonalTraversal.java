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


public class DiagonalTraversal {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

//        Map<Integer, List<Integer>> tmap = new HashMap<>();

//        diagonalTraversalRecursive(root, 0, tmap);
//        System.out.println(tmap);

        diagonalTraversalIterative(root);
    }

    //Take map of integer and list
    //take
    private static void diagonalTraversalRecursive(TreeNode root, int level, Map<Integer, List<Integer>> tmap) {

        if (root == null) {
            return;
        }

        List<Integer> list = null;

        if (tmap.get(level) == null) {
            list = new ArrayList<>();
        } else {
            list = tmap.get(level);
        }

        list.add(root.data);
        tmap.put(level, list);

        diagonalTraversalRecursive(root.left, level + 1, tmap);
        diagonalTraversalRecursive(root.right, level, tmap);
    }

    private static void diagonalTraversalIterative(TreeNode root) {

        class TNode {
            TreeNode node;
            int level;

            public TNode(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        Map<Integer, List<Integer>> tmap = new HashMap<>();
        Queue<TNode> queue = new LinkedList<>();
        queue.offer(new TNode(root, 0));

        while (!queue.isEmpty()) {
            TNode curr = queue.poll();

            List<Integer> list = null;
            if (tmap.get(curr.level) == null) {
                list = new ArrayList<>();
            } else {
                list = tmap.get(curr.level);
            }

            list.add(curr.node.data);
            tmap.put(curr.level, list);

            if (curr.node.left != null) {
                queue.offer(new TNode(curr.node.left, curr.level + 1));
            }

            if (curr.node.right != null) {
                queue.offer(new TNode(curr.node.right, curr.level));
            }
        }


        System.out.println(tmap);
    }
}
