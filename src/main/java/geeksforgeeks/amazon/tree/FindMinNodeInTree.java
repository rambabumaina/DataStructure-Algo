package geeksforgeeks.amazon.tree;

public class FindMinNodeInTree {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left=new Node(3);
        root.right=new Node(10);

        root.left.left=new Node(1);
        root.left.right=new Node(6);
        root.right.right=new Node(14);

        root.left.right.left=new Node(4);
        root.left.right.right=new Node(7);
        root.right.right.left=new Node(13);

        System.out.println( getMin(root));
    }

    private static int getMin(Node root) {
        if (root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return root.data;
        }

        int left = getMin(root.left);
        int right = getMin(root.right);

        return Math.min(left,right);
    }
}
