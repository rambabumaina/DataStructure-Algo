package geeksforgeeks.amazon.tree;

public class MaximumDepthORHight {
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        System.out.println(findMaxHight(root));
    }

    private static int findMaxHight(Node root){

        if(root ==null){
            return 0;
        }

        int left = findMaxHight(root.left);
        int right = findMaxHight(root.right);

        return Math.max(left,right)+1;
    }
}
