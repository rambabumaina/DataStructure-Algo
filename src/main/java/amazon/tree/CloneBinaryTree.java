package amazon.tree;

import java.util.HashMap;

public class CloneBinaryTree {
    public static void main(String[] args) {
        Tree tree = new Tree(6);

        tree.left = new Tree(3);
        tree.right = new Tree(8);

        tree.left.left = new Tree(1);
        tree.left.right = new Tree(5);

        //Set Random Pointers
        tree.left.left.random = tree.left;
        tree.left.right.random = tree;

        inorder(tree);
        System.out.println();
        cloneTree(tree);

    }

        public static Tree cloneTree(Tree tree) {
            HashMap<Tree, Tree> map = new HashMap<>();
            Tree result = cloneTree_util(tree, map);

            setRandom(tree, result, map);
            return result;
        }

        private static void setRandom(Tree tree, Tree result, HashMap<Tree, Tree> map) {
            if (tree == null) {
                return;
            }

            if (tree.random != null) {
                result.random = map.get(tree.random);
            }

            setRandom(tree.left, result.left, map);
            setRandom(tree.right, result.right, map);
        }


        private static Tree cloneTree_util(Tree tree1, HashMap<Tree, Tree> map) {

            if (tree1 == null) {
                return null;
            }

            Tree tree2 = new Tree(tree1.data);
            map.put(tree1, tree2);
            tree2.left = cloneTree_util(tree1.left, map);
            tree2.right = cloneTree_util(tree1.right, map);

            return tree2;
        }

    private static void inorder(Tree result) {
        if (result == null) {
            return;
        }

        inorder(result.left);
        inorder(result.right);
        System.out.print(result.data + " ");
    }


    static class Tree {
        int data;
        Tree left, right, random;

        public Tree(int data) {
            this.data = data;
        }
    }
}
