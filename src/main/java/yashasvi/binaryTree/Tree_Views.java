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

public class Tree_Views {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(leftView(root));
        System.out.println(rightView(root));
        System.out.println(topView(root));
    }

    static ArrayList<Integer> leftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 1; i <= size; i++) {
                TreeNode curr = q.poll();

                if (i == 1) {
                    result.add(curr.data);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return result;
    }


    static ArrayList<Integer> rightView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 1; i <= size; i++) {
                TreeNode curr = q.poll();

                if (i == size) {
                    result.add(curr != null ? curr.data : 0);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return result;
    }

    //Using TreeMap and logic: left=-1, root=0, right=+1
    public static ArrayList<Integer> topView(TreeNode root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        topViewUtil(root, treeMap, 0);
        return new ArrayList<>(treeMap.values());
    }

    private static void topViewUtil(TreeNode root, TreeMap<Integer, Integer> treeMap, int level) {
        if (root == null) {
            return;
        }

        treeMap.putIfAbsent(level, root.data);

        topViewUtil(root.left, treeMap, level - 1);
        topViewUtil(root.right, treeMap, level + 1);
    }


}
