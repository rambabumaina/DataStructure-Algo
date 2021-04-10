package geeksforgeeks.amazon.tree;

import java.util.Stack;

public class ConstructTreePreorderTraversal {

    public static void main(String[] args) {
        ConstructTreePreorderTraversal c = new ConstructTreePreorderTraversal();

//        int pre[] =    {10,  30,  20,  5,   15};
//        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
        int pre[] =    {10,  20};
        char preLN[] = {'N', 'L'};

//        Node root = c.constructTree(pre.length, pre, preLN);

        Node root = c.constructTreeRe(pre.length, pre, preLN);

        //ROOt , left , Right
        preOrderPrintTree(root);
        System.out.println();
        //left , ROOt, Right
        InOrderPrintTree(root);
        System.out.println();
        //left , Right, ROOt
        PostOrderPrintTree(root);



    }

    public Node constructTree(int n, int pre[], char preLN[]) {

        Stack<Node> stack = new Stack<>();

        int i = 0;
        Node temp = new Node(pre[i]);
        Node root = temp;

        while (i < n-1){

            if(preLN[i] == 'N'){
                stack.push(temp);
                i++;
                temp.left = new Node(pre[i]);
                temp = temp.left;
            }else{
                    if (!stack.isEmpty())
                    temp = stack.pop();

                    i++;
                    temp.right = new Node(pre[i]);
            }
        }

        return root;
    }

    private static void preOrderPrintTree(Node root) {

        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);

    }

    private static void InOrderPrintTree(Node root) {

        if(root == null){
            return;
        }

        InOrderPrintTree(root.left);
        System.out.print(root.data + " ");
        InOrderPrintTree(root.right);

    }

    private static void PostOrderPrintTree(Node root) {

        if(root == null){
            return;
        }

        PostOrderPrintTree(root.left);
        PostOrderPrintTree(root.right);
        System.out.print(root.data + " ");

    }




    //Recurssion
    int index = 0;
    Node constructTreeRe(int n, int pre[], char preLN[]){
        index = 0;
        return constructTreeUtil(n,pre,preLN);
    }

    Node constructTreeUtil(int n,int pre[], char preLN[]){

        if(index < n){
            if(preLN[index] == 'L'){
                return new Node(pre[index++]);
            } else{

                Node root = new Node(pre[index++]);

                root.left = constructTreeUtil(n,pre,preLN);
                root.right = constructTreeUtil(n,pre,preLN);
                return root;
            }
        }
        return null;
    }
}
