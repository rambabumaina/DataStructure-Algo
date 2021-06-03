package geeksforgeeks.amazon.tree;

//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
public class MaximumPathSum2LeafNodes {

    public static void main(String[] args) {

//        Node root = new Node(-15);
//        root.left = new Node(5);
//        root.right = new Node(6);
//
//        root.left.left = new Node(-8);
//        root.left.right = new Node(1);
//        root.right.left = new Node(3);
//        root.right.right = new Node(9);
//
//        root.left.left.left = new Node(2);
//        root.left.left.right = new Node(-3);
//        root.right.right.right = new Node(0);
//
//        root.right.right.right.left = new Node(4);
//        root.right.right.right.right = new Node(-1);
//        root.right.right.right.right.left = new Node(10);

        Node roo = new Node(-9);
        roo.left = new Node(6);
        roo.right = new Node(-10);

        System.out.println(maxPathSum(roo));


    }


    static int maxPathSum(Node root) {
        Res res = new Res();
        maxPathSum_util(root, res);
        return res.val;
    }

    static int maxPathSum_util(Node root, Res res) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if(root.left ==null && root.right == null){
            return root.data;
        }

        int left = maxPathSum_util(root.left,  res);
        int right = maxPathSum_util(root.right, res);


        if(root.left !=null && root.right != null){
            int temp = root.data + left + right;
            res.val = Math.max(temp, res.val);
            return Math.max(root.data + left, root.data + right);
        }

        return root.left ==null ? right+root.data :left+ root.data;
    }
}


class Res {
    int val = Integer.MIN_VALUE;
}