package amazon.tree;

import multiThread.deadlock.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_LeftView {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.right.right = new Node(25);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        BT_LeftView b = new BT_LeftView();
        System.out.println(b.leftView(root));
    }

    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int N = queue.size();

            for (int i = 1; i <= N; i++) {
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
        return list;
    }
}
