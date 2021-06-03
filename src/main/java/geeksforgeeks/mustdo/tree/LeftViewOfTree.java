package geeksforgeeks.mustdo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfTree {
    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//
//        root.left.left.right = new Node(8);

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.right.right = new Node(25);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        getLeftViewOfTree(root);
    }

    static ArrayList<Integer> getLeftViewOfTree(Node root) {

        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 1; i <= size; i++) {

                Node temp = queue.poll();

                if (i == 1) {
                    list.add(temp.data);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }

        System.out.println(list);

        return null;
    }
}
