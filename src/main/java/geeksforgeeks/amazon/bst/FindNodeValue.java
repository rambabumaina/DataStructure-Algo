package geeksforgeeks.amazon.bst;

public class FindNodeValue {

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(15);
        root.right = new Node(10);

        root.left.left = new Node(10);
        root.left.right = new Node(10);

    }
}
