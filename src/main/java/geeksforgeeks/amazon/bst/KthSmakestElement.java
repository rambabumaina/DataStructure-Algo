package geeksforgeeks.amazon.bst;

public class KthSmakestElement {

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        int k = 2;


    }

    public int KthSmallestElement(Node root, int K)
    {
        ResultNode re = new ResultNode();
        KthSmallestElement_util(root,K, re);
        return re.node;
    }

    public static void KthSmallestElement_util(Node root, int k, ResultNode re)
    {
        if (root == null)
            return;

        KthSmallestElement_util(root.left, k, re);
        re.index++;
        if(re.index == k){
            re.node = root.data;
        }
        KthSmallestElement_util(root.right, k, re);
    }

    class ResultNode {
        int index = 0;
        int node = -1;
    }
}


