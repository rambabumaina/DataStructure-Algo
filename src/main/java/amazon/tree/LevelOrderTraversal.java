package amazon.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){

            Node polled_node = queue.poll();
            System.out.println("->" +polled_node.data);

            if(polled_node.left != null){
                queue.offer(polled_node.left);
            }

            if(polled_node.right != null){
                queue.offer(polled_node.right);
            }
        }
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        levelOrderTraversal(node);

    }
}
