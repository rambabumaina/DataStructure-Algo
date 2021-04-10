package geeksforgeeks.microsoft.tree;

public class LCP_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);

        root.left.left = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        root.right.right.left = new Node(7);
        LCP_LongestConsecutiveSequence l = new LCP_LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(root));

    }

    public int longestConsecutive(Node root) {
        if (root == null)
            return 0;

        Res r = new Res();
        lcp(root, 0, root.data, r);
        return r.max ==1 ? -1 : r.max;
    }

    public void lcp(Node root, int current, int expected_data, Res r) {
        if (root == null) {
            return;
        }

        if (root.data == expected_data) {
            current++;
        } else {
            current = 1;
        }

        r.max = Math.max(r.max, current);

        lcp(root.left, current, root.data + 1, r);
        lcp(root.right, current, root.data + 1, r);
    }

    static class Res {
        int max;
    }
}
