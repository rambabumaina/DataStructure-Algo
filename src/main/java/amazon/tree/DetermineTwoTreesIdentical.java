package amazon.tree;

import multiThread.deadlock.A;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1
public class DetermineTwoTreesIdentical {



    boolean isIdentical(Node root1, Node root2)
    {
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();

        getListOfNodes(root1,list1);
        getListOfNodes(root2,list2);

        return list1.equals(list2);
    }

    public void getListOfNodes(Node root, ArrayList<Integer> list){
        if( root == null){
            return;
        }
        getListOfNodes(root.left, list);
        list.add(root.data);
        getListOfNodes(root.right,list);
    }


    boolean isIdenticalTrees(Node root1, Node root2)
    {
       if(root1 == null && root2 ==null){
           return true;
       }

       if(root1 != null && root2 != null){
           return (root1.data==root2.data
                   && isIdenticalTrees(root1.left,root2.left)
                   && isIdenticalTrees(root1.right,root2.right));
       }

       return false;
    }



    public static void main(String[] args) {

        DetermineTwoTreesIdentical dti = new DetermineTwoTreesIdentical();
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);



//        System.out.println(dti.isIdentical(root1,root2));

        System.out.println(dti.isIdenticalTrees(root1,root2));
    }

}
