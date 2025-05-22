package tries;

public class Trie {
    private static class TrieNode {
        char value;
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }
    }

    TrieNode root = new TrieNode(' ');

    public void insert(String word) {
        int index;
        for(var ch : word.toCharArray()) {
            index = ch - 'a';

        }
    }
}
