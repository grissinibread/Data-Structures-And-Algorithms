import heaps.Heap;
import heaps.MaxHeap;
import tries.Trie;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("canada");
        trie.insert("can");
        trie.insert("bread");
        trie.insert("breast");

        trie.traverse();
    }

}