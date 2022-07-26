package yashasvi.binaryTree;

import binarySearch.com.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
          10
         /  \
        30   15
       /      \
      20       5
 */

public class BinaryTreeToBst {
    static int index =0;
    public static void main(String[] args) {
        Tree root = new Tree(10);
        root.left = new Tree(30);
        root.left.left = new Tree(20);
        root.right = new Tree(15);
        root.right.right = new Tree(5);
        
        solve(root);
    }

    private static Tree solve(Tree root) {
        List<Integer> list = new ArrayList<>();
        getInorderTraversal(root, list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        buildBst(root, list);
        printTree(root);
        return null;
    }

    private static void printTree(Tree root) {
        if(root == null) return;

        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    private static void buildBst(Tree root, List<Integer> list) {
        if (root ==null) return;

        buildBst(root.left, list);
        root.val = list.get(index);
        index++;
        buildBst(root.right, list);
    }

    private static void getInorderTraversal(Tree root, List list) {
        if(root == null){
            return;
        }
        getInorderTraversal(root.left, list);
        list.add(root.val);
        getInorderTraversal(root.right, list);
    }


}
