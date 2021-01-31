package javaProblems;

public class BinarySearchRecursion {

    Node node = null;

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        BinarySearchRecursion re = new BinarySearchRecursion();

        System.out.println("\n Preorder :");
        //  (b) Preorder (Root, Left, Right) : 1 2 4 5 3
        re.preOrderTraversal(node);
        System.out.println("\n Inorder :");
        // (a) Inorder (Left, Root, Right) : 4 2 5 1 3
        re.inOrderTraversal(node);
        System.out.println("\n Postorder :");
        //  (c) Postorder (Left, Right, Root) : 4 5 2 3 1
        re.postOrderTraversal(node);
    }

    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
}
