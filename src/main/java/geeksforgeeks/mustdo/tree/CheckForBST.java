package geeksforgeeks.mustdo.tree;

//https://practice.geeksforgeeks.org/problems/check-for-bst/1
public class CheckForBST {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(22);

        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.right = new Node(25);

        root.left.right.left = new Node(12);
        root.left.right.right = new Node(18);

        System.out.println(isBST(root));
    }

    static boolean isBST(Node root) {

        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Best Approach
    // Compare if root data is in between min and max
    private static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max) {
            return false;
        }
        return isBSTUtil(root.left, min, root.data) &&
                isBSTUtil(root.right, root.data, max);
    }


    private static boolean isBSTUtil(Node root, CustomNode r) {
        if (root == null) return true;

        isBSTUtil(root.left, r);
        if (r.targetValue > root.data) {
            r.idBST = false;
        } else {
            r.targetValue = root.data;
        }
        return r.idBST && isBSTUtil(root.right, r);
    }
}

class CustomNode {
    int targetValue = Integer.MIN_VALUE;
    boolean idBST = true;
}




