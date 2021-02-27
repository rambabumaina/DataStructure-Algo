package amazon.tree;

public class CheckIfSubTree {

    public static void main(String[] args) {
        Node t = new Node(1);
        t.left = new Node(2);
        t.right = new Node(3);
        t.right.left = new Node(4);

        Node t1 = new Node(3);
        t1.left = new Node(4);

        System.out.println(isSubtree(t, t1));
    }

    public static boolean isSubtree(Node T, Node S) {
        if(T == null ){
           return false;
        }

        if(S ==null){
            return true;
        }

        return checkIfTwoTreesAreEqual(T, S) || isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    //Two trees are equal or not
    private static boolean checkIfTwoTreesAreEqual(Node t1, Node t2) {

        if (t1 == t2) {
            return true;
        }

        if (t1 != null && t2 != null) {
            return t1.data == t2.data && (checkIfTwoTreesAreEqual(t1.left, t2.left)
                    && checkIfTwoTreesAreEqual(t1.right, t2.right));
        }
        return false;
    }
}

