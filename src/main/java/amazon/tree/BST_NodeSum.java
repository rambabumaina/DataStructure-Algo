package amazon.tree;

import java.util.ArrayList;

public class BST_NodeSum {

    public void isPairPresent_util(Node root, ArrayList<Integer> list)
    {
        if(root == null){
             return;
        }
        isPairPresent_util(root.left, list);
        list.add(root.data);
        isPairPresent_util(root.right,list);
    }

    public int isPairPresent(Node root, int target)
    {
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();
        isPairPresent_util(root, list);

        int i =0, j= list.size()-1;

        while (j>i){
            if(list.get(i) + list.get(j) == target){
                flag = true;
                break;
            }else if(list.get(i) + list.get(j) > target)
                j--;
            else i++;
        }
        return flag?1:0;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

    }
}
