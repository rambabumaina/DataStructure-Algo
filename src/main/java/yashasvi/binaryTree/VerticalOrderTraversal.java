package yashasvi.binaryTree;

//https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *            1
 *         /    \
 *        2      3
 *       / \   /   \
 *      4   5 6    7
 *                /  \
 *               8   9
 *
 * 4,2,1,5,6,3,8,7,9
 *
 * Logic if root= 0
 * root.left = -1
 * root.right = +1
 */
public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        verticalView(root);
    }

    private static void verticalView(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        verticalView_util(root, map, 0);
        System.out.println(map);
    }

    private static void verticalView_util(TreeNode root, TreeMap<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }

        List<Integer> list  = map.get(level);
        if(list == null){
            list =  new ArrayList<>();
            list.add(root.data);
        }else{
            list.add(root.data);
        }

        map.put(level, list);

        verticalView_util(root.left, map, level - 1);
        verticalView_util(root.right, map, level + 1);

    }
}
