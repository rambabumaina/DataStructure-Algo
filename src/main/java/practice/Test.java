package practice;

import amazon.tree.Node;


public class Test {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4;
        int n2 = 7;

        lca(root, n1, n2);
    }

    public static void lca(Node root, int n1, int n2) {
        int height = heightOfTree(root);
        int[] left_path = new int[height];
        int[] right_path = new int[height];

        System.out.println(lca_util(root, n1, n2));

    }

    private static Node lca_util(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca_util(root.left, n1, n2);
        Node right = lca_util(root.right, n1, n2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    private static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        return Math.max(left, right) + 1;
    }
}