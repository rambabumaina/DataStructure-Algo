package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);

        System.out.println(levelOrder(root));
    }


    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            int i =0;
            while (i < size){
               TreeNode temp = queue.poll();


               if (temp !=null)
               level.add(temp.val);

               if(temp.left != null){
                   queue.offer(temp.left);
               }

               if(temp.right != null){
                    queue.offer(temp.right);
               }

                i++;
            }
            order.add(level);
        }
        return order;
    }
}
