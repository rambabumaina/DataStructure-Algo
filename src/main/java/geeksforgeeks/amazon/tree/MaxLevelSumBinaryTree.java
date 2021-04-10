package geeksforgeeks.amazon.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(3);
        root.right = new Node(1);

        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(Node root) {
        if (root ==null){
            return -1;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int maxSum=Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int sum = 0;
            int len = q.size();
            for (int i=0; i < len; i++){
                Node temp = q.poll();

                if(temp.left != null)
                q.offer(temp.left);

                if(temp.right != null)
                    q.offer(temp.right);
                sum += temp.data;
            }
           maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
