package geeksforgeeks.amazon.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointNextHigherValueNode {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.next = new Node(10);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);

        setArbitraryPointer(node);

    }

    private static void setArbitraryPointer(Node node) {

        List<Node> list = new ArrayList<>();//o(n)
        Node temp = node;
            while (temp != null){
                list.add(temp);
                temp = temp.next;
            }

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.data-o2.data;
                }
            });
             Node previous = list.get(0);
            for (int i = 1 ; i < list.size() ; i++){
                Node current = list.get(i);
                previous.arbitrary =current;
                previous = current;
            }

            Node p = list.get(0);
            while(p != null){
                System.out.print("->"+ p.data+" ");
                p = p.arbitrary;
            }
    }


    static class Node {
        int data;
        Node next;
        Node arbitrary;

        Node(int data) {
            this.data = data;
            next = null;
            arbitrary = null;
        }
    }
}
