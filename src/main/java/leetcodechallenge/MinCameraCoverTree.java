package leetcodechallenge;

public class MinCameraCoverTree {

    static int count = 0;
    static int leftNUll =0;
    static int rightNUll =0;

    public static void main(String[] args) {
//        Node node = new Node(1);
//        node.left = new Node(2);
//        node.right = new Node(3);
//
//        node.left.left = new Node(4);
//        node.left.right = new Node(5);
//        node.left.right.right = new Node(8);
//
//
//        node.right.left = new Node(6);
//        node.right.right = new Node(7);
//        node.right.right.right = new Node(9);


        Node node = new Node(1);
        node.left = new Node(2);

        node.left.right = new Node(3);
        node.left.right.left = new Node(4);
        node.left.right.left.right = new Node(5);
        node.left.right.left.right.left = new Node(6);



        fixCamera(node);
        System.out.println(count);
    }

    private static int fixCamera(Node root){
        count =0;
        if(root ==null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        fixCamera_util(root);
        return count;
    }


    private static int fixCamera_util(Node root) {

        if (root == null) {
            return -1;
        }

        int left = fixCamera_util(root.left);
        int right = fixCamera_util(root.right);

        if ((left == -1 && right == -1) || (left == 1 && right == 1)) {
            rightNUll=0;
            leftNUll=0;
            return 0;
        } else if (((left == -1 && right == 0)) || (left == 0 && right == -1) ||
                (left == 0 && right == 0) || (left == 1 && right == 0) || (left == 0 && right == 1)) {
            count++;
            rightNUll=0;
            leftNUll=0;
            return 1;
        } else if((left == -1 && right == 1) || (left == 1 && right == -1)) {

            if ((left == 1 && right == -1)) {
                rightNUll++;
                if (rightNUll == 1) {
                    count++;
                    rightNUll = 0;
                    leftNUll = 0;
                }
            }
            if ((left == -1 && right == 1)) {
                leftNUll++;
                if (leftNUll == 1) {
                    count++;
                    leftNUll = 0;
                    rightNUll = 0;
                }
            }

            return 1;
        }else {
            return 0;
        }
    }
}
