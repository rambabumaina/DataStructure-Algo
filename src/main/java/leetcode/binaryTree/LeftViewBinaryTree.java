package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.right = new TreeNode(25);

        leftView(root);
    }

    private static void leftView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){

                TreeNode temp = queue.poll();

                if (i ==0){
                    System.out.println(temp.val);
                }

                if(temp.left !=null){
                    queue.offer(temp.left);
                }

                if(temp.right !=null){
                    queue.offer(temp.right);
                }
            }
        }
    }
}
