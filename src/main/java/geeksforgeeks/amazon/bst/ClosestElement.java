package geeksforgeeks.amazon.bst;

//https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1#
public class ClosestElement {
    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(2);
        root.right = new Node(11);

        root.left.left = new Node(1);
        root.left.right = new Node(5);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(6);

        root.left.right.left.right = new Node(4);

//        System.out.println(maxDiff(root, 13));

        Res r = new Res();
        findClosest(root, 13, r);

        System.out.println(r.nearest);

    }

    static int maxDiff(Node root, int K) {
        Res r = new Res();
        maxDiff_util(root, K, r);
        return r.nearest;
    }

    private static void maxDiff_util(Node root, int k, Res r) {
        if (root == null) {
            return;
        }

        int diff = root.data > k ? root.data - k : k - root.data;

        if (diff < r.nearest) {
            r.nearest = diff;
        }

        maxDiff_util(root.left, k, r);
        maxDiff_util(root.right, k, r);
    }

    private static void findClosest(Node root, int k, Res r) {
        if (root == null) {
            return;
        }

        if (Math.abs(root.data - k) < r.nearest) {
            r.nearest = Math.abs(root.data - k);
        }

        if (root.data > k) {
            findClosest(root.left, k, r);
        } else if (root.data < k) {
            findClosest(root.right, k, r);
        } else {
            return;
        }
    }

    static class Res {
        int nearest = Integer.MAX_VALUE;
    }
}
