package tries;

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

        public TrieNode remove(char ch) {
            return children.remove(ch);
        }

        public TrieNode[] getChildern() {
            return children.values().toArray(new TrieNode[0]);
        }

        public Boolean hasChildren() {
            return !children.isEmpty();
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

    public void remove(String word) {
        if(word == null)
            return;

        remove(word, root, 0);
    }

    private void remove(String word, TrieNode root, Integer index) {
        if(index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child == null)
            return;

        remove(word, child, index + 1);

        if(!child.hasChildren() && !child.isEndOfWord)
            root.remove(ch);
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