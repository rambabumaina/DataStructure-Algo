package geeksforgeeks.amazon.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfTree {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);

        root.right.left=new Node(6);
        root.right.right=new Node(7);

        root.left.right.left=new Node(8);
        root.left.right.left.left=new Node(9);
        root.left.right.left.left.left=new Node(10);

        root.left.right.right=new Node(11);
        root.left.right.right.right=new Node(12);
        root.left.right.right.right.right=new Node(13);
        ArrayList<Integer> list = topView(root);
        System.out.println(list);
    }

    static ArrayList<Integer> topView(Node root)
    {
        TreeMap<Integer,Integer> treemap = new TreeMap<>();

        Queue<QNode> queue = new LinkedList<>();
        queue.offer(new QNode(0, root));

        while (!queue.isEmpty()){
            QNode temp = queue.poll(); //0
            treemap.putIfAbsent(temp.hd, temp.node.data);

                if(temp.node.left != null) {
                    queue.offer(new QNode(temp.hd -1, temp.node.left));
                }

                if(temp.node.right != null) {
                    queue.offer(new QNode(temp.hd+1, temp.node.right));
                }
            }

        return new ArrayList<>(treemap.values());
    }

    static class QNode{
        int hd;
        Node node;

        QNode(int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }
}
