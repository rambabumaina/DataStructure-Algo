package geeksforgeeks.amazon.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1#
public class LevelOrderTraversalInSpiral {

    public static void main(String[] args) {
        Node tree = new Node(10);

        tree.left = new Node(20);
        tree.right = new Node(30);

        tree.left.left = new Node(40);
        tree.left.right = new Node(60);


        findSpiral(tree).stream().forEach(s-> System.out.print( s + " "));
    }

    static ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Integer> stack = new Stack<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int count = 1;
        while (!queue.isEmpty()) {

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();

                if (count % 2 == 0) {
                    list.add(temp.data);
                } else {
                    stack.push(temp.data);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }


            while (!stack.isEmpty()) {
               list.add(stack.pop());
            }
            count++;
        }
        return list;
    }
}
