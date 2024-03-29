package geeksforgeeks.amazon.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_LeftView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(25);


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
