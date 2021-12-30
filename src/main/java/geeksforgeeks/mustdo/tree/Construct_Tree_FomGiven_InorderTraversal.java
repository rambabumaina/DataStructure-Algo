package geeksforgeeks.mustdo.tree;

import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
public class Construct_Tree_FomGiven_InorderTraversal {
    public static void main(String[] args) {
        int[] inorder = {5, 10, 40, 30, 28};
//        int inorder[] = {1, 5, 10, 40, 30, 15, 28, 20};
        Node root = null;
        root =createTreeInorder(inorder, root, 0, inorder.length-1);
        printTree(root);
    }

    private static void printTree(Node root) {
        if(root ==null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    private static Node createTreeInorder(int[] inorder, Node root, int low, int high) {

        if (low > high) {
            return null;
        }

        int index = findMaxIndex(inorder, low, high);
        System.out.println(index);
        root = new Node(inorder[index]);

        if (low == high)
            return root;

        root.left=createTreeInorder(inorder, root.left, low, index - 1);
        root.right=createTreeInorder(inorder, root.right, index + 1, high);

        return root;
    }

    private static int findMaxIndex(int[] inorder, int low, int high) {
        int maxVal =Integer.MIN_VALUE, maxIndex = -1;

        for(int i =low ; i <= high ; i++){
            if(maxVal < inorder[i]){
                maxVal = inorder[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
