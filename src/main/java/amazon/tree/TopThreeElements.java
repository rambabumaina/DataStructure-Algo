package amazon.tree;

//https://www.geeksforgeeks.org/top-three-elements-binary-tree/
public class TopThreeElements {
    static int first = 0, second = 0, third = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        nTopElements(root);

    }

    private static void nTopElements(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(first + " " + second + " " + third);

        if (root.data > first) {
            third = second;
            second = first;
            first = root.data;

        } else if (root.data > second && root.data != first) {
            third = second;
            second = root.data;
        } else if (root.data > third && root.data != second && root.data != first) {
            third = root.data;
        }

        nTopElements(root.left);
        nTopElements(root.right);
    }
}
