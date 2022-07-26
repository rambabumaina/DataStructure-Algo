package yashasvi.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


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

public class BottomViewTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(bottomView(root));
    }

    static class QNode{
        int hd;
        TreeNode node;

        public QNode(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }

    //Using TreeMap and logic: left=-1, root=0, right=+1
    public static ArrayList<Integer> bottomView(TreeNode root) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        if(root == null){
           return new ArrayList<>();
        }

        Queue<QNode> queue = new LinkedList<>();
        queue.offer(new QNode(0, root));

        while (!queue.isEmpty()){
            QNode curr = queue.poll();

            treeMap.put(curr.hd, curr.node.data);

            if (curr.node.left != null){
                queue.offer(new QNode(curr.hd-1, curr.node.left));
            }

            if (curr.node.right != null){
                queue.offer(new QNode(curr.hd+1, curr.node.right));
            }
        }

        return new ArrayList<>(treeMap.values());
    }
}
