package tries;

import java.util.Arrays;
import java.util.HashMap;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private static class TrieNode {
        private char value;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }

        public Boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch)  {
            return children.get(ch);
        }

        public TrieNode[] getChildern() {
            return children.values().toArray(new TrieNode[0]);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        var current = root;
        for(var ch : word.toCharArray()) {
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public Boolean contains(String word) {
        if(word == null)
            return false;

        var current = root;
        for(var ch : word.toCharArray()) {
            if(!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(TrieNode root) {
        for(var child: root.getChildern())
            traverse(child);

        System.out.println(root.value);
    }
}