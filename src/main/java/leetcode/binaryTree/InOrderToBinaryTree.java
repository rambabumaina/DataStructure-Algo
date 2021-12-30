package leetcode.binaryTree;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InOrderToBinaryTree {
    public static void main(String[] args) {
        int[] inorder = {5, 10, 40, 30, 28};

        int start =0, end=inorder.length-1;
        System.out.println(findMaxIndex(inorder, start, end));
//        inorderTreeCreation(inorder, start, end);
    }

    private static TreeNode inorderTreeCreation(int[] inorder, int start, int end) {

//        if(start >end){
//            return null;
//        }

//        int max = findMaxIndex(inorder,start, end);
    return null;
    }

    private static int findMaxIndex(int[] inorder, int start, int end) {

        IntStream range = IntStream.range(start, end + 1);
        return 0;
    }
}
