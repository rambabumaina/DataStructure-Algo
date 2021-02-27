package amazon.tree;

public class MaximumDifferenceBetweenNode {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right.left = new Node(13);

        System.out.println(maxDiff(root));

    }

    static int MAX = Integer.MIN_VALUE;

    static int maxDiff(Node root) {
        maxDiffUtil(root);
        return MAX;
    }

    static int maxDiffUtil(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int left = maxDiffUtil(root.left);
        int right = maxDiffUtil(root.right);

        int min = Math.min(left, right);
        int maxValue = root.data - min;

        MAX = Math.max(MAX, maxValue);
        return Math.min(root.data, min);
    }
}
