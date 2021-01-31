package amazon.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BottomViewOfBT {

    // Method that returns the bottom view.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Node> map = new TreeMap<>();

        bottomViewUtil(root, map, 0, 0);
        map.values().stream().forEach((s) ->{list.add(s.data);});
        return list;
    }

    public void bottomViewUtil(Node root, Map<Integer, Node> map, int hd, int depth) {
        if (root == null) {
            return;
        }
        root.hd = depth;

        if (map.containsKey(hd)) {
            Node temp = map.get(hd);
            if (temp.hd <= depth) {
                map.put(hd, root);
            }
        } else {
            map.put(hd, root);
        }

        bottomViewUtil(root.left, map, hd - 1, depth + 1);  //left
        bottomViewUtil(root.right, map, hd + 1, depth + 1);  //right
    }

    public void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static class Node {
        int data;
        Node left, right;
        int hd;

        Node(int data) {
            this.data = data;
        }
    }





    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);


        BottomViewOfBT bt = new BottomViewOfBT();

        bt.printInorder(root);
        System.out.println();
        System.out.println(">>>"+ bt.bottomView(root));
    }
}
