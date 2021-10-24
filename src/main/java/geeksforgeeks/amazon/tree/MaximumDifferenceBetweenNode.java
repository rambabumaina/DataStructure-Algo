package geeksforgeeks.amazon.tree;

//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
public class MaximumDifferenceBetweenNode {
    public static void main(String[] args) {
            Node root = new Node(-9);
            root.left = new Node(6);
            root.right = new Node(-10);

//        root.left.left = new Node(100);
//        root.left.right = new Node(200);
//        root.right.right = new Node(14);

//        root.left.right.left = new Node(4);
//        root.left.right.right = new Node(7);
//        root.right.right.left = new Node(13);
        System.out.println(maxDiff(root));
    }

    static int MAXPATH = Integer.MIN_VALUE;

    static int maxDiff(Node root) {
        Res r = new Res();
        maxDiffUtil(root);
        return MAXPATH;
    }

    static int maxDiffUtil(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }

        int lSum = maxDiffUtil(root.left);
        int rSum = maxDiffUtil(root.right);

        if (root.left != null && root.right != null) {
            MAXPATH = Math.max(MAXPATH, lSum+rSum+ root.data);
            return Math.max(lSum,rSum) + root.data;
        }

       return (root.left == null)? rSum+ root.data : lSum + root.data;
    }

}
