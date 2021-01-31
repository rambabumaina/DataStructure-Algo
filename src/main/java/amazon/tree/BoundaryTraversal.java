package amazon.tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {

    static void getLeafNode(Node root, LinkedHashSet linkedHashSet) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            linkedHashSet.add(root.data);
        }

        getLeafNode(root.left, linkedHashSet);
        getLeafNode(root.right, linkedHashSet);
    }

    public static void main(String[] args) {
        BoundaryTraversal t = new BoundaryTraversal();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.right.right = new Node(25);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        System.out.println(t.printBoundary(root));

    }

    ArrayList<Integer> printBoundary(Node root) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        getLeftView(root, linkedHashSet);
//        getLeafNode(root, linkedHashSet);
//        getRightView(root, linkedHashSet);

        return new ArrayList<>(linkedHashSet);
    }

    public void getLeftView(Node root, LinkedHashSet linkedHashSet) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int N = queue.size();

            for (int i = 1; i <= N; i++) {
                Node temp = queue.poll();

                if (i == 1) {
                    linkedHashSet.add(temp.data);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
    }

    void getRightView(Node root, LinkedHashSet linkedHashSet) {

        Stack<Integer> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp == null) {
                if (queue.isEmpty()) {
                    break;
                }
                temp = queue.poll();
                stack.push(temp.data);
                queue.offer(null);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }

            if (temp.left != null) {
                queue.offer(temp.left);
            }
        }
        while (!stack.isEmpty()) {
            linkedHashSet.add(stack.pop());
        }
    }


}
