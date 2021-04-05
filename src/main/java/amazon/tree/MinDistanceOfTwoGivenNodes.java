package amazon.tree;

//https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
public class MinDistanceOfTwoGivenNodes {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        int n1 = 4;
        int n2 = 7;
        System.out.println(findDist(node, n1, n2));
    }

   static int findDist(Node root, int a, int b) {
       Node LCA = fidLCA(root, a, b);
       int dist_lca = distanceFromRoot(root, LCA.data);

       int dist_n1 = distanceFromRoot(root, a);
       int dist_n2 = distanceFromRoot(root, b);

       return ((dist_n1+dist_n2) -2*dist_lca);
    }

    private static Node fidLCA(Node root, int n1, int n2) {

        if (root == null) {
            return root;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = fidLCA(root.left, n1, n2);
        Node right = fidLCA(root.right, n1, n2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }


    static int distanceFromRoot(Node root, int data) {
        if (root == null) {
            return 0;
        }
        if (root.data == data) {
            return 1;
        }

        int left = distanceFromRoot(root.left, data);
        int right = distanceFromRoot(root.right, data);

        if (left == 0 && right == 0) {
            return 0;
        } else {
            return right + left + 1;
        }
    }
}
