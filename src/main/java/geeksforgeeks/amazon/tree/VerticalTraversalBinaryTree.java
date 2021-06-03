package geeksforgeeks.amazon.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
public class VerticalTraversalBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(5);

        root.left.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(7);

        root.right.right.left = new Node(6);

        System.out.println(verticalOrder(root));
    }

    static ArrayList<Integer> verticalOrder(Node root)
    {   int h_dist = 0;
        int depth = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Map<Integer, List<CustNode>> m = new TreeMap<>();
        verticalOrder_util(root, m,h_dist, depth);


        Collection<List<CustNode>> values = m.values();
        values.stream().forEach(t->{
            Collections.sort(t, (o1, o2) -> o1.depth -o2.depth);
            t.stream().forEach(h->list.add(h.data));
            });

        return list;
    }

    private static void verticalOrder_util(Node root,
                                           Map<Integer, List<CustNode>> m, int h_dist, int depth) {

        if(root == null){
            return;
        }
        CustNode c = new CustNode(root.data,depth);

        if(!m.containsKey(h_dist)){
            List<CustNode> s = new ArrayList<CustNode>();
            s.add(c);
            m.put(h_dist, s);
        }else {
            List<CustNode> custNodes = m.get(h_dist);
            custNodes.add(c);
            m.put(h_dist,custNodes);
        }

        verticalOrder_util(root.left,m,h_dist-1,depth+1);
        verticalOrder_util(root.right,m, h_dist+1, depth+1);

    }

    static class CustNode{
        int data;
        int depth;

        CustNode(int data, int depth){
            this.depth = depth;
            this.data= data;
        }
    }
}
