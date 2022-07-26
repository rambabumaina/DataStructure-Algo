package yashasvi.binaryTree;

import java.util.Stack;

/* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8

iterativePreorder(node){

if (node = null)
  return
s —> empty stack
s.push(node)
while (not s.isEmpty())
  node —> s.pop()
  visit(node)
  if (node.right != null)
    s.push(node.right)
  if (node.left != null)
    s.push(node.left)
 }
*/
public class Tree_Traversals_Iterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        preOrder(root);

        inorder(root);

        postOrder(root);
    }

    //NODE , LEFT, RIGHT
    private static void preOrder(TreeNode root) {
        System.out.println("Preorder........");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                root = tmp.right;
            }
        }
        System.out.println();
    }

    //LEFT, NODE, RIGHT
    private static void inorder(TreeNode root) {
        System.out.println("Inorder........");
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                System.out.print(tmp.data + " ");
                root = tmp.right;
            }
        }
        System.out.println();
    }

    //Two stack approach
    private static void postOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        System.out.println("Postorder........");

        s1.push(root);

        while(!s1.isEmpty()){
           TreeNode temp = s1.pop();
           s2.push(temp);

           if (temp.left !=null) s1.push(temp.left);
           if (temp.right !=null) s1.push(temp.right);
        }

        while (!s2.isEmpty()) System.out.print(s2.pop().data +" ");

        System.out.println();
    }
}
