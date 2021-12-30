package leetcode.bst;

public class ValidateBinarySearchTree {

    static int Root_VAL = 0;
    static int count =0;

    public static void main(String[] args) {
        Node root = new Node(-2147483648);

//        root.left = new Node(-2147483648);
//[-2147483648,null,2147483647]
        root.right = new Node(2147483647);
//        root.right.left = new Node(3);
//        root.right.right = new Node(7);


        System.out.println(isValidBST(root));
    }

    static boolean isValidBST(Node root) {
        Root_VAL = Integer.MIN_VALUE;
        if(root != null && root.data == Root_VAL && root.left ==null & root.right == null){
            return true;
        }
       return isValidBSTUtil(root);
    }

    private static boolean isValidBSTUtil(Node root) {

        if (root == null) {
            return true;
        }

        boolean left = isValidBSTUtil(root.left);

        if (root.data == Integer.MIN_VALUE && count ==0){
            count++;
        }
        else if( root.data > Root_VAL){
            Root_VAL = root.data;
        }else{
            return false;
        }

       return left && isValidBSTUtil(root.right);
    }



}
