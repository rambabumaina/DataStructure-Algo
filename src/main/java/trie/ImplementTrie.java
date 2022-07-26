package trie;

import java.util.HashMap;

public class ImplementTrie {

   static TrieNode root = new TrieNode();
    public static void main(String[] args) {
        String str = "ram";
        insert(str);
    }

    private static void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            TrieNode node = current.child.get(c);

            if (node == null){
                node = new TrieNode();
                current.child.put(c,node);
            }
            current = node;
        }
        current.endOfWord =true;
    }

    private static void insertRecursive(String word, TrieNode root, int index) {
       if(index == word.length()){
           root.endOfWord = true;
           return;
       }
        char c = word.charAt(index);
        if (!root.child.containsKey(c)){
            root.child.put(c, new TrieNode());
        }
        insertRecursive(word, root.child.get(c), index+1);
    }

    private static class TrieNode{
        private HashMap<Character, TrieNode> child;
        private boolean endOfWord;
        TrieNode(){
            child = new HashMap<>();
            endOfWord = false;
        }
    }
}
