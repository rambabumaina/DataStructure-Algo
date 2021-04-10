package geeksforgeeks.amazon.tree;

//https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
public class LowestCommonAncestorBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);


        root.left.left=new Node(4);
        root.left.right=new Node(5);

        Node lca = lca(root, 3, 5);
        System.out.println(lca.data);

//        System.out.println(findLCA_Recurssive(root, 3, 5));

    }


    static Node findLCA_Recurssive(Node root, int n1, int n2){

        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node left = findLCA_Recurssive(root.left, n1, n2);
        Node right = findLCA_Recurssive(root.right, n1, n2);

        if(left ==null){
            return right;
        }

        if(right ==null){
            return left;
        }
        return root;
    }



    static Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        int height = getHeight(root);
        int[] a1 = new int[height];
        int[] a2 = new int[height];
        int index= 0;
        storePath(root, a1, n1, index);
        storePath(root, a2, n2, index);

        return new Node(findLca(a1, a2));
    }

    //Return previous match
    private static int findLca(int[] a1, int[] a2) {
        int i = 0;
        while (i< a1.length && i <a2.length){
            if(a1[i] != a2[i]){
                return a1[i-1];
            }
            i++;
        }
        return -1;
    }

    private static boolean storePath(Node root, int[] a1, int n1, int index) {
        if (root == null){
            return false;
        }
        a1[index] = root.data;

        if(root.data ==n1){
            return true;
        }

        return  storePath(root.left,a1,n1,index+1) || storePath(root.right,a1,n1,index+1);
    }


    private static int getHeight(Node root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
}
